package com.example.proyecto_coinmate

import android.content.Context
import android.content.SharedPreferences
import android.content.res.Configuration
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatDelegate
import androidx.appcompat.app.AppCompatDelegate.NightMode
import androidx.appcompat.widget.SwitchCompat
import androidx.navigation.fragment.findNavController
import com.example.proyecto_coinmate.databinding.FragmentCreditBinding
import com.example.proyecto_coinmate.databinding.FragmentMenuBinding
import java.util.Locale


class CreditFragment : Fragment() {

    private var _binding: FragmentCreditBinding? = null
    private val binding get() = _binding!!

    private lateinit var modeSwitch: SwitchCompat
    private var nightMode: Boolean = false
    private var editor: SharedPreferences.Editor? = null
    private var sharedPreferences: SharedPreferences? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCreditBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        nightMode()
        languageMode()

        val btnReturn = binding.btnReturn
        btnReturn.setOnClickListener {
            val action = CreditFragmentDirections.actionCreditFragmentToMenuFragment()
            findNavController().navigate(action)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun nightMode() {
        modeSwitch = binding.switchDarkMode

        sharedPreferences = activity?.getSharedPreferences("MODE", Context.MODE_PRIVATE)
        nightMode = sharedPreferences?.getBoolean("NIGHT_MODE", false)!!

        // Verifica el modo actual de la aplicación e inicializa el interruptor en la posición correspondiente
        modeSwitch.isChecked = nightMode

        modeSwitch.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
            } else {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
            }

            // Guarda la preferencia para futuros usos
            with(sharedPreferences?.edit()) {
                this?.putBoolean("NIGHT_MODE", isChecked)
                this?.apply()
            }
        }
    }

    private fun languageMode() {
        val languageSwitch = binding.switchLanguaje

        val languagePreference = sharedPreferences?.getString("LANGUAGE", "en")

        // Remove the listener before setting the checked state
        languageSwitch.setOnCheckedChangeListener(null)

        // Verifica el idioma actual de la aplicación e inicializa el interruptor en la posición correspondiente
        languageSwitch.isChecked = languagePreference == "es"

        languageSwitch.setOnCheckedChangeListener { _, isChecked ->
            val newLanguage = if (isChecked) "es" else "en"

            // Actualiza el idioma de la aplicación
            val locale = Locale(newLanguage)
            Locale.setDefault(locale)

            val config = Configuration()
            config.setLocale(locale)

            // Guarda la preferencia para futuros usos
            with(sharedPreferences?.edit()) {
                this?.putString("LANGUAGE", newLanguage)
                this?.apply()
            }

            // Actualiza la actividad para reflejar el cambio de idioma
            requireActivity().recreate()
        }
    }
}