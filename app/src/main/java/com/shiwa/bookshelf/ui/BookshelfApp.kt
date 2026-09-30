package com.shiwa.bookshelf.ui

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import com.shiwa.bookshelf.ui.screens.HomeScreen
import com.shiwa.bookshelf.ui.screens.HomeUiState
import com.shiwa.bookshelf.ui.screens.HomeViewModel
import androidx.compose.runtime.collectAsState

@Composable
fun BookshelfApp(){
    val viewModel: HomeViewModel = viewModel(factory = HomeViewModel.Factory)
    HomeScreen(
        uiState = viewModel.uiState.collectAsState().value
    )
}