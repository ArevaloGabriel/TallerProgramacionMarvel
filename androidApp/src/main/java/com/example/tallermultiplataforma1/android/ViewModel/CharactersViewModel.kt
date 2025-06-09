package com.example.tallermultiplataforma1.android.ViewModel

import androidx.lifecycle.ViewModel
import com.example.tallermultiplataforma1.Data.CharacterService
import com.example.tallermultiplataforma1.Data.Model.MarvelCharacter
import androidx.lifecycle.ViewModelProvider
import com.example.tallermultiplataforma1.Data.Local.DatabaseHelper
import com.example.tallermultiplataforma1.Data.Repository.KtorCharactersRepository
import com.example.tallermultiplataforma1.Data.Remote.KtorMarvelClient
import io.ktor.client.HttpClient
import io.ktor.client.engine.android.Android
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import android.content.Context
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext


class CharactersViewModel(
    private val characterService: CharacterService,
    private val databaseHelper: DatabaseHelper
) : ViewModel() {

    suspend fun loadCharacters(): Pair<List<MarvelCharacter>, String> {
        return withContext(Dispatchers.IO) {
            try {
                val remoteCharacters = characterService.getCharacters()
                databaseHelper.clearAllCharacters()
                databaseHelper.insertCharacters(remoteCharacters)
                remoteCharacters to "Datos cargados desde la API"
            } catch (e: Exception) {
                val localCharacters = databaseHelper.getAllCharacters()
                localCharacters to "Datos cargados desde la base local"
            }
        }
    }
}