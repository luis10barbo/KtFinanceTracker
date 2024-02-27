package com.example.financetracker.model

enum class TipoFinanca {
    GANHO,
    PERDA;

    fun parseTipoFinanca(string: String): TipoFinanca {
        if (string == "GANHO") {
            return GANHO
        } else {
            return PERDA
        }
    }
}