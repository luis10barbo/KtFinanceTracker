package com.example.financetracker.utils

import android.content.Context
import com.example.financetracker.R

fun adquirirNomeMes(contexto: Context, mes: Int): String {
    val nomesMeses = contexto.resources.getStringArray(R.array.meses)
    return nomesMeses[mes - 1]
}