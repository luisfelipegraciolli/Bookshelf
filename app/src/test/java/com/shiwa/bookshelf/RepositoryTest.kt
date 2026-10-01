package com.shiwa.bookshelf

import com.shiwa.bookshelf.data.BookRepositoryImpl
import com.shiwa.bookshelf.fake.FakeApiService
import com.shiwa.bookshelf.fake.FakeDataSource
import com.shiwa.bookshelf.fake.FakeBookRepository
import com.shiwa.bookshelf.ui.screens.HomeUiState
import com.shiwa.bookshelf.ui.screens.HomeViewModel
import org.junit.Test
import kotlinx.coroutines.test.runTest

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class RepositoryTest {
    @Test
    fun repository_getBooks_verifyBookList() = runTest{
        val repository = BookRepositoryImpl(apiService = FakeApiService())
        assertEquals(FakeDataSource.booksList, repository.getBooks(query = "jazz+history"))
    }
}





