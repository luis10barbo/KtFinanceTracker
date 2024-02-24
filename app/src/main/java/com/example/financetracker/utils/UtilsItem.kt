package com.example.financetracker.utils

import com.example.financetracker.model.ItemFinanca

fun gerarItens(): ArrayList<ItemFinanca> {
    val itens = ArrayList<ItemFinanca>()
    for (x in 1..(Math.random()*10).toInt()) {
        itens.add(ItemFinanca("Item " + x, Math.random()*300, "#FAFAFA"))
    }
    return itens
}