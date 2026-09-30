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
    data class Success(val books: List<Book>) : HomeUiState
    object Error : HomeUiState
    object Loading : HomeUiState
}

class HomeViewModel(private val bookRepository: BookRepository) : ViewModel() {
    private val _uiState = MutableStateFlow<HomeUiState>(HomeUiState.Loading)
    val uiState: StateFlow<HomeUiState> = _uiState.asStateFlow()

    init {
        getBooks()
    }

    fun getBooks(){
        viewModelScope.launch {
            _uiState.update { HomeUiState.Loading }

            try {
                val books = bookRepository.getBooks(query = "jazz+history")
                Log.d("VIEWMODEL", books.firstOrNull()?.volumeInfo?.imageLinks?.thumbnail ?: "No thumbnail")
                _uiState.update { HomeUiState.Success(books = books) }
            } catch (e: Exception) {
                Log.d("VIEWMODEL", e.message.toString())
                _uiState.update { HomeUiState.Error }
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