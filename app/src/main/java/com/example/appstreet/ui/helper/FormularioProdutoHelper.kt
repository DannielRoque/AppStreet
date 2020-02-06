package com.example.appstreet.ui.helper

import android.widget.EditText
import com.example.appstreet.R
import com.example.appstreet.modelo.Produto
import com.example.appstreet.ui.FormularioProdutoActivity
import kotlinx.android.synthetic.main.activity_formulario_produto.*

class FormularioProdutoHelper(activity: FormularioProdutoActivity) {

    private val campoDescricao: EditText = activity.formulario_produto_nome
    private val campoQuantidade: EditText = activity.formulario_produto_quantidade
    private val campoPreco: EditText = activity.formulario_produto_preco
    private var produto = Produto()

    fun pegaProduto(): Produto {
        produto.descricao = campoDescricao.text.toString()
        produto.quantidade = Integer.parseInt(campoQuantidade.text.toString())
        produto.preco = java.lang.Double.valueOf(campoPreco.text.toString())
        return produto
    }

    fun preencheFormulario(produto: Produto) {
        campoDescricao.setText(produto.descricao)
        campoQuantidade.setText(produto.quantidade!!)
        campoPreco.setText(produto.preco.toString())
        this.produto = produto
    }
}
