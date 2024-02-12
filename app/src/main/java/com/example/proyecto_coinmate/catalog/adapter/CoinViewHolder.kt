package com.example.proyecto_coinmate.catalog.adapter

import android.view.View
import androidx.core.content.res.ResourcesCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.proyecto_coinmate.catalog.Coins
import com.example.proyecto_coinmate.databinding.ItemCoinsBinding
import com.bumptech.glide.Glide
import com.example.proyecto_coinmate.R


class CoinViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    val binding = ItemCoinsBinding.bind(view)

    fun render(coinModel: Coins, onClickListener: (Coins) -> Unit){
        binding.tvCoinCountry.text = coinModel.pais
        binding.tvCoinYear.text = coinModel.anno
        binding.tvCoinValue.text = coinModel.valor
        Glide.with(binding.ivImagen.context).load(coinModel.imagen).into(binding.ivImagen)

        binding.root.setOnClickListener { onClickListener(coinModel) }

        binding.tvCoinCountry.typeface = ResourcesCompat.getFont(binding.root.context, R.font.font_cagliostro_regular)
        binding.tvCoinYear.typeface = ResourcesCompat.getFont(binding.root.context, R.font.font_cagliostro_regular)
        binding.tvCoinValue.typeface = ResourcesCompat.getFont(binding.root.context, R.font.font_cagliostro_regular)

    }
}