package com.example.tallermultiplataforma1.android.Data.Api


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
}