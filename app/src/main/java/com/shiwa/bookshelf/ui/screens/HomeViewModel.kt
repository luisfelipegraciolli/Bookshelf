package com.shiwa.bookshelf.ui.screens

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.shiwa.bookshelf.BookshelfApplication
import com.shiwa.bookshelf.data.BookRepository
import com.shiwa.bookshelf.model.Book
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

sealed interface HomeUiState{

    data class Success(
        val books: List<Book>,
        val isLoadingMore: Boolean = false,
        val canLoadMore: Boolean = true
    ) : HomeUiState
    object Error : HomeUiState
    object Loading : HomeUiState

}

class HomeViewModel(private val bookRepository: BookRepository) : ViewModel() {
    private val _uiState = MutableStateFlow<HomeUiState>(HomeUiState.Loading)
    val uiState: StateFlow<HomeUiState> = _uiState.asStateFlow()
    private var currentQuery: String = "jazz+history"

    init {
        getBooks()
    }

    fun getBooks(query: String = "jazz+history"){
        currentQuery = query
        viewModelScope.launch {
            _uiState.update { HomeUiState.Loading }

            try {
                val books = bookRepository.getBooks(query = query, maxResults = 20, startIndex = 0)
                Log.d("VIEWMODEL", books.firstOrNull()?.volumeInfo?.imageLinks?.thumbnail ?: "No thumbnail")
                _uiState.update {
                    HomeUiState.Success(
                        books = books,
                        canLoadMore = books.size >= 20
                    )
                }
            } catch (e: Exception) {
                Log.d("VIEWMODEL", e.message.toString())
                _uiState.update { HomeUiState.Error }
            }
        }
    }

    fun loadMoreBooks(){
        val currentState = _uiState.value as? HomeUiState.Success ?: return
        if(currentState.isLoadingMore || !currentState.canLoadMore){
            return
        }
        _uiState.update { currentState.copy(isLoadingMore = true) }

        viewModelScope.launch {
            try {

                val newBooks = bookRepository.getBooks(
                    query = currentQuery,
                    maxResults = 20,
                    startIndex = currentState.books.size
                )

                _uiState.update {
                    HomeUiState.Success(
                        books = currentState.books,
                        canLoadMore = newBooks.size >= 20,
                        isLoadingMore = false
                    )
                }

            } catch (e: Exception){
                Log.d("VIEWMODEL", e.message.toString())
                _uiState.update { currentState.copy(isLoadingMore = false) }
            }
        }
    }

    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val app = (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as BookshelfApplication)
                val booksRepository = app.container.bookRepository
                HomeViewModel(bookRepository = booksRepository)
            }
        }
    }
}