package com.example.tallermultiplataforma1.Data

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CharacterResult(


    @SerialName("id")
    val id: Long,
    @SerialName("name")
    val name: String,
    @SerialName("description")
    val description: String,
    @SerialName("thumbnail")
    val thumbnail: Thumbnail
)
