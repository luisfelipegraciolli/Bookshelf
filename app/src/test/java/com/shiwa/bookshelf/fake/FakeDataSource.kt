package com.shiwa.bookshelf.fake

import com.shiwa.bookshelf.model.Book
import com.shiwa.bookshelf.model.ImageLinks
import com.shiwa.bookshelf.model.VolumeInfo
import com.shiwa.bookshelf.model.Volumes

object FakeDataSource{
    val booksList = listOf(
        Book(
            id = "book1",
            volumeInfo = VolumeInfo(
                title = "Book 1",
                ImageLinks(
                    smallThumbnail = "https://example.com/book1_small.jpg",
                    thumbnail = "https://example.com/book1_large.jpg"
                )
            )
        ),
        Book(
            id = "book2",
            volumeInfo = VolumeInfo(
                title = "Book 2",
                ImageLinks(
                    smallThumbnail = "https://example.com/book2_small.jpg",
                    thumbnail = "https://example.com/book2_large.jpg"
                )
            )
        ),
        Book(
            id = "book3",
            volumeInfo = VolumeInfo(
                title = "Book 3",
                ImageLinks(
                    smallThumbnail = "https://example.com/book3_small.jpg",
                    thumbnail = "https://example.com/book3_large.jpg"
                )
            )
        )
    )

    val volumes = Volumes(
        books = booksList
    )
}