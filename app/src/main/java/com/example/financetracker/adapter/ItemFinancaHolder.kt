package com.example.financetracker.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.example.financetracker.databinding.ItemFinancaBinding
import com.example.financetracker.extensions.extFormatarRealUnsig
import com.example.financetracker.model.ItemFinanca
import com.example.financetracker.utils.formatarValorReal

class ItemFinancaAdapter(private val contexto: Context, private val itens: ArrayList<ItemFinanca>): Adapter<ItemFinancaHolder>() {
    lateinit var binding: ItemFinancaBinding;
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemFinancaHolder {
        binding = ItemFinancaBinding.inflate(LayoutInflater.from(contexto), parent, false)
        return ItemFinancaHolder(binding.root)
    }

    override fun getItemCount(): Int {
        return itens.size
    }

    override fun onBindViewHolder(holder: ItemFinancaHolder, position: Int) {
        val item = itens[position]
        binding.tvNomeItem.text = item.nome
        binding.tvValorItem.text = item.valor.extFormatarRealUnsig()
    }
}

class ItemFinancaHolder(itemView: View): RecyclerView.ViewHolder(itemView)