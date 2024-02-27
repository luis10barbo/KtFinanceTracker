package com.example.financetracker.utils

import com.example.financetracker.model.ItemFinanca
import com.example.financetracker.model.TipoFinanca

fun gerarItens(tipo: TipoFinanca): ArrayList<ItemFinanca> {
    val itens = ArrayList<ItemFinanca>()
    for (x in 1..(Math.random()*10).toInt()) {
        itens.add(ItemFinanca(null, null,"Item " + x, Math.random()*300, "#FAFAFA", tipo))
    }
    return itens
}