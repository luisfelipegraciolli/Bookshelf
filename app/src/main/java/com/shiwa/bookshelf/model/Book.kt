package com.shiwa.bookshelf.model

import kotlinx.serialization.Serializable

@Serializable
data class Book(
    val kind: String? = null,
    val id: String = "",
    val selfLink: String? = null,
    val volumeInfo: VolumeInfo = VolumeInfo()
)
