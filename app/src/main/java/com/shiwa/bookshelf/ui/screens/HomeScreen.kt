package com.shiwa.bookshelf.ui.screens

import android.widget.Space
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.shiwa.bookshelf.model.Book
import com.shiwa.bookshelf.model.ImageLink
import com.shiwa.bookshelf.model.VolumeInfo


@Composable
fun HomeScreen (
    modifier: Modifier = Modifier,
    uiState: HomeUiState
){
    when (uiState){
        is HomeUiState.Loading -> LoadingScreen(modifier = modifier)
        is HomeUiState.Success -> BooksGridScreen(books = uiState.books, modifier = modifier)
        is HomeUiState.Error -> ErrorScreen(modifier = modifier)
    }
}

@Composable
fun ErrorScreen(modifier: Modifier) {
    TODO("Not yet implemented")
}

@Composable
fun LoadingScreen(modifier: Modifier) {
    TODO("Not yet implemented")
}

@Composable
fun BooksGridScreen(books: List<Book>, modifier: Modifier) {
    TODO("Not yet implemented")

}

@Composable
fun BookCard(book: Book, modifier: Modifier = Modifier) {
    Column(modifier = modifier.fillMaxSize()) {
        Text(text = "Book card")
        Spacer(modifier = Modifier.height(8.dp))
        AsyncImage(
            model = book.volumeInfo.imageLinks.thumbnail,
            contentDescription = null,
            placeholder = null,
            error = null
        )
        val bookTitle = book.volumeInfo.title
        Text(text = bookTitle)
    }

}

@Preview(showBackground = true)
@Composable
fun BookCardPreview(){
    BookCard(
        book = Book(
        kind = "",
        id = "",
        selfLink = "",
        volumeInfo = VolumeInfo(
            title = "idk",
            description = "",
            imageLinks = ImageLink(
                thumbnail = "myimageLinkToDisplay.com"
                )
            )
        ),
        modifier = Modifier.fillMaxSize()
    )
}
