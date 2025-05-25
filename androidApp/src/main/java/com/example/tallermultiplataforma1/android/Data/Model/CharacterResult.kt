package com.example.tallermultiplataforma1.android.Data.Model

import com.google.gson.annotations.SerializedName

data class CharacterResult(
    @SerializedName("id") val id: Long,
    @SerializedName("name") val name: String,
    @SerializedName("description") val description: String,
    @SerializedName("thumbnail") val thumbnail: Thumbnail
)