package com.shiwa.bookshelf.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import com.shiwa.bookshelf.ui.screens.HomeScreen
import com.shiwa.bookshelf.ui.screens.HomeViewModel
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.shiwa.bookshelf.R
import com.shiwa.bookshelf.ui.screens.BookSearchBar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BookshelfApp(){
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()
    Scaffold(
        topBar = { BookshelfTopAppBar(scrollBehavior = scrollBehavior) }
    ){ innerPadding ->
        Surface() {
            val viewModel: HomeViewModel = viewModel(factory = HomeViewModel.Factory)
            Column(verticalArrangement = Arrangement.SpaceEvenly) {
                BookSearchBar(
                    modifier = Modifier.padding(innerPadding),
                    onSearch = { viewModel.getBooks(it) }
                )
                HomeScreen(
                    uiState = viewModel.uiState.collectAsState().value,
                    modifier = Modifier.padding(innerPadding)
                )
            }
            }
        }
    }

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BookshelfTopAppBar(scrollBehavior: TopAppBarScrollBehavior, modifier: Modifier = Modifier) {
    CenterAlignedTopAppBar(
        scrollBehavior = scrollBehavior,
        title = {
            Text(
                text = stringResource(R.string.app_name),
                style = MaterialTheme.typography.headlineSmall,
            )
        },
        modifier = modifier
    )
}
