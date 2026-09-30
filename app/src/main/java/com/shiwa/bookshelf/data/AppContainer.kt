package com.shiwa.bookshelf.data

import com.shiwa.bookshelf.network.ApiService
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit
import retrofit2.converter.kotlinx.serialization.asConverterFactory

interface AppContainer {
    val bookRepository: BookRepository
}

class DefaultAppContainer : AppContainer {
    private val BASE_URL = "https://www.googleapis.com/books/v1/"
    // implement repository and retrofit call

    private val json: Json = Json { ignoreUnknownKeys = true }

    val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)

        .addConverterFactory(
            json.asConverterFactory("application/json".toMediaType())
        )
        .build()

    private val retrofitService : ApiService = retrofit.create(ApiService::class.java)


    override val bookRepository: BookRepository by lazy { BookRepositoryImpl(retrofitService) }

}