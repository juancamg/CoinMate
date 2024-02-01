package com.example.proyecto_coinmate

import android.content.Context
import android.content.SharedPreferences
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
        val sharedPreferences = getSharedPreferences("MODE", Context.MODE_PRIVATE)
        val language = sharedPreferences.getString("LANGUAGE", "en")

        val locale = Locale(language)
        Locale.setDefault(locale)

        val config = resources.configuration
        config.setLocale(locale)

        val context = createConfigurationContext(config)
        var resources = context.resources
    }
}