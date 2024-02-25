package com.example.proyecto_coinmate

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.Toolbar
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.example.proyecto_coinmate.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setAppTheme()

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val toolbar: Toolbar = binding.toolbar
        setSupportActionBar(toolbar)

        val navFragment = supportFragmentManager.findFragmentById(R.id.navHostFragment) as NavHostFragment
        val navController = navFragment.navController
        NavigationUI.setupActionBarWithNavController(this,navController)

        val bottomNavigationView = binding.bottomNavigationView

        navController.addOnDestinationChangedListener { _, destination, _ ->
            when (destination.id) {
                R.id.loginFragment -> {
                    bottomNavigationView.visibility = View.GONE
                }
                else -> {
                    bottomNavigationView.visibility = View.VISIBLE
                }
            }
        }

        binding.bottomNavigationView.setOnItemSelectedListener { item ->
    when (item.itemId) {
        R.id.bottom_principal -> {
            // Verifica si el destino actual no es fragment_menu antes de navegar
            if (navController.currentDestination?.id != R.id.menuFragment) {
                navController.navigate(R.id.menuFragment)
            }
            true
        }
        R.id.bottom_catalogo -> {
            // Verifica si el destino actual no es item_list antes de navegar
            if (navController.currentDestination?.id != R.id.itemListFragment) {
                navController.navigate(R.id.itemListFragment)
            }
            true
        }
        R.id.bottom_favorites -> {
            // Verifica si el destino actual no es fav_item_list antes de navegar
            if (navController.currentDestination?.id != R.id.favItemListFragment) {
                navController.navigate(R.id.favItemListFragment)
            }
            true
        }
        else -> false
    }
}
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

    override fun onSupportNavigateUp(): Boolean {
        val navController = this.findNavController(R.id.navHostFragment)
        return navController.navigateUp()
    }
}