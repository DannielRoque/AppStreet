package com.example.appstreet.retrofit

import com.example.appstreet.modelo.Cliente
import retrofit2.Call
import retrofit2.http.GET

interface ClienteService {

    @GET("clientes")
    fun buscaTodos() : Call<MutableList<Cliente>>
}