package com.example.proyecto_coinmate

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.res.ResourcesCompat
import androidx.navigation.fragment.findNavController
import com.example.proyecto_coinmate.databinding.FragmentMenuBinding

class MenuFragment : Fragment() {
    private var _binding: FragmentMenuBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMenuBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mostrarMensaje()


        val btnCatalog = binding.btnCatalog
        btnCatalog.setOnClickListener {
            val action = MenuFragmentDirections.actionMenuFragmentToItemListFragment()
            findNavController().navigate(action)
        }

        val btnSettings = binding.imgSettings
        btnSettings.setOnClickListener {
            val action = MenuFragmentDirections.actionMenuFragmentToCreditFragment()
            findNavController().navigate(action)
        }

        val btnUserInfo = binding.imgUserInfo
        btnUserInfo.setOnClickListener {
            val action = MenuFragmentDirections.actionMenuFragmentToUserInfoFragment()
            findNavController().navigate(action)
        }

        val btnReturn = binding.btnReturn
        btnReturn.setOnClickListener {
            val action = MenuFragmentDirections.actionMenuFragmentToLoginFragment()
            findNavController().navigate(action)
        }

        binding.tvWelcome.typeface = ResourcesCompat.getFont(requireContext(), R.font.font_cagliostro_regular)
        binding.btnCatalog.typeface = ResourcesCompat.getFont(requireContext(), R.font.font_cagliostro_regular)
        binding.btnCollection.typeface = ResourcesCompat.getFont(requireContext(), R.font.font_cagliostro_regular)
        binding.btnReturn.typeface = ResourcesCompat.getFont(requireContext(), R.font.font_cagliostro_regular)

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun mostrarMensaje() {
        val tvWelcomeBinding = binding.tvWelcome
        val user = obtenerUsuario()

        // Se crea el string personalizado para el mensaje de bienvenida
        val WelcomeMessageTemplate = resources.getString(R.string.msg_menu_welcome)
        tvWelcomeBinding.text = String.format(WelcomeMessageTemplate, user)
    }

    private fun obtenerUsuario(): String {
        val sharedPreferences = requireActivity().getSharedPreferences("PREFS", Context.MODE_PRIVATE)
        return sharedPreferences.getString("user", "Guest") ?: "Guest"
    }

}