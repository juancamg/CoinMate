package com.example.proyecto_coinmate

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.commit
import com.example.proyecto_coinmate.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater) // Inflate the layout for this activity
        setContentView(binding.root)

        // Show the LoginFragment con bindings
        supportFragmentManager.commit {
            setReorderingAllowed(true)
            add(R.id.fcv_mainActivity, LoginFragment())
        }





    }
}