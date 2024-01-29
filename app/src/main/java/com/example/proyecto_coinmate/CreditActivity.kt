package com.example.proyecto_coinmate

import android.content.Intent
import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import java.util.Locale

class CreditActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_credit)

        val tv_Credit_version = findViewById<TextView>(R.id.tv_Credit_version)
        val nombre = intent.getStringExtra("USER")

        tv_Credit_version.apply{
            text = getString(R.string.msg_credit_version, nombre)
        }


        val btnEs = findViewById<Button>(R.id.btnEs)
        val btnEn = findViewById<Button>(R.id.btnEn)
        val btn_credit_volver = findViewById<Button>(R.id.btn_credit_volver)

        fun setLocale(lang: String) {
            val locale = Locale(lang)
            Locale.setDefault(locale)
            val config = Configuration()
            config.locale = locale
            baseContext.resources.updateConfiguration(config, baseContext.resources.displayMetrics)
        }

        btnEs.setOnClickListener {
            setLocale("es")
            recreate()
        }

        btnEn.setOnClickListener {
            setLocale("en")
            recreate()
        }

        btn_credit_volver.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }

    }
}