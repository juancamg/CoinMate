package com.example.proyecto_coinmate.catalog.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.proyecto_coinmate.catalog.Coins
import com.example.proyecto_coinmate.databinding.ItemCoinsBinding
import com.bumptech.glide.Glide


class CoinViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    val binding = ItemCoinsBinding.bind(view)

    fun render(coinModel: Coins, onClickListener: (Coins) -> Unit){
        binding.tvCoinCountry.text = coinModel.pais
        binding.tvCoinYear.text = coinModel.anno
        binding.tvCoinValue.text = coinModel.valor
        Glide.with(binding.ivImagen.context).load(coinModel.imagen).into(binding.ivImagen)

        binding.root.setOnClickListener { onClickListener(coinModel) }
    }
}