package com.example.tallermultiplataforma1.Data

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CharacterData(

@SerialName("results")
val list: List<CharacterResult>

)
