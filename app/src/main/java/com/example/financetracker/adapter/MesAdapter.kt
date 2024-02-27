package com.example.financetracker.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.example.financetracker.activities.AtividadeMes
import com.example.financetracker.constants.Extras
import com.example.financetracker.databinding.ListaMesesBinding
import com.example.financetracker.model.Data
import com.example.financetracker.utils.adquirirNomeMes
import com.example.financetracker.utils.corValorFinanceiro

class MesAdapter(private val contexto: Context, private val meses: ArrayList<Data>): ArrayAdapter<Data>(contexto, 0, meses) {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var view = convertView;
        lateinit var binding: ListaMesesBinding

        if (view == null) {
            binding = ListaMesesBinding.inflate(LayoutInflater.from(contexto), parent, false)
            view = binding.root
        } else {
            binding = ListaMesesBinding.bind(view)
        }

        binding.root.minimumHeight = binding.root.width

        val mes = meses[position]

        binding.tvMes.text = adquirirNomeMes(contexto, mes.mes)
        binding.tvResultado.text = mes.getResultadoFormatado()
        binding.tvResultado.setTextColor(contexto.resources.getColor(corValorFinanceiro(mes.total), contexto.theme))
        binding.llCard.setOnClickListener(View.OnClickListener {
            val atividadeMes = Intent(contexto, AtividadeMes::class.java)
            atividadeMes.putExtra(Extras.EXTRA_DATA, meses[position])
            contexto.startActivity(atividadeMes)
        })
        return view;
    }
}