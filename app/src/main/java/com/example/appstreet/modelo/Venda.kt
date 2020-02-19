package com.example.appstreet.modelo

import java.io.Serializable

class Venda(
    val idCliente : Long? = null,
    val idProduto : Long? = null,
    val total : Double? = null
) : Serializable