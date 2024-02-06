package com.example.proyecto_coinmate.catalog.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.proyecto_coinmate.catalog.Coins
import com.example.proyecto_coinmate.databinding.ItemCoinsBinding


class CoinViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    val binding = ItemCoinsBinding.bind(view)

    fun render(coinModel: Coins, onClickListener: (Coins) -> Unit){
        binding.tvCoinCountry.text = coinModel.pais
        binding.tvCoinYear.text = coinModel.anno
        binding.tvCoinValue.text = coinModel.valor

        binding.root.setOnClickListener { onClickListener(coinModel) }
    }
}