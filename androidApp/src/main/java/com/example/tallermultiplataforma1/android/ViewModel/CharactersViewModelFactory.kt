package com.example.tallermultiplataforma1.android.ViewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider


import com.example.tallermultiplataforma1.Data.Repository.KtorCharactersRepository
import com.example.tallermultiplataforma1.Data.CharacterService

import okhttp3.OkHttpClient
import com.example.tallermultiplataforma1.Data.Repository.CharactersRepository
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import io.ktor.client.HttpClient
import io.ktor.client.engine.android.Android
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import com.example.tallermultiplataforma1.Data.Remote.KtorMarvelClient

class CharactersViewModelFactory : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        val client = HttpClient(Android) {
            install(ContentNegotiation) {
                json(Json {
                    ignoreUnknownKeys = true
                    isLenient = true
                })
            }
        }

        val apiClient = KtorMarvelClient(client)
        val repository = KtorCharactersRepository(apiClient)
        val service = CharacterService(repository)

        return CharactersViewModel(service) as T
    }
}