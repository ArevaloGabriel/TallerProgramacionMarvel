package com.example.tallermultiplataforma1.Data.Model
import kotlinx.serialization.Serializable
import kotlinx.serialization.SerialName
@Serializable
data class Thumbnail(
    @SerialName("path") val path: String,
    @SerialName("extension") val extension: String
) {
    fun toUrl(): String {
        var url = "$path.$extension"
        if (url.startsWith("http://")) {
            url = url.replace("http://", "https://")
        }
        return url
    }
}