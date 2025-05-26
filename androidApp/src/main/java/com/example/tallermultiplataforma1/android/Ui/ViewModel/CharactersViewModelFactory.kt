package com.example.tallermultiplataforma1.android.Ui.ViewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.tallermultiplataforma1.android.Data.Api.MarvelCharactersClient
import com.example.tallermultiplataforma1.android.Data.Api.PublicKeyInterceptor
import com.example.tallermultiplataforma1.android.Data.repository.RetrofitCharactersRepository
import okhttp3.OkHttpClient
import  com.example.tallermultiplataforma1.android.Data.Api.CharactersService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
class CharactersViewModelFactory : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        val okHttpClient = OkHttpClient.Builder()
            .addInterceptor(PublicKeyInterceptor())
            .build()

        val retrofit = Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl("https://gateway.marvel.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val apiClient = retrofit.create(MarvelCharactersClient::class.java)

        val charactersApi = RetrofitCharactersRepository(apiClient)
        val charactersService = CharactersService(charactersApi)
        return CharactersViewModel(charactersService) as T
    }
}