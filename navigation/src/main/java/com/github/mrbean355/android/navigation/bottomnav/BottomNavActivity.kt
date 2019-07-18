package com.github.mrbean355.android.navigation.bottomnav

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.github.mrbean355.android.navigation.R
import kotlinx.android.synthetic.main.activity_bottom_nav.*

class BottomNavActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bottom_nav)

        val navController = findNavController(R.id.nav_host_fragment)
        bottom_nav_view.setupWithNavController(navController)

        // This will ensure the toolbar's title is set to the current destination's label:
        setupActionBarWithNavController(navController, AppBarConfiguration(bottom_nav_view.menu))
    }
}