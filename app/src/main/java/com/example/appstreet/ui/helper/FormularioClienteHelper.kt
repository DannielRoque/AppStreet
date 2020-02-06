package com.example.appstreet.ui.helper

import android.widget.EditText
import com.example.appstreet.R
import com.example.appstreet.modelo.Cliente
import com.example.appstreet.ui.FormularioClienteActivity
import kotlinx.android.synthetic.main.activity_formulario_cliente.*


class FormularioClienteHelper(activity: FormularioClienteActivity) {

    private val campoNome : EditText = activity.formulario_cliente_nome
    private val campoTelefone: EditText = activity.formulario_cliente_telefone
    private val campoEndereco: EditText = activity.findViewById(R.id.formulario_cliente_endereco)
    private val campoObservacao: EditText = activity.findViewById(R.id.formulario_cliente_observacao)
    private val cliente = Cliente()

    fun pegaCliente() : Cliente{
        val cliente = Cliente()
        cliente.nome= campoNome.text.toString()
        cliente.telefone = campoTelefone.text.toString()
        cliente.endereco = campoEndereco.text.toString()
        cliente.observacao = campoObservacao.text.toString()
        return cliente
    }
}
