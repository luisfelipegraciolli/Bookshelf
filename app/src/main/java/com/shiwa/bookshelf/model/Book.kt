package com.shiwa.bookshelf.model

data class Book(
    val id: String,
    val title: String,
    val authors: List<String>,
    val description: String,
    val imageLink: String,
    val previewLink: String
)
