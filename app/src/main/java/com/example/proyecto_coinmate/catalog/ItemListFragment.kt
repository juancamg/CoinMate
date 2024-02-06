package com.example.proyecto_coinmate.catalog

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
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

    }


    fun iniciarRecyclerViewVert(){
        val manager = LinearLayoutManager(requireContext())
        binding.RVCoins.layoutManager = manager
        binding.RVCoins.adapter = CoinAdapter(CoinProvider.listaCoins, { coins -> onItemSelected(coins) })
    }

    private fun onItemSelected(coins: Coins) {
    Toast.makeText(
        requireContext(),
        coins.valor,
        Toast.LENGTH_SHORT
    ).show()
}
}