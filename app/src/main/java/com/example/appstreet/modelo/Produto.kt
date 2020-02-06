package com.example.appstreet.modelo

import java.io.Serializable

class Produto(
    val id : Int? = null,
    var descricao : String = "",
    var quantidade : Int? = null,
    var preco : Double? = null
):Serializable