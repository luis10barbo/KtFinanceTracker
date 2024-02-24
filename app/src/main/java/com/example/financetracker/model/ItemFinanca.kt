package com.example.financetracker.model

import java.io.Serializable

data class ItemFinanca(
    val nome: String,
    val valor: Double,
    val cor: String
): Serializable
