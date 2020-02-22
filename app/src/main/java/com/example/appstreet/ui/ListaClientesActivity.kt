package com.example.appstreet.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.appstreet.R
import com.example.appstreet.modelo.Cliente
import com.example.appstreet.retrofit.ClienteService
import com.example.appstreet.retrofit.StreetRetrofit
import com.example.appstreet.ui.adapter.ListaClientesAdapter
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_lista_clientes.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ListaClientesActivity : AppCompatActivity() {

    private lateinit var adapter : ListaClientesAdapter
    private val service : ClienteService = StreetRetrofit().clienteService

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_clientes)
        configuraToolbar()
        vaiParaFormularioCliente()
    }

    override fun onResume() {
        super.onResume()
        buscaClientes()
    }

    private fun buscaClientes(){
        val call = service.buscaTodos()
        call.enqueue(object : Callback<MutableList<Cliente>> {

            override fun onFailure(call: Call<MutableList<Cliente>>, t: Throwable) {
                Log.e("ROQUE", "Erro $t")
            }

            override fun onResponse(
                call: Call<MutableList<Cliente>>,
                response: Response<MutableList<Cliente>>
            ) {
             when{
                 response.isSuccessful->{
                     response.body()?.let {
                         val responseCliente : MutableList<Cliente> = response.body()!!
                         configuraRecyclerView(responseCliente)
                     }
                 }
             }
            }

        })
    }

    fun configuraRecyclerView(cliente : MutableList<Cliente>){
        Log.e("ROQUE", "cliente ${cliente.first()}")
        adapter = ListaClientesAdapter(cliente)
        lista_clientes_recyclerview.adapter = this.adapter
    }

    private fun vaiParaFormularioCliente() {
        val fab = botao_adiciona_cliente
        fab.setOnClickListener {
            val intent = Intent(this@ListaClientesActivity, FormularioClienteActivity::class.java)
            startActivity(intent)
        }
    }

    private fun configuraToolbar() {
        setSupportActionBar(toolbar_lista_clientes)
        supportActionBar!!.setTitle("Lista Cliente")
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }
}
