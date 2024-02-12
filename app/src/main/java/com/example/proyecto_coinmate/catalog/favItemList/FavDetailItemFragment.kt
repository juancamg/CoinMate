package com.example.proyecto_coinmate.catalog.favItemList

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.example.proyecto_coinmate.catalog.CoinProvider
import com.example.proyecto_coinmate.databinding.FragmentFavDetailItemBinding

class FavDetailItemFragment : Fragment() {

    private var _binding: FragmentFavDetailItemBinding? = null
    private val binding get() = _binding!!

    private val args: FavDetailItemFragmentArgs by navArgs()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentFavDetailItemBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        rellenarDetalles(args.coinId)

        val btnReturn = binding.btnReturn
        btnReturn.setOnClickListener {
            val action = FavDetailItemFragmentDirections.actionFavDetailItemFragmentToFavItemListFragment()
            findNavController().navigate(action)
        }

    }

    fun rellenarDetalles(coinId: String) {
        // Encuentra la moneda en la lista de monedas
        val coin = CoinProvider.listaFavoritos.find { it.id == coinId }

        // Si la moneda existe, llena los campos de texto y la imagen con los datos de la moneda
        coin?.let {
            Glide.with(this)
                .load(it.imagen)
                .into(binding.ivImagen)
            binding.tvCoinCountry.text = it.pais
            binding.tvCoinValue.text = it.valor
            binding.tvCoinYear.text = it.anno
            binding.tvCoinDetails.text = it.detalles

            binding.cbFav.setOnCheckedChangeListener { _, isChecked ->
                it.favourite = isChecked

                if (isChecked) {
                    CoinProvider.listaFavoritos.add(it)
                } else {
                    CoinProvider.listaFavoritos.remove(it)
                }
            }
        }
    }
}