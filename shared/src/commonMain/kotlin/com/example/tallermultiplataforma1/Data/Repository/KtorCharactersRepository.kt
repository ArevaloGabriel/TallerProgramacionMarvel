package com.example.tallermultiplataforma1.Data.Repository
import com.example.tallermultiplataforma1.Data.Remote.KtorMarvelClient
import com.example.tallermultiplataforma1.Data.Model.MarvelCharacter
class KtorCharactersRepository(
    private val apiClient: KtorMarvelClient
) : CharactersRepository {
    override suspend fun getCharacters(timestamp: Long, md5: String): List<MarvelCharacter> {
        val response = apiClient.getAllCharacters(timestamp, md5)
        return response.characters.list.map {
            MarvelCharacter(
                id = it.id,
                name = it.name,
                description = it.description,
                thumbnailUrl = it.thumbnail.toUrl()
            )
        }
    }
}