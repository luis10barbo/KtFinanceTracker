package com.example.financetracker.utils

import com.example.financetracker.R

fun corValorFinanceiro(valor: Double): Int {
    return if (valor > 0) R.color.verde else if (valor == 0.0) R.color.neutro else R.color.vermelho;
}