package com.example.appstreet.ui

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem

import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.appstreet.R
import com.example.appstreet.modelo.Produto
import com.example.appstreet.retrofit.ProdutoService
import com.example.appstreet.retrofit.StreetRetrofit
import com.example.appstreet.ui.adapter.ListaProdutosAdapter
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private val service : ProdutoService = StreetRetrofit().produtoService
    val call  : Call<MutableList<Produto>> = service.buscaTodos()

    private lateinit var adapter : ListaProdutosAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        configuraToolBar()
        abreFormularioProduto()

        buscaProdutos()

    }

    fun buscaProdutos() {

        call.enqueue(object : Callback<MutableList<Produto>>{

            override fun onResponse(
                call: Call<MutableList<Produto>>,
                response: Response<MutableList<Produto>>
            ) {

                when{
                    response.isSuccessful->{
                        response.body()?.let {
                            val respostaProduto : MutableList<Produto> =
                                response.body()!!
                            configuraRecyclerView(respostaProduto)
                        }
                    }
                }

            }

            override fun onFailure(call: Call<MutableList<Produto>>, t: Throwable) {
                Log.e("ROQUE", "Falha $t")
            }
        })
    }

    private fun configuraRecyclerView(resposta : MutableList<Produto>){
        Log.e("Roque", "resposta $resposta")
        adapter = ListaProdutosAdapter(resposta)
        lista_produtos_recyclerview.adapter = adapter
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.menu_cliente_pagamento, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.menu_cliente) {
            val intent = Intent(this, ListaClientesActivity::class.java)
            startActivity(intent)
        } else if (item.itemId == R.id.menu_pagamento) {
            val intent = Intent(this, ListaPagamentosActivity::class.java)
            startActivity(intent)
        }
        return super.onOptionsItemSelected(item)
    }

    private fun abreFormularioProduto() {
        val fab = botao_adiciona_produto
        fab.setOnClickListener{
            val intent = Intent(this@MainActivity, FormularioProdutoActivity::class.java)
            startActivity(intent)
        }
    }

    private fun configuraToolBar() {
        setSupportActionBar(toolbar_lista_produtos)
        supportActionBar!!.title = "Lista Produto"
    }
}
