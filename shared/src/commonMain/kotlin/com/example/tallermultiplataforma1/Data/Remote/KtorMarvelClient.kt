package com.example.tallermultiplataforma1.Data.Remote
import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.client.request.parameter
import io.ktor.client.request.url
import io.ktor.http.parameters
import com.example.tallermultiplataforma1.Data.Model.CharactersResponse
import com.example.tallermultiplataforma1.Data.Utils.Keys
import io.ktor.client.request.accept
import io.ktor.http.ContentType
import io.ktor.client.call.body


class KtorMarvelClient(private val client: HttpClient) {

    suspend fun getAllCharacters(
        timestamp: Long,
        hash: String
    ): CharactersResponse {
        return client.get("https://gateway.marvel.com/v1/public/characters") {
            url {
                parameters.append("ts", timestamp.toString())
                parameters.append("hash", hash)
                parameters.append("apikey", Keys.PUBLIC_KEY)
            }
            accept(ContentType.Application.Json)
        }.body()
    }
}