package com.example.appstreet.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.ActionBar
import com.example.appstreet.R
import kotlinx.android.synthetic.main.activity_lista_pagamentos.*
import java.util.*

class ListaPagamentosActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_pagamentos)
        configuraToolbar()
    }


    private fun configuraToolbar() {
        setSupportActionBar(toolbar_lista_pagamentos)
        Objects.requireNonNull<ActionBar>(supportActionBar).setTitle("Lista Pagamentos")
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.menu_lista_dividendos, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.menu_lista_dividendos) {
            val intent = Intent(this, ListaDividendosActivity::class.java)
            startActivity(intent)
        }
        return super.onOptionsItemSelected(item)
    }

}
