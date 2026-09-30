package com.shiwa.bookshelf.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.shiwa.bookshelf.model.Book



@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    uiState: HomeUiState
) {
    when (uiState) {
        is HomeUiState.Loading -> LoadingScreen(modifier = modifier)
        is HomeUiState.Success -> BookCard(book = uiState.books.getOrNull(0) ?: Book(), modifier = modifier)
        is HomeUiState.Error -> ErrorScreen(modifier = modifier)
    }
}

@Composable
fun ErrorScreen(modifier: Modifier = Modifier) {
    Text("Error!")
}

@Composable
fun LoadingScreen(modifier: Modifier = Modifier) {
    Text("Loading!")
}

@Composable
fun BookSearchBar(
    modifier: Modifier = Modifier,
    placeholder: String = "Search for a book",
    onSearch: (String) -> Unit
)
{
    var query by remember{mutableStateOf("")}

    Row(verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .fillMaxWidth()
            .height(48.dp)
            .clip(RoundedCornerShape(16.dp))
            .background(Color(0xFF2A2A2A))
    ){
        Box(
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .weight(1.0f),
            contentAlignment = Alignment.CenterStart

        ){
            if (placeholder.isNotEmpty()){
                Text(text = placeholder, color = Color.Gray)
            }
            BasicTextField(
                value = "",
                onValueChange = {query = it},
                singleLine = true,
                keyboardOptions = KeyboardOptions(imeAction = ImeAction.Search),
                keyboardActions = KeyboardActions(onSearch = {onSearch(query)}),
                modifier = Modifier.fillMaxWidth()
            )
        }

        Box(
            modifier = Modifier
                .fillMaxHeight()
                .width(64.dp)
                .background(Color(0xFF2A2A2A))
                .clickable { onSearch(query) },
            contentAlignment = Alignment.Center
        ){
            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = "Pesquisar",
                tint = Color.White
            )
        }
    }
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
//        AsyncImage(
//            model = book.volumeInfo.imageLinks?.thumbnail,
//            contentDescription = null,
//            placeholder = null,
//            error = null
//        )
        val bookTitle = book.volumeInfo.title ?: ""
        Text(text = bookTitle)
    }

}

@Preview(showBackground = true)
@Composable
fun BookSearchBarPreview() {
    BookSearchBar(onSearch = {})
}
