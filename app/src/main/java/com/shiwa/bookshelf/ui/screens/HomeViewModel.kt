package com.shiwa.bookshelf.ui.screens

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.shiwa.bookshelf.model.Book
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import java.io.IOException

sealed interface HomeUiState{
    data class Success(val books: List<Book>) : HomeUiState
    object Error : HomeUiState
    object Loading : HomeUiState
}

class HomeViewModel : ViewModel() {
    private val _uiState = MutableStateFlow<HomeUiState>(HomeUiState.Loading)
    val uiState: StateFlow<HomeUiState> = _uiState.asStateFlow()

    init {
        getBooks()
    }

    fun getBooks(){
        viewModelScope.launch {
            _uiState.update { HomeUiState.Loading }

            try {
                // implement repository and retrofit call
                _uiState.update { HomeUiState.Success(books = listOf()) }
            } catch (Exeption: IOException){

            }
        }
    }
}