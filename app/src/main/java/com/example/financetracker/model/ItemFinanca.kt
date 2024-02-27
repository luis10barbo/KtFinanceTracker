package com.example.financetracker.model

import java.io.Serializable

data class ItemFinanca(
    var id: Long?,
    var dateId: Long?,
    val nome: String,
    val valor: Double,
    val cor: String,
    val tipo: TipoFinanca
): Serializable
