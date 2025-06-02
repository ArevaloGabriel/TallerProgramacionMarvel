package com.example.tallermultiplataforma1.Data.Model
import kotlinx.serialization.Serializable
import kotlinx.serialization.SerialName
@Serializable
data class CharactersResponse(
    @SerialName("data") val characters: CharacterData
)