package com.example.appstreet.ui

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.appstreet.R
import com.example.appstreet.components.PATH_DETALHES
import com.example.appstreet.extension.debounce
import com.example.appstreet.extension.onChangeText
import com.example.appstreet.modelo.Produto
import com.example.appstreet.ui.dialog.LoadingDialog
import com.example.appstreet.ui.helper.formataparaBrasileiro
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.android.synthetic.main.activity_detalhes_produto.*

class DetalhesProdutoActivity : AppCompatActivity() {
    private lateinit var produto: Produto
    private var loading : LoadingDialog? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalhes_produto)
        setupEdtQUantidade()

        activity_detalhes_quantidade.debounce {
            Log.e("ROQUE", " teste $it")
        }

        intent?.let { intent ->
            intent.getStringExtra(PATH_DETALHES)?.let { detalhesJson ->
                val detalhes: Produto =
                    Gson().fromJson(detalhesJson, object : TypeToken<Produto>() {}.type)
                produto = detalhes
                activity_detalhes_descricao.text = detalhes.descricao
                activity_detalhes_nome.text = detalhes.nome
                activity_detalhes_preco.text = detalhes.preco?.formataparaBrasileiro()
            }
        }
    }

    override fun onResume() {
        super.onResume()
        loading?.dismiss()
    }

    fun setupEdtQUantidade() {
        val padrao = 1
        activity_detalhes_quantidade.onChangeText { text ->
            val textFormated = text?.trim()
            if (textFormated?.length!! > 0) {
                activity_detalhes_total.text =
                    textFormated.toInt().times(produto.preco!!).formataparaBrasileiro()
            }else{
                activity_detalhes_total.text =
                    padrao.times(produto.preco!!).formataparaBrasileiro()
            }
        }
    }
}
