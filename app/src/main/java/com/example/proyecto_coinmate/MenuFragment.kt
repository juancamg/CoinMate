package com.example.proyecto_coinmate

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.proyecto_coinmate.databinding.FragmentLoginBinding
import com.example.proyecto_coinmate.databinding.FragmentMenuBinding

class MenuFragment : Fragment() {
    private var _binding: FragmentMenuBinding? = null
    private val binding get() = _binding!!

    val args:MenuFragmentArgs by navArgs()

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

        val btnSettings = binding.imgSettings
        btnSettings.setOnClickListener {
            val action = MenuFragmentDirections.actionMenuFragmentToCreditFragment()
            findNavController().navigate(action)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun mostrarMensaje() {
        val user = args.user
        val tvWelcomeBinding = binding.tvWelcome

        // Se crea el string personalizado para el mensaje de bienvenida
        val WelcomeMessageTemplate = resources.getString(R.string.msg_menu_welcome)
        tvWelcomeBinding.text = String.format(WelcomeMessageTemplate, user)
    }


}