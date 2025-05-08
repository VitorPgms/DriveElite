package com.example.driveelite.api

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient {

    private const val BASE_URL = "https://api.api-ninjas.com/v1/"
    private const val API_KEY = "4I+Zk54GaPh7Vyq84NIKbg==TQdASZoX7LuCl1N9"

    internal val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .client(
            OkHttpClient.Builder().addInterceptor { chain ->
                val request = chain.request().newBuilder()
                    .addHeader("X-Api-Key", API_KEY)
                    .build()
                chain.proceed(request)
            }.build()
        )
        .build()

    var carApiService: Api = retrofit.create(Api::class.java)
}
