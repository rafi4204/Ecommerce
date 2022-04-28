package com.example.ecommerce

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import com.example.ecommerce.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var navController: NavController? = null
    private var navHostFragment: NavHostFragment? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        getNavController()
        // getToolbar()
        val appLinkIntent = intent
        val appLinkAction = appLinkIntent.action
        val appLinkData = appLinkIntent.data
    }

    private fun getNavController() {
        navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navController = navHostFragment?.navController
    }

    /* private fun getToolbar() {
         val appBarConfiguration = AppBarConfiguration(
             topLevelDestinationIds = setOf(R.id.imageGalleryFragment, R.id.fullScreenImageFragment),
             fallbackOnNavigateUpListener = ::onSupportNavigateUp
         )
       *//*  navController?.let {
            setSupportActionBar(findViewById(R.id.toolbar))
            if (appBarConfiguration != null) {
                findViewById<Toolbar>(R.id.toolbar)
                    .setupWithNavController(it, appBarConfiguration)
            }
        }*//*


    }*/
}