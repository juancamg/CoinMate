package com.example.proyecto_coinmate

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.res.ResourcesCompat
import androidx.navigation.fragment.findNavController
import com.example.proyecto_coinmate.databinding.FragmentLoginBinding



class LoginFragment : Fragment() {
    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLoginBinding.inflate(inflater, container, false)

        val btnLoginBinding = binding.btnLogin
        val etUsuarioBinding = binding.etUsuario

        btnLoginBinding.setOnClickListener{
            val user = etUsuarioBinding.text.toString().lowercase().replaceFirstChar(Char::uppercase)
            val sharedPreferences = requireActivity().getSharedPreferences("PREFS", Context.MODE_PRIVATE)
            sharedPreferences.edit().putString("user", user).apply()

            findNavController().navigate(LoginFragmentDirections.actionLoginFragmentToMenuFragment())
        }

        val iv_logo = binding.ivLogo
        iv_logo.setOnClickListener{
            Toast.makeText(context, "Made by Juan Carlos Maceras", Toast.LENGTH_LONG).show()
        }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity as AppCompatActivity).supportActionBar?.title = getString(R.string.login_title)
        binding.tvWelcome.typeface = ResourcesCompat.getFont(requireContext(), R.font.font_cagliostro_regular)
        binding.btnLogin.typeface = ResourcesCompat.getFont(requireContext(), R.font.font_cagliostro_regular)
        binding.etUsuario.typeface = ResourcesCompat.getFont(requireContext(), R.font.font_cagliostro_regular)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}