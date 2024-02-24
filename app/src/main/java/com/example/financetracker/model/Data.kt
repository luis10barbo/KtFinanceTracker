package com.example.financetracker.model

import com.example.financetracker.utils.formatarValorReal
import java.io.Serializable

data class Data(val ano: Int, val mes: Int, val itensGanhos: ArrayList<ItemFinanca>, val itensPerdas: ArrayList<ItemFinanca>): Serializable {
    var total = 0.0
    private set

    var ganho = 0.0
    private set

    var perda = 0.0
    private set

    init {
       calcularTotal()
    }
    fun calcularTotal() {
        for (item in itensGanhos) {
            ganho += item.valor
        }
        for (item in itensPerdas) {
            perda -= item.valor
        }

        total = ganho + perda
    }

    fun getResultadoFormatado(): String {
        return formatarValorReal(total)
    }
}