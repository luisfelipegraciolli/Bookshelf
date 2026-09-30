package com.shiwa.bookshelf.model

import kotlinx.serialization.Serializable

@Serializable
data class ImageLinks(
    val smallThumbnail: String? = null,
    val thumbnail: String? = null
) {
    val httpsThumbnail: String?
        get() = thumbnail?.replace("http://", "https://")
}
