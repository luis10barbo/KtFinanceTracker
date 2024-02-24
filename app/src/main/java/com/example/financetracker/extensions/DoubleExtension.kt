package com.example.financetracker.extensions

import com.example.financetracker.utils.formatarValorReal
import com.example.financetracker.utils.formatarValorRealUnsig

fun Double.extFormatarReal(): String {
    return formatarValorReal(this)
}

fun Double.extFormatarRealUnsig(): String {
    return formatarValorRealUnsig(this)
}