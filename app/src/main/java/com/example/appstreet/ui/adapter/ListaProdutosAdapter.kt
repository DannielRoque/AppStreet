package com.example.appstreet.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.appstreet.R
import com.example.appstreet.modelo.Produto
import com.example.appstreet.ui.helper.formataparaBrasileiro
import com.google.gson.Gson
import kotlinx.android.synthetic.main.item_produto.view.*

class ListaProdutosAdapter(
    val listaProdutos: MutableList<Produto>
) : RecyclerView.Adapter<ListaProdutosAdapter.ListaProdutosViewHolder>() {

    private lateinit var onItemClickListener: OnItemClickListener
    private lateinit var onLongClickListener: OnLongClickListener

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

    fun onItemClickListener(onItemClickListener: OnItemClickListener){
        this.onItemClickListener = onItemClickListener
    }

    fun setOnLongCliclListener(onLongClickListener: OnLongClickListener){
        this.onLongClickListener = onLongClickListener
    }

  inner  class ListaProdutosViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val campoNome = itemView.item_produto_nome
        private val campoDescricao = itemView.item_produto_descricao
        private val campoQuantidade = itemView.item_produto_quantidade
        private val campoPreco = itemView.item_produto_preco
        private val objectJson = Gson()

        fun bind(produto: Produto) {
            itemView.setOnClickListener {
                val dado = objectJson.toJson(produto)
                onItemClickListener.onItemClick(dado, layoutPosition)
            }
            itemView.setOnLongClickListener {
                val dadoLong = objectJson.toJson(produto)
                onLongClickListener.onLongCLick(dadoLong, layoutPosition)
            }
            campoNome.text = produto.nome
            campoDescricao.text = produto.descricao
            campoQuantidade.text = produto.quantidade.toString()
            campoPreco.text = produto.preco?.formataparaBrasileiro()
        }
    }
}