package com.example.proyecto_coinmate.catalog.itemList

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.res.ResourcesCompat
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.example.proyecto_coinmate.R
import com.example.proyecto_coinmate.catalog.CoinProvider
import com.example.proyecto_coinmate.databinding.FragmentDetailItemBinding

class DetailItemFragment : Fragment() {

    private var _binding: FragmentDetailItemBinding? = null
    private val binding get() = _binding!!

    private val args: DetailItemFragmentArgs by navArgs()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDetailItemBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity as AppCompatActivity).supportActionBar?.title = getString(R.string.detail_item_list_title)

        rellenarDetalles(args.coinId)

        binding.tvDetailItemListTittle.typeface = ResourcesCompat.getFont(requireContext(), R.font.font_cagliostro_regular)
        binding.tvTitulo1.typeface = ResourcesCompat.getFont(requireContext(), R.font.font_cagliostro_regular)
        binding.tvCoinCountry.typeface = ResourcesCompat.getFont(requireContext(), R.font.font_cagliostro_regular)
        binding.tvTitulo2.typeface = ResourcesCompat.getFont(requireContext(), R.font.font_cagliostro_regular)
        binding.tvCoinValue.typeface = ResourcesCompat.getFont(requireContext(), R.font.font_cagliostro_regular)
        binding.tvTitulo3.typeface = ResourcesCompat.getFont(requireContext(), R.font.font_cagliostro_regular)
        binding.tvCoinYear.typeface = ResourcesCompat.getFont(requireContext(), R.font.font_cagliostro_regular)
        binding.tvTitulo4.typeface = ResourcesCompat.getFont(requireContext(), R.font.font_cagliostro_regular)
        binding.tvCoinDetails.typeface = ResourcesCompat.getFont(requireContext(), R.font.font_cagliostro_regular)
    }

    fun rellenarDetalles(coinId: String) {
    // Encuentra la moneda en la lista de monedas
    val coin = CoinProvider.listaCoins.find { it.id == coinId }

    // Si la moneda existe, llena los campos de texto y la imagen con los datos de la moneda
    coin?.let {
        Glide.with(this)
            .load(it.imagen)
            .into(binding.ivImagen)
        binding.tvCoinCountry.text = it.pais
        binding.tvCoinValue.text = it.valor
        binding.tvCoinYear.text = it.anno
        binding.tvCoinDetails.text = it.detalles
        binding.cbFav.isChecked = it.favourite

        binding.cbFav.setOnCheckedChangeListener { _, isChecked ->
            it.favourite = isChecked

            if (isChecked) {
                CoinProvider.listaFavoritos.add(coin!!)
                Toast.makeText(this.context, "Añadido a favoritos", Toast.LENGTH_SHORT).show()
            } else {
                CoinProvider.listaFavoritos.remove(coin!!)
                Toast.makeText(this.context, "Quitado de favoritos", Toast.LENGTH_SHORT).show()
            }
        }
    }
    }
}
