package com.example.tallermultiplataforma1

import app.cash.sqldelight.db.SqlDriver

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform

