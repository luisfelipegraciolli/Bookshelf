package com.shiwa.bookshelf.model

import kotlinx.serialization.Serializable

@Serializable
data class VolumeInfo(
    val title: String? = "",
    val imageLinks: ImageLinks? = null
)
