package com.example.tallermultiplataforma1.Data.Repository
import com.example.tallermultiplataforma1.Data.Model.MarvelCharacter
interface CharactersRepository {
    suspend fun getCharacters(timestamp: Long, md5: String): List<MarvelCharacter>
}