package com.github.mrbean355.android.navigation.navdrawer

import android.os.Bundle
import android.view.MenuItem
import androidx.annotation.IdRes
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.github.mrbean355.android.navigation.navdrawer.fragment.*
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_nav_drawer.*

class NavDrawerActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nav_drawer)
        setSupportActionBar(toolbar)

        val toggle = ActionBarDrawerToggle(this, drawer_layout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawer_layout.addDrawerListener(toggle)
        toggle.syncState()

        nav_view.setNavigationItemSelectedListener(this)
        nav_view.setCheckedItem(R.id.nav_home)
        loadFragmentFor(R.id.nav_home)
    }

    override fun onBackPressed() {
        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        drawer_layout.closeDrawer(GravityCompat.START)
        loadFragmentFor(item.itemId)
        return true
    }

    private fun loadFragmentFor(@IdRes itemId: Int) {
        val fragment = when (itemId) {
            R.id.nav_home -> {
                setTitle(R.string.menu_home)
                HomeFragment()
            }
            R.id.nav_gallery -> {
                setTitle(R.string.menu_gallery)
                GalleryFragment()
            }
            R.id.nav_slideshow -> {
                setTitle(R.string.menu_slideshow)
                SlideshowFragment()
            }
            R.id.nav_tools -> {
                setTitle(R.string.menu_tools)
                ToolsFragment()
            }
            R.id.nav_share -> {
                setTitle(R.string.menu_share)
                ShareFragment()
            }
            R.id.nav_send -> {
                setTitle(R.string.menu_send)
                SendFragment()
            }
            else -> throw IllegalArgumentException("Unexpected item")
        }
        supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, fragment)
                .commit()
    }
}
