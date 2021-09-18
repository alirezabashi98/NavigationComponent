package com.alireza.bashi.testnavigation

import android.content.res.Configuration
import android.content.res.Resources
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.*
import com.alireza.bashi.testnavigation.databinding.ActivityMainBinding
import android.util.DisplayMetrics
import java.util.*


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController

    private lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navController = navHostFragment.findNavController()

        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.homeFragment,
                R.id.searchFragment
            ),
            binding.drawerLayout
        )

        setSupportActionBar(binding.toolbar)

        setupActionBarWithNavController(navController, appBarConfiguration)

        binding.bottomNavMenu.setupWithNavController(navController)
        binding.navView.setupWithNavController(navController)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.option_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.rtl -> {
                binding.root.layoutDirection = View.LAYOUT_DIRECTION_RTL
                val resources: Resources = resources
                val configuration: Configuration = resources.configuration
                val displayMetrics: DisplayMetrics = resources.displayMetrics
                configuration.setLocale(Locale("fa"))
                resources.updateConfiguration(configuration, displayMetrics)
                true
            }
            R.id.ltr -> {
                binding.root.layoutDirection = View.LAYOUT_DIRECTION_LTR
                val resources: Resources = resources
                val configuration: Configuration = resources.configuration
                val displayMetrics: DisplayMetrics = resources.displayMetrics
                configuration.setLocale(Locale.US)
                resources.updateConfiguration(configuration, displayMetrics)
                true
            }
            R.id.termsFragment -> {
                val action = NavGraphDirections.actionGlobalTermsFragment()
                navController.navigate(action)
                true
            }
            else -> {
                item.onNavDestinationSelected(navController) || super.onOptionsItemSelected(item)
            }
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }

}