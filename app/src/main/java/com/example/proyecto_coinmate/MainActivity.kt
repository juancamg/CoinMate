package com.example.proyecto_coinmate

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AppCompatDelegate
import com.example.proyecto_coinmate.databinding.ActivityMainBinding
import java.util.Locale

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setAppTheme()
        setAppLanguage()

        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)
    }

    private fun setAppTheme() {
        val sharedPreferences = getSharedPreferences("MODE", Context.MODE_PRIVATE)
        val nightMode = sharedPreferences.getBoolean("NIGHT_MODE", false)

        if (nightMode) {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
        } else {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        }
    }

    private fun setAppLanguage() {
        // Se cargan las preferencias de lenguaje
        val sharedPreferences = getSharedPreferences("MODE", Context.MODE_PRIVATE)
        val language = sharedPreferences.getString("LANGUAGE", "en")

        val recursos = resources
        val displayMetrics = recursos.displayMetrics
        val config = resources.configuration
        config.setLocale(Locale(language))
        recursos.updateConfiguration(config,displayMetrics)
        config.locale=Locale(language)
        resources.updateConfiguration(config,displayMetrics)
    }
}