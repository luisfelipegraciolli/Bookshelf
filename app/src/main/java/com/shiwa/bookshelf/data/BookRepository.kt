package com.shiwa.bookshelf.data

import com.shiwa.bookshelf.BuildConfig
import com.shiwa.bookshelf.model.Book
import com.shiwa.bookshelf.model.Volumes
import com.shiwa.bookshelf.network.ApiService


// Obtém um conjunto de livros
//https://www.googleapis.com/books/v1/volumes?q=jazz+history&key=API_KEY
// Obtém um livro especifico desse conjunto
//https://www.googleapis.com/books/v1/volumes/gK98gXR8onwC?key=API_KEY


interface BookRepository {
    suspend fun getBooks(query: String): List<Book>
    suspend fun getBook(id: String): Book
}

class BookRepositoryImpl(private val apiService: ApiService) : BookRepository {
    override suspend fun getBooks(query: String): List<Book> {
    // val validQuery = query.replace(" ", "+")
        val validQuery = "jazz+history"
        return apiService.getBooks(
            validQuery = validQuery,
            apiKey = BuildConfig.API_KEY
        ).items
    }


    override suspend fun getBook(id: String): Book {
        return apiService.getBook(
            id = id,
            apiKey = BuildConfig.API_KEY
        )
    }

}
