package com.example.appstreet.modelo

import java.io.Serializable

class Cliente(
    val id : Int? = null,
    var nome : String = "",
    var observacao : String = "",
    var endereco : String = "",
    var telefone : String = ""
): Serializable