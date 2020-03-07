package com.example.appstreet.ui.helper

import java.math.BigDecimal
import java.text.DecimalFormat
import java.util.*

fun Double.formataparaBrasileiro(): String {
    val formatoBrasileiro = DecimalFormat.getCurrencyInstance(Locale("pt", "br"))
    return formatoBrasileiro.format(this).replace("R$", "R$: ")
}