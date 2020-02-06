package com.example.appstreet.retrofit

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class StreetRetrofit {
    private val retrofit: Retrofit

    val produtoService: ProdutoService
        get() = retrofit.create(ProdutoService::class.java)

    init {

        val logging = HttpLoggingInterceptor()
        logging.setLevel(HttpLoggingInterceptor.Level.BODY)
        val client = OkHttpClient.Builder()
            .addInterceptor(logging)
            .build()

        retrofit = Retrofit.Builder()
            .baseUrl("http://192.168.0.104:8000/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
    }
}
