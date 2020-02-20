package com.example.appstreet.ui

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.appstreet.R
import com.example.appstreet.modelo.Produto
import com.example.appstreet.retrofit.ProdutoService
import com.example.appstreet.retrofit.StreetRetrofit
import com.example.appstreet.ui.helper.FormularioProdutoHelper
import kotlinx.android.synthetic.main.activity_formulario_produto.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FormularioProdutoActivity : AppCompatActivity() {

    private val service: ProdutoService = StreetRetrofit().produtoService
    internal var context: Context? = null
    lateinit var helper: FormularioProdutoHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_formulario_produto)
        helper = FormularioProdutoHelper(this)
        configuraToolbar()
    }


    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.menu_salva, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.menu_salvar) {
            val produto = helper.pegaProduto()

            val call: Call<Produto> = service.insere(produto)
            call.enqueue(object : Callback<Produto> {

                override fun onResponse(call: Call<Produto>, response: Response<Produto>) {
                    when {
                        response.isSuccessful -> {
                            response.body()?.let {
                                Toast.makeText(
                                    this@FormularioProdutoActivity,
                                    "Adicionado com Sucesso!",
                                    Toast.LENGTH_SHORT
                                ).show()
                                finish()
                            }
                        }
                    }
                }

                override fun onFailure(call: Call<Produto>, t: Throwable) {
                    Log.e("ROQUE", "Error $t")
                }
            })

            Log.e("onResponse", "produtos form $produto")

        }
        return super.onOptionsItemSelected(item)
    }


    private fun configuraToolbar() {
        setSupportActionBar(toolbar_formulario_produto)
        supportActionBar!!.setTitle("Formulario Produto")
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }

}
