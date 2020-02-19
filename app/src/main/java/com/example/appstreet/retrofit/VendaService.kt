package com.example.appstreet.retrofit

import com.example.appstreet.modelo.Venda
import retrofit2.Call
import retrofit2.http.GET

interface VendaService {

    @GET("vendas")
    fun buscaTodas() : Call<MutableList<Venda>>
}