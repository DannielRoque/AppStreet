package com.example.appstreet.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.appstreet.R
import com.example.appstreet.ui.component.EmptyList
import kotlinx.android.synthetic.main.activity_lista_dividendos.*

class ListaDividendosActivity : AppCompatActivity() {

    private lateinit var emptyList : EmptyList

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_dividendos)
        configuraToolBar()
        emptyList = this.viewEmptyList
        emptyList()
    }


    private fun configuraToolBar() {
        setSupportActionBar(toolbar_lista_dividendos)
        supportActionBar!!.title = "Lista Dividendos"
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
    }


    private fun emptyList() {
        emptyList.visibility = View.VISIBLE
    }

    private fun hideEmptyList() {
        emptyList.visibility = View.GONE
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }
}
