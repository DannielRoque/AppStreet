package com.example.appstreet.ui

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.appstreet.R
import com.example.appstreet.components.PATH_DETALHES
import com.example.appstreet.modelo.Produto
import com.example.appstreet.retrofit.ProdutoService
import com.example.appstreet.retrofit.StreetRetrofit
import com.example.appstreet.ui.adapter.ListaProdutosAdapter
import com.example.appstreet.ui.adapter.OnItemClickListener
import com.example.appstreet.ui.adapter.OnLongClickListener
import com.example.appstreet.ui.dialog.Dialog_custom
import com.example.appstreet.ui.dialog.LoadingDialog
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private var loading: LoadingDialog? = null

    private val service: ProdutoService = StreetRetrofit().produtoService

    private lateinit var adapter: ListaProdutosAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        configuraToolBar()
        abreFormularioProduto()
        loading = LoadingDialog(this)
    }

    override fun onResume() {
        super.onResume()
        buscaProdutos()
        loading?.dismiss()
    }

    fun buscaProdutos() {
        val call: Call<MutableList<Produto>> = service.buscaTodos()
        call.enqueue(object : Callback<MutableList<Produto>> {

            override fun onResponse(
                call: Call<MutableList<Produto>>,
                response: Response<MutableList<Produto>>
            ) {

                when {
                    response.isSuccessful -> {
                        response.body()?.let {
                            val respostaProduto: MutableList<Produto> =
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

    private fun configuraRecyclerView(resposta: MutableList<Produto>) {
        Log.e("Roque", "resposta $resposta")
        adapter = ListaProdutosAdapter(resposta)
        lista_produtos_recyclerview.adapter = adapter
        adapter.setOnLongCliclListener(object : OnLongClickListener {
            override fun onLongCLick(view: String, position: Int): Boolean {
                Dialog_custom(this@MainActivity)
                    .setMessage(getString(R.string.deletarProdutoMessage))
                    .setTitle(getString(R.string.deletarProdutoTitle))
                    .setActivePositiveButtom()
                    .setNegativeButtom(getString(R.string.cancelar))
                    .setLabelPositiveButtom(getString(R.string.deletar))
                    .show()
                return false
            }
        })

        adapter.onItemClickListener(object : OnItemClickListener {
            override fun onItemClick(view: String, position: Int) {
                Handler().postDelayed({
                var intentRes = Intent(this@MainActivity, DetalhesProdutoActivity::class.java)
                intentRes.putExtra(PATH_DETALHES, view)
                startActivity(intentRes)
                loading?.show()
                },2000)
            }
        })
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.menu_cliente_pagamento, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when {
            item.itemId == R.id.menu_cliente -> {
                loading?.show()
                Handler().postDelayed({
                val intent = Intent(this, ListaClientesActivity::class.java)
                startActivity(intent)
                },2000)
            }
            item.itemId == R.id.menu_pagamento -> {
                loading?.show()
                Handler().postDelayed({
                val intent = Intent(this, ListaPagamentosActivity::class.java)
                startActivity(intent)
                }, 2000)
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun abreFormularioProduto() {
        val fab = botao_adiciona_produto
        fab.setOnClickListener {
            loading?.show()
            Handler().postDelayed({
            val intent = Intent(this@MainActivity, FormularioProdutoActivity::class.java)
            startActivity(intent)
            }, 2000)
        }
    }

    private fun configuraToolBar() {
        setSupportActionBar(toolbar_lista_produtos)
        supportActionBar!!.title = "Lista Produto"
    }
}
