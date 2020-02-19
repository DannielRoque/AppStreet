package com.example.appstreet.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.appstreet.R
import com.example.appstreet.modelo.Venda
import com.google.gson.Gson

class ListaVendasAdapter(
    val listaVenda: MutableList<Venda>
) : RecyclerView.Adapter<ListaVendasAdapter.ListaClientesViewHolder>() {

    private lateinit var onItemClickListener: OnItemClickListener

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListaClientesViewHolder {
        val inflar = LayoutInflater.from(parent.context)
        val inflado = inflar.inflate(R.layout.item_pagamento, parent, false)
        return ListaClientesViewHolder(inflado)
    }

    override fun getItemCount(): Int {
        return listaVenda.size
    }

    override fun onBindViewHolder(holder: ListaClientesViewHolder, position: Int) {
        holder.bind(listaVenda[position])
    }

    fun onItemClickListener(onItemClickListener: OnItemClickListener) {
        this.onItemClickListener = onItemClickListener
    }

    inner class ListaClientesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {


        private val objectJson = Gson()

        fun bind(venda: Venda) {
            itemView.setOnClickListener {
                val dado = objectJson.toJson(venda)
                onItemClickListener.onItemClick(dado, layoutPosition)
            }

        }
    }
}