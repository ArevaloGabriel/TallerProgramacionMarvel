package com.example.tallermultiplataforma1

import android.content.Context
import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.android.AndroidSqliteDriver
import com.example.marvelsql.AppDatabase

class AndroidPlatform : Platform {
    override val name: String = "Android ${android.os.Build.VERSION.SDK_INT}"
}

actual fun getPlatform(): Platform = AndroidPlatform()

<<<<<<< HEAD
=======
actual class DatabaseDriverFactory(private val context: Context) {
    actual fun createDriver(): SqlDriver {
        return AndroidSqliteDriver(
            AppDatabase.Schema, context,
            "marvel.db")
    }
}
>>>>>>> 3b5de0bb81d49c5a6fc56742fab4b35dd707b034
