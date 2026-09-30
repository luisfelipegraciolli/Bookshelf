package com.shiwa.bookshelf.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Volumes(
    val kind: String? = null,
    val totalItems: Long = 0,
    @SerialName("items")
    val books: List<Book>? = emptyList()
)
