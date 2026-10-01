package com.shiwa.bookshelf.fake

import com.shiwa.bookshelf.data.BookRepository
import com.shiwa.bookshelf.model.Book

class FakeBookRepository : BookRepository {
    override suspend fun getBooks(
        query: String,
        maxResults: Int,
        startIndex: Int
    ): List<Book> {
        return FakeDataSource.booksList
    }

    override suspend fun getBook(id: String): Book {
        return FakeDataSource.booksList.first()
    }
}