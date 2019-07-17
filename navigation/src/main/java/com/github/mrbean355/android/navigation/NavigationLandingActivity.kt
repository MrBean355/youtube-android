package com.github.mrbean355.android.navigation

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.github.mrbean355.android.navigation.basic.BasicNavigationActivity
import com.github.mrbean355.android.navigation.bottomnav.BottomNavActivity
import com.github.mrbean355.android.navigation.navdrawer.NavDrawerActivity
import com.github.mrbean355.android.navigation.navdrawer.NavDrawerActivity_Java
import kotlinx.android.synthetic.main.activity_navigation_landing.*

class NavigationLandingActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_navigation_landing)
        basic_button.setOnClickListener {
            startActivity(Intent(this, BasicNavigationActivity::class.java))
        }
        bottom_nav_button.setOnClickListener {
            startActivity(Intent(this, BottomNavActivity::class.java))
        }
        nav_drawer_kt_button.setOnClickListener {
            startActivity(Intent(this, NavDrawerActivity::class.java))
        }
        nav_drawer_java_button.setOnClickListener {
            startActivity(Intent(this, NavDrawerActivity_Java::class.java))
        }
    }
}