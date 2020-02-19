package com.example.appstreet.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.appstreet.R
import com.example.appstreet.modelo.Cliente

class ListaClientesAdapter(
    val listaClientes: MutableList<Cliente>
) : RecyclerView.Adapter<ListaClientesAdapter.ListaClientesViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListaClientesViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val layoutInflado = layoutInflater.inflate(R.layout.item_cliente, parent, false)
        return ListaClientesViewHolder(layoutInflado)
    }

    override fun getItemCount(): Int {
        return listaClientes.size
    }

    override fun onBindViewHolder(holder: ListaClientesViewHolder, position: Int) {
        holder.bind(listaClientes[position])
    }

    inner class ListaClientesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(cliente: Cliente) {

        }
    }
}