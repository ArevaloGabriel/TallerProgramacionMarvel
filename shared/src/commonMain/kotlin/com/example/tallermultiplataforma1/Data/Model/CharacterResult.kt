package com.example.tallermultiplataforma1.Data.Model
import kotlinx.serialization.Serializable
import kotlinx.serialization.SerialName
@Serializable
data class CharacterResult(
    @SerialName("id") val id: Long,
    @SerialName("name") val name: String,
    @SerialName("description") val description: String,
    @SerialName("thumbnail") val thumbnail: Thumbnail
)