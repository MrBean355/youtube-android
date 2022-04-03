package com.github.mrbean355.android.navigation.navdrawer

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.github.mrbean355.android.navigation.R
import com.google.android.material.navigation.NavigationView

/**
 * See the equivalent Java version: [NavDrawerActivity_Java].
 */
class NavDrawerActivity : AppCompatActivity() {
    private lateinit var appBarConfig: AppBarConfiguration
    private lateinit var navController: NavController
    private lateinit var drawerLayout: DrawerLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nav_drawer)
        setSupportActionBar(findViewById(R.id.toolbar))

        /*
         * We could use `AppBarConfiguration(nav_view.menu, drawer_layout)` instead, but since the
         * Share and Send items are nested, they won't be treated as top-level destinations.
         */
        val topLevelDestinations = setOf(R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow, R.id.nav_tools, R.id.nav_share, R.id.nav_send)
        appBarConfig = AppBarConfiguration(topLevelDestinations, findViewById(R.id.drawer_layout))
        drawerLayout = findViewById(R.id.drawer_layout)

        navController = findNavController(R.id.nav_host_fragment)
        setupActionBarWithNavController(navController, appBarConfig)
        findViewById<NavigationView>(R.id.nav_view).setupWithNavController(navController)
    }

    /** Ask the NavController to handle "navigate up" events. */
    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp(appBarConfig) || super.onSupportNavigateUp()
    }

    /** Close the drawer when hardware back is pressed. */
    override fun onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }
}
