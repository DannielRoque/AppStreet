package com.example.appstreet.retrofit

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class StreetRetrofit {

    private val client by lazy {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        OkHttpClient.Builder()
            .addInterceptor(interceptor)
            .build()
    }

    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl("http://192.168.0.102:8000/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
    }

    val produtoService: ProdutoService by lazy {
        retrofit.create(ProdutoService::class.java)
    }

    val clienteService : ClienteService by lazy {
        retrofit.create(ClienteService::class.java)
    }

}
