package com.example.proyecto_coinmate

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.core.view.setPadding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btn_Main_goto = findViewById<Button>(R.id.btn_Main_goto)
        val et_Main_name = findViewById<EditText>(R.id.et_Main_name)
        val tv_Main_advise = findViewById<TextView>(R.id.tv_main_advise)

        btn_Main_goto.setOnClickListener {
            if (et_Main_name.text.isEmpty()) {
                tv_Main_advise.text = getString(R.string.msg_main_advise)
                tv_Main_advise.setPadding(20)
            } else {
                val intent = Intent(this, CreditActivity::class.java)
                val name = et_Main_name.text.toString()
                intent.putExtra("USER", name)
                startActivity(intent)
            }

        }
    }
}