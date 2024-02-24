package com.example.financetracker.activities

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import androidx.activity.ComponentActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.financetracker.adapter.ItemFinancaAdapter
import com.example.financetracker.constants.Extras
import com.example.financetracker.databinding.PaginaMesBinding
import com.example.financetracker.extensions.extFormatarReal
import com.example.financetracker.extensions.extGetSerializableExtra
import com.example.financetracker.model.Data
import com.example.financetracker.utils.adquirirNomeMes
import com.example.financetracker.utils.corValorFinanceiro

class AtividadeMes: ComponentActivity() {
    lateinit var binding: PaginaMesBinding
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = PaginaMesBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val data = intent.extGetSerializableExtra(Extras.EXTRA_DATA, Data::class.java)!!

        binding.cabecalho.tvTituloCabecalho.text = String.format("%d, %s", data.ano, adquirirNomeMes(this, data.mes))
        binding.cabecalho.btnAdd.visibility = View.VISIBLE


        val total = data.ganho + data.perda
        binding.cabecalho.tvResultadoCabecalho.text = total.extFormatarReal()
        binding.cabecalho.tvResultadoCabecalho.setTextColor(getColor(corValorFinanceiro(total)))

        binding.tvResultadoGanho.text = data.ganho.extFormatarReal()
        binding.tvResultadoGanho.setTextColor(getColor(corValorFinanceiro(data.ganho)))
        binding.tvNenhumItemAdicionadoGanho.visibility = if (data.itensGanhos.size > 0) View.GONE else View.VISIBLE
        binding.rvItensGanhos.adapter = ItemFinancaAdapter(this, data.itensGanhos)
        binding.rvItensGanhos.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        binding.tvResultadoPerda.text = data.perda.extFormatarReal()
        binding.tvResultadoPerda.setTextColor(getColor(corValorFinanceiro(data.perda)))
        binding.tvNenhumItemAdicionadoPerda.visibility = if (data.itensPerdas.size > 0) View.GONE else View.VISIBLE
        binding.rvItensPerda.adapter = ItemFinancaAdapter(this, data.itensPerdas)
        binding.rvItensPerda.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

    }


}