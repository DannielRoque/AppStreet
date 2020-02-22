package com.example.appstreet.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.appstreet.R
import com.example.appstreet.modelo.Cliente
import com.google.gson.Gson
import kotlinx.android.synthetic.main.item_cliente.view.*

class ListaClientesAdapter(
    val listaClientes: MutableList<Cliente>
) : RecyclerView.Adapter<ListaClientesAdapter.ListaClientesViewHolder>() {

    private lateinit var onItemClickListener: OnItemClickListener

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

    fun onItemCLickListener(onItemClickListener: OnItemClickListener){
        this.onItemClickListener = onItemClickListener
    }

    inner class ListaClientesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val campoNome = itemView.item_cliente_nome
        private val campoEndereco = itemView.item_cliente_endereco
        private val campoTelefone = itemView.item_cliente_telefone
        private val campoObservacao = itemView.item_cliente_observacao
        private val objetoJson = Gson()

        fun bind(cliente: Cliente) {

                itemView.setOnClickListener {
                    val dado = objetoJson.toJson(cliente)
                    onItemClickListener.onItemClick(dado, layoutPosition)
                }
                campoNome.text = cliente.nome
                campoObservacao.text = cliente.observacao
                campoEndereco.text = cliente.endereco
                campoTelefone.text = cliente.telefone

        }
    }
}