package com.example.appstreet.retrofit

import com.example.appstreet.modelo.Produto
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ProdutoService {

    @GET("produtos")
    fun buscaTodos(): Call<List<Produto>>

    @POST("produtos")
    fun insere(@Body produto: Produto): Call<Produto>
}