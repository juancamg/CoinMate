package com.example.proyecto_coinmate.catalog.itemList

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.res.ResourcesCompat
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.proyecto_coinmate.R
import com.example.proyecto_coinmate.catalog.CoinProvider
import com.example.proyecto_coinmate.catalog.Coins
import com.example.proyecto_coinmate.catalog.adapter.CoinAdapter
import com.example.proyecto_coinmate.databinding.FragmentItemListBinding

class ItemListFragment : Fragment() {

    private var _binding: FragmentItemListBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentItemListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        iniciarRecyclerViewVert()

        val btnReturn = binding.btnReturn
        btnReturn.setOnClickListener {
            val action = ItemListFragmentDirections.actionItemListFragmentToMenuFragment()
            findNavController().navigate(action)
        }

        val btnFav = binding.btnFav
        btnFav.setOnClickListener {
            val action = ItemListFragmentDirections.actionItemListFragmentToFavItemListFragment()
            findNavController().navigate(action)
        }

        binding.tvItemListTittle.typeface = ResourcesCompat.getFont(requireContext(), R.font.font_cagliostro_regular)
        binding.btnReturn.typeface = ResourcesCompat.getFont(requireContext(), R.font.font_cagliostro_regular)
        binding.btnFav.typeface = ResourcesCompat.getFont(requireContext(), R.font.font_cagliostro_regular)
    }

    fun iniciarRecyclerViewVert() {
        val manager = LinearLayoutManager(requireContext())
        binding.RVCoins.layoutManager = manager
        binding.RVCoins.adapter = CoinAdapter(
            CoinProvider.listaCoins,
            { coins -> onItemSelected(coins) },
        )
    }

    private fun onItemSelected(coins: Coins) {
        val action = ItemListFragmentDirections.actionItemListFragmentToDetailItemFragment(coins.id)
        findNavController().navigate(action)
    }
}