package com.example.tallermultiplataforma1.android.Data.Api
<<<<<<< HEAD
/*
=======

>>>>>>> 3b5de0bb81d49c5a6fc56742fab4b35dd707b034

import com.example.tallermultiplataforma1.android.Utils.PUBLIC_KEY
import okhttp3.Response

class PublicKeyInterceptor : okhttp3.Interceptor {
    override fun intercept(chain: okhttp3.Interceptor.Chain): Response {
        val request = chain.request()
        val url = request.url

        val newUrl = url.newBuilder()
            .addQueryParameter("apikey", PUBLIC_KEY)
            .build()

        return chain.proceed(
            request.newBuilder()
                .url(newUrl)
                .build()
        )
    }
<<<<<<< HEAD
}*/
=======
}
>>>>>>> 3b5de0bb81d49c5a6fc56742fab4b35dd707b034
