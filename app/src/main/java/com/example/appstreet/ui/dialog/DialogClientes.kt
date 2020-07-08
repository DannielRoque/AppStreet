package com.example.appstreet.ui.dialog

import android.app.Activity
import android.app.Dialog
import android.os.Bundle
import android.view.Window
import com.example.appstreet.R
import com.example.appstreet.modelo.Cliente
import com.example.appstreet.ui.adapter.ListaClientesAdapter
import com.example.appstreet.ui.adapter.ListagemClientesDetalhesAdapter
import kotlinx.android.synthetic.main.dialog_clientes.*

class DialogClientes(
val activity: Activity,
private val listaDrivers: MutableList<Cliente>
) : Dialog(activity) {

    private var callback: ((itemClicked: Cliente?) -> Unit)? = null
    private val adapter: ListagemClientesDetalhesAdapter by lazy {
        ListagemClientesDetalhesAdapter(
            activity,
            listaDrivers
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        setContentView(R.layout.dialog_clientes)
        window?.setBackgroundDrawableResource(android.R.color.transparent)
        setupRecyclerViewDriver()
        setupItemSelected()
        setupButtonCancel()
    }

    private fun setupRecyclerViewDriver() {
        dialogSelectDriverRecyclerview.adapter = adapter
    }

    fun setOnItemClickListener(callback: (itemClicked: Cliente?) -> Unit): DialogClientes {
        this.callback = callback
        return this
    }

    private fun setupButtonCancel() {
        dialogSelectClienteCancel.apply {
            setOnClickListener {
                dismiss()
            }
        }
    }

    private fun setupItemSelected() {
        adapter.setOnClickListener { clienteSelected ->
            if (clienteSelected != null) {
                callback?.let { callback -> callback(clienteSelected) }
                dismiss()
            }
        }
    }
}