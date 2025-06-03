package com.example.tallermultiplataforma1

import app.cash.sqldelight.db.SqlDriver

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform

<<<<<<< HEAD
=======
expect class DatabaseDriverFactory {
    fun createDriver(): SqlDriver

}
>>>>>>> 3b5de0bb81d49c5a6fc56742fab4b35dd707b034
