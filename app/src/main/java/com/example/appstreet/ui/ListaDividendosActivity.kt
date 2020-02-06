package com.example.appstreet.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.appstreet.R
import kotlinx.android.synthetic.main.activity_lista_dividendos.*

class ListaDividendosActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_dividendos)
        configuraToolBar()
    }


    private fun configuraToolBar() {
        setSupportActionBar(toolbar_lista_dividendos)
        supportActionBar!!.title = "Lista Dividendos"
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }
}
