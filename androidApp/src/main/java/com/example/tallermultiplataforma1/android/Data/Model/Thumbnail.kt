package com.example.tallermultiplataforma1.android.Data.Model
<<<<<<< HEAD
/*
=======

>>>>>>> 3b5de0bb81d49c5a6fc56742fab4b35dd707b034
import com.google.gson.annotations.SerializedName

data class Thumbnail(
    @SerializedName("path") val path: String,
    @SerializedName("extension") val extension: String
) {
    fun toUrl(): String {
        var url = "$path.$extension"
        if (url.startsWith("http://")) {
            url = url.replace("http://", "https://")
        }
        return url
    }
<<<<<<< HEAD
}*/
=======
}
>>>>>>> 3b5de0bb81d49c5a6fc56742fab4b35dd707b034
