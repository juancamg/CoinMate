package com.example.proyecto_coinmate

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatDelegate

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        preSplashLogic()
        startActivity(Intent(this, MainActivity::class.java))
    }

    private fun preSplashLogic() {
        val sharedPreferences = getSharedPreferences("MODE", Context.MODE_PRIVATE)
        val nightMode = sharedPreferences.getBoolean("NIGHT_MODE", false)

        if (!sharedPreferences.contains("NIGHT_MODE")) {
            with(sharedPreferences.edit()) {
                putBoolean("NIGHT_MODE", false)
                apply()
            }
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        } else {
            if (nightMode) {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
            } else {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
            }
        }
    }
}