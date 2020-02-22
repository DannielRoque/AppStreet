package com.example.appstreet.retrofit

import com.example.appstreet.modelo.Cliente
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ClienteService {

    @GET("clientes")
    fun buscaTodos() : Call<MutableList<Cliente>>

    @POST("clientes")
    fun insereCliente(@Body cliente: Cliente) : Call<Cliente>
}