package com.example.appstreet.ui

import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.appstreet.R
import com.example.appstreet.modelo.Cliente
import com.example.appstreet.retrofit.ClienteService
import com.example.appstreet.retrofit.StreetRetrofit
import com.example.appstreet.ui.helper.FormularioClienteHelper
import kotlinx.android.synthetic.main.activity_formulario_cliente.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FormularioClienteActivity : AppCompatActivity() {

    private val service: ClienteService = StreetRetrofit().clienteService
    private lateinit var helper: FormularioClienteHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_formulario_cliente)
        configuraToolBar()
        helper = FormularioClienteHelper(this)
    }


    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_salva, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.menu_salvar) {
            val cliente = helper.pegaCliente()

            val call: Call<Cliente> = service.insereCliente(cliente)
            call.enqueue(object : Callback<Cliente> {

                override fun onResponse(call: Call<Cliente>, response: Response<Cliente>) {
                    when {
                        response.isSuccessful -> {
                            response.body()?.let {
                                Toast.makeText(
                                    this@FormularioClienteActivity,
                                    "Adicionado com sucesso",
                                    Toast.LENGTH_SHORT
                                ).show()
                                finish()
                            }
                        }
                    }
                }

                override fun onFailure(call: Call<Cliente>, t: Throwable) {
                    Log.e("ROQUE", "Erro $t")
                }
            })
        }
        return super.onOptionsItemSelected(item)
    }

    private fun configuraToolBar() {
        setSupportActionBar(toolbar_formulario_cliente)
        supportActionBar!!.setTitle("Formulario Cliente")
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }

}
