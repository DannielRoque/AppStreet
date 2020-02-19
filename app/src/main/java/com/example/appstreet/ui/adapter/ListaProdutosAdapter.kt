package com.example.appstreet.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView
import com.example.appstreet.R
import com.example.appstreet.modelo.Produto

class ListaProdutosAdapter(
    val listaProdutos : MutableList<Produto>
) : RecyclerView.Adapter<ListaProdutosAdapter.ListaProdutosViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListaProdutosViewHolder {
        val inflar = LayoutInflater.from(parent.context)
        val inflado = inflar.inflate(R.layout.item_produto, parent, false)
        return ListaProdutosViewHolder(inflado)
    }

    override fun getItemCount(): Int {
        return listaProdutos.size
    }

    override fun onBindViewHolder(holder: ListaProdutosViewHolder, position: Int) {
        holder.bind(listaProdutos[position])
    }

    class ListaProdutosViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        fun bind(produto: Produto) {

        }

    }
}