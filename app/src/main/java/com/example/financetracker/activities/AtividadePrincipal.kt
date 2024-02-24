package com.example.financetracker.activities

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import androidx.activity.ComponentActivity
import com.example.financetracker.adapter.MesAdapter
import com.example.financetracker.constants.Extras
import com.example.financetracker.databinding.PrincipalBinding
import com.example.financetracker.model.Data
import com.example.financetracker.utils.corValorFinanceiro
import com.example.financetracker.utils.formatarValorReal
import com.example.financetracker.utils.gerarItens

class AtividadePrincipal : ComponentActivity() {
    private lateinit var binding: PrincipalBinding;
    val meses = ArrayList<Data>();
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = PrincipalBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.cabecalho.tvTituloCabecalho.text = "2024"
        addExemploMeses()
        calcularResultado()
        setupMonthsGrid()
    }

    private fun addExemploMeses() {
        for (mes in 1..12) {
            val itensGanhos = gerarItens()
            var valorGanho = 0.0;
            for (item in itensGanhos) {
                valorGanho += item.valor
            }
            val itensPerdas = gerarItens()
            var valorPerda = 0.0;
            for (item in itensPerdas) {
                valorPerda += item.valor
            }

            meses.add(Data(2024, mes,itensGanhos, itensPerdas))
        }
    }

    private fun calcularResultado() {
        var resultado = 0.0;
        for (mes in meses) {
            resultado += mes.total
        }
        binding.cabecalho.tvResultadoCabecalho.setTextColor(getColor(corValorFinanceiro(resultado)))
        binding.cabecalho.tvResultadoCabecalho.text = formatarValorReal(resultado)
    }

    private fun setupMonthsGrid() {
        binding.gvMeses.adapter = MesAdapter(binding.root.context, meses)
    }
}

