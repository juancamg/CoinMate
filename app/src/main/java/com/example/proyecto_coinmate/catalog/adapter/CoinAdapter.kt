package com.example.proyecto_coinmate.catalog.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.proyecto_coinmate.R
import com.example.proyecto_coinmate.catalog.Coins

class CoinAdapter (private val coinLista: List<Coins>, private val onClickListener: (Coins) -> Unit) : RecyclerView.Adapter<CoinViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CoinViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return CoinViewHolder(layoutInflater.inflate(R.layout.item_coins, parent, false))
    }

    override fun getItemCount(): Int {
        return coinLista.size
    }

    override fun onBindViewHolder(holder: CoinViewHolder, position: Int) {
        holder.render(coinLista[position], onClickListener)
    }
}