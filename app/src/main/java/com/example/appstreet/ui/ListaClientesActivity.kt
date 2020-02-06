package com.example.appstreet.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.appstreet.R
import kotlinx.android.synthetic.main.activity_lista_clientes.*

class ListaClientesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_clientes)
        configuraToolbar()
        vaiParaFormularioCliente()
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
