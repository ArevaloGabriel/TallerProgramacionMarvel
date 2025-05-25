package com.example.tallermultiplataforma1.android.Data.Model

import com.google.gson.annotations.SerializedName

data class CharacterData(
    @SerializedName("results")
    val list: List<CharacterResult>
)