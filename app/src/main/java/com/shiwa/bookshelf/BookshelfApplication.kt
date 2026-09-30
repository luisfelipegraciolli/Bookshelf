package com.shiwa.bookshelf

import android.app.Application
import com.shiwa.bookshelf.data.AppContainer
import com.shiwa.bookshelf.data.DefaultAppContainer

class BookshelfApplication : Application() {
    lateinit var container: AppContainer
    override fun onCreate() {
        super.onCreate()
        container = DefaultAppContainer()
    }
}
