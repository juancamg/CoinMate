package com.example.proyecto_coinmate.catalog.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.proyecto_coinmate.R
import com.example.proyecto_coinmate.catalog.Coins

class CoinAdapter(
    private val coinLista: List<Coins>,
    private val onClickListener: (Coins) -> Unit,
    private val favouriteClickListener: OnFavouriteClickListener
) : RecyclerView.Adapter<CoinViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CoinViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return CoinViewHolder(layoutInflater.inflate(R.layout.item_coins, parent, false))
    }

    override fun getItemCount(): Int {
        return coinLista.size
    }

    override fun onBindViewHolder(holder: CoinViewHolder, position: Int) {
    val item = coinLista[position]
    holder.render(item, onClickListener)

    holder.binding.cbFav.isChecked = item.favourite

    holder.binding.cbFav.setOnCheckedChangeListener { _, isChecked ->
        val coin = coinLista.find { it == item }
        coin?.favourite = isChecked

        if (isChecked) {
            favouriteClickListener.onFavouriteSelected(item)
        } else {
            favouriteClickListener.onFavouriteDeselected(item)
        }
    }
}

    interface OnFavouriteClickListener {
        fun onFavouriteSelected(item: Coins)
        fun onFavouriteDeselected(item: Coins)
    }
}