package com.shiwa.bookshelf

import androidx.compose.runtime.collectAsState
import com.shiwa.bookshelf.fake.FakeBookRepository
import com.shiwa.bookshelf.fake.FakeDataSource
import com.shiwa.bookshelf.rules.TestDispatcherRule
import com.shiwa.bookshelf.ui.screens.HomeUiState
import com.shiwa.bookshelf.ui.screens.HomeViewModel

import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Rule
import org.junit.Test

class HomeViewModelTest {
    @get:Rule
    val testDispatcher = TestDispatcherRule()

    @Test
    fun homeViewModel_getBooks_verifyHomeUiState() =
        runTest {
            val viewModel = HomeViewModel(
                bookRepository = FakeBookRepository()
            )

            assertEquals(HomeUiState.Success(FakeDataSource.booksList, canLoadMore = false),
                viewModel.uiState.value
            )
        }
}