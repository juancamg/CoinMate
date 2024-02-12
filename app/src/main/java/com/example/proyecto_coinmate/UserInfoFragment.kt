package com.example.proyecto_coinmate

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.res.ResourcesCompat
import androidx.navigation.fragment.findNavController
import com.example.proyecto_coinmate.catalog.CoinProvider
import com.example.proyecto_coinmate.databinding.FragmentUserInfoBinding

class UserInfoFragment : Fragment() {

    private var _binding: FragmentUserInfoBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentUserInfoBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mostrarDatos()

        val btnReturn = binding.btnReturn
        btnReturn.setOnClickListener {
            val action = UserInfoFragmentDirections.actionUserInfoFragmentToMenuFragment()
            findNavController().navigate(action)
        }

        binding.tvCreditTittle.typeface = ResourcesCompat.getFont(requireContext(), R.font.font_cagliostro_regular)
        binding.tvUserName.typeface = ResourcesCompat.getFont(requireContext(), R.font.font_cagliostro_regular)
        binding.tvFavCount.typeface = ResourcesCompat.getFont(requireContext(), R.font.font_cagliostro_regular)
        binding.btnReturn.typeface = ResourcesCompat.getFont(requireContext(), R.font.font_cagliostro_regular)
    }

    private fun mostrarDatos() {
        // Usuario
        val user = obtenerUsuario()
        val tvUserNameBinding = binding.tvUserName
        val UserMessageTemplate = resources.getString(R.string.user_name)
        tvUserNameBinding.text = String.format(UserMessageTemplate, user)

        // Favoritos
        val tvFavoritosBinding = binding.tvFavCount

        val favoritosCount = obtenerFavoritos()

        if (favoritosCount == "0") {
            val FavMessageTemplate = resources.getString(R.string.user_fav_Count0)
            tvFavoritosBinding.text = String.format(FavMessageTemplate)

        } else if (favoritosCount == "1") {
            val FavMessageTemplate = resources.getString(R.string.user_fav_Count1)
            tvFavoritosBinding.text = String.format(FavMessageTemplate, favoritosCount)
        } else {
            val FavMessageTemplate = resources.getString(R.string.user_fav_Count)
            tvFavoritosBinding.text = String.format(FavMessageTemplate, favoritosCount)
        }
    }

    private fun obtenerUsuario(): String {
        val sharedPreferences = requireActivity().getSharedPreferences("PREFS", Context.MODE_PRIVATE)
        return sharedPreferences.getString("user", "Guest") ?: "Guest"
    }

    private fun obtenerFavoritos(): String {
        return CoinProvider.listaFavoritos.size.toString()
    }
}