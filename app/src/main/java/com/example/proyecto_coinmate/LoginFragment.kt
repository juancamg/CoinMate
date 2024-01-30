package com.example.proyecto_coinmate

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.res.ResourcesCompat
import com.example.proyecto_coinmate.databinding.FragmentLoginBinding



class LoginFragment : Fragment() {
    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.tvWelcome.typeface = ResourcesCompat.getFont(requireContext(), R.font.font_cagliostro_regular)
        binding.btnGoto.typeface = ResourcesCompat.getFont(requireContext(), R.font.font_cagliostro_regular)
        binding.etUsuario.typeface = ResourcesCompat.getFont(requireContext(), R.font.font_cagliostro_regular)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}