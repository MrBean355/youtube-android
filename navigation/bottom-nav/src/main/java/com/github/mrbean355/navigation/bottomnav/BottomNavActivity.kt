package com.github.mrbean355.navigation.bottomnav

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.activity_bottom_nav.*

class BottomNavActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bottom_nav)

        bottom_nav_view.setOnNavigationItemSelectedListener { menuItem ->
            val fragment = when (menuItem.itemId) {
                R.id.firstBottomNavFragment -> FirstBottomNavFragment()
                R.id.secondBottomNavFragment -> SecondBottomNavFragment()
                R.id.thirdBottomNavFragment -> ThirdBottomNavFragment()
                else -> throw IllegalStateException("Unexpected menu item")
            }
            loadFragment(fragment)
            true
        }
        bottom_nav_view.selectedItemId = R.id.firstBottomNavFragment
    }

    private fun loadFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .commit()
    }
}