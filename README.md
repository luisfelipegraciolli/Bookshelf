# Bookshelf 📚

A minimalist Android application built with Jetpack Compose to search and discover books using the Google Books API.

## Features

- 🔍 **Search**: Search for books by title, author, or topic.
- 📜 **Infinite Scrolling**: Paginated continuous loading of book results.
- 🎨 **Modern UI**: Clean layout built with Jetpack Compose and Material 3.

## Tech Stack

- **UI**: Jetpack Compose & Material 3
- **Architecture**: MVVM with `StateFlow`
- **Networking**: Retrofit & Kotlinx Serialization
- **Image Loading**: Coil 3
- **Concurrency**: Kotlin Coroutines

## Getting Started

1. Clone the repository:
   ```bash
   git clone https://github.com/luisfelipegraciolli/Bookshelf.git
   ```
2. Open the project in **Android Studio**.
3. Add your Google Books API key in `local.properties`:
   ```properties
   API_KEY=your_google_books_api_key
   ```
4. Build and run the app.
