package com.example.tallermultiplataforma1.Data.Model
import kotlinx.serialization.Serializable
import kotlinx.serialization.SerialName
@Serializable
data class CharacterData(
    @SerialName("results") val list: List<CharacterResult>
)