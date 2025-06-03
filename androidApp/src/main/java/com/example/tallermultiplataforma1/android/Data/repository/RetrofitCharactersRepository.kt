package com.example.tallermultiplataforma1.android.Data.repository
<<<<<<< HEAD
/*
=======

>>>>>>> 3b5de0bb81d49c5a6fc56742fab4b35dd707b034
import com.example.tallermultiplataforma1.android.Data.Api.MarvelCharactersClient
import com.example.tallermultiplataforma1.android.Data.Model.Character
import com.example.tallermultiplataforma1.android.Data.Model.CharactersResponse

class RetrofitCharactersRepository(private val apiClient: MarvelCharactersClient) :
    CharactersRepository {

    override suspend fun getCharacters(timestamp: Long, md5: String): List<Character> {
        return apiClient.getAllCharacters(timestamp, md5).toModel()
    }

    private fun CharactersResponse.toModel(): List<com.example.tallermultiplataforma1.android.Data.Model.Character> {
        return this.characters.list.map {
            com.example.tallermultiplataforma1.android.Data.Model.Character(
                id = it.id,
                name = it.name,
                description = it.description,
                thumbnailUrl = it.thumbnail.toUrl()
            )
        }
    }
<<<<<<< HEAD
}*/
=======
}
>>>>>>> 3b5de0bb81d49c5a6fc56742fab4b35dd707b034
