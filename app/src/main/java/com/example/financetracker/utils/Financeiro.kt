package com.example.financetracker.utils

import kotlin.math.abs

class Financeiro {

}

fun formatarValorReal(valor: Double): String {
    return String.format("%sR$%.2f", if (valor > 0) "+" else if (valor == 0.0) "" else "-", abs(valor));
}

fun formatarValorRealUnsig(valor: Double): String {
    return String.format("R$%.2f", abs(valor));
}