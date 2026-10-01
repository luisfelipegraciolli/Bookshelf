package com.shiwa.bookshelf.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.shiwa.bookshelf.R
import com.shiwa.bookshelf.ui.screens.BookSearchBar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BookshelfApp(){
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()
    val viewModel: HomeViewModel = viewModel(factory = HomeViewModel.Factory)
    Scaffold(
        topBar = { BookshelfTopAppBar(scrollBehavior = scrollBehavior, viewModel = viewModel) }
    ){ innerPadding ->
        Surface(modifier = Modifier.fillMaxSize()) {

            Column(
                verticalArrangement = Arrangement.SpaceEvenly,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
            ) {
                HomeScreen(
                    uiState = viewModel.uiState.collectAsState().value,
                    onLoadMore = { viewModel.loadMoreBooks() }
                )
            }
            }
        }
    }

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BookshelfTopAppBar(scrollBehavior: TopAppBarScrollBehavior, viewModel: HomeViewModel, modifier: Modifier = Modifier) {
    CenterAlignedTopAppBar(
        scrollBehavior = scrollBehavior,
        title = {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = stringResource(R.string.app_name),
                    style = MaterialTheme.typography.headlineSmall,
                )
                BookSearchBar(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp),
                    onSearch = { viewModel.getBooks(it) }
                )
                Spacer(modifier = Modifier.padding(4.dp))
            }

        },
        modifier = modifier
    )
}
