package com.shiwa.bookshelf.model

import kotlinx.serialization.Serializable

@Serializable
data class Volumes (
    val kind: String,
    val totalItems: Long,
    val items: List<Book>
)