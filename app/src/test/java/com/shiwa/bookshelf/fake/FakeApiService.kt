package com.shiwa.bookshelf.fake

import com.shiwa.bookshelf.model.Book
import com.shiwa.bookshelf.model.Volumes
import com.shiwa.bookshelf.network.ApiService

class FakeApiService : ApiService{
    override suspend fun getBooks(
        validQuery: String,
        apiKey: String,
        maxResults: Int,
        startIndex: Int
    ): Volumes {
        return FakeDataSource.volumes
    }

    override suspend fun getBook(
        id: String,
        apiKey: String
    ): Book {
        return FakeDataSource.booksList.first()
    }
}