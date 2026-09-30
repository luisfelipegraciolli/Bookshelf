package com.shiwa.bookshelf.network

import com.shiwa.bookshelf.model.Book
import com.shiwa.bookshelf.model.Volumes
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {
    @GET("volumes")
    suspend fun getBooks(
        @Query("q") validQuery: String,
        @Query("key") apiKey: String
    ): Volumes

    @GET("volumes/{id}")
    suspend fun getBook(
        @Path("id") id: String,
        @Query("key") apiKey: String
    ): Book
}

