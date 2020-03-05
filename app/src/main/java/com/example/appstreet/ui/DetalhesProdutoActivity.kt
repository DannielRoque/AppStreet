package com.example.appstreet.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.EditText
import com.example.appstreet.R
import com.example.appstreet.components.PATH_DETALHES
import com.example.appstreet.extension.debounce
import com.example.appstreet.modelo.Produto
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.android.synthetic.main.activity_detalhes_produto.*

class DetalhesProdutoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalhes_produto)

        activity_detalhes_quantidade.debounce {
            Log.e("ROQUE", " teste $it")
        }

        intent?.let {intent ->
            intent.getStringExtra(PATH_DETALHES)?.let {detalhesJson ->
                val detalhes : Produto =
                    Gson().fromJson(detalhesJson, object : TypeToken<Produto>() {}.type)
                activity_detalhes_descricao.text = detalhes.descricao
                activity_detalhes_preco.text = detalhes.preco.toString()
            }
        }
    }

    fun teste(teste : String){
        Log.e("ROQUE", "$teste")
    }
}
