package com.shiwa.bookshelf.network

import com.shiwa.bookshelf.model.Book
import com.shiwa.bookshelf.model.Volumes
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
    @GET("volumes?q={valid_query}&key={API_KEY}")
    suspend fun getBooks(@Path("valid_query") validQuery: String, @Path("API_KEY") apiKey: String): Volumes

    @GET("volumes/{id}?key={API_KEY}")
    suspend fun getBook(@Path("id") id: String, @Path("API_KEY") apiKey: String): Book
}

