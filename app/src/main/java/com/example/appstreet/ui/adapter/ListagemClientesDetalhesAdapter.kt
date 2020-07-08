package com.example.appstreet.ui.adapter

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.appstreet.R
import com.example.appstreet.modelo.Cliente
import kotlinx.android.synthetic.main.detalhe_cliente.view.*

class ListagemClientesDetalhesAdapter(
    val activity: Activity,
    val listaClientes: MutableList<Cliente>
) : RecyclerView.Adapter<ListagemClientesDetalhesAdapter.ListagemClientesViewHolder>() {

    private lateinit var callback: (itemClicked: Cliente) -> Unit

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListagemClientesViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.detalhe_cliente, parent, false)
        return ListagemClientesViewHolder(view, activity, callback)
    }

    override fun getItemCount(): Int {
        return listaClientes.size
    }

    override fun onBindViewHolder(holder: ListagemClientesViewHolder, position: Int) {
        holder.bind(listaClientes[position])
    }

    fun setOnClickListener(calback: (itemClicked: Cliente) -> Unit) {
        this.callback = callback
    }

    class ListagemClientesViewHolder(
        itemView: View,
        val activity: Activity,
        val calback: (itemClicked: Cliente) -> Unit
    ) : RecyclerView.ViewHolder(itemView) {

        private val nome: TextView = itemView.nomeCliente
        private val endereco: TextView = itemView.enderecoCLiente

        fun bind(cliente: Cliente) {
            itemView.setOnClickListener {
                calback(cliente)
            }
            nome.text = cliente.nome
            endereco.text = cliente.endereco
        }

    }
}
