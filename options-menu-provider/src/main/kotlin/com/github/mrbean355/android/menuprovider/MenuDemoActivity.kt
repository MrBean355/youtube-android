package com.github.mrbean355.android.menuprovider

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MenuDemoActivity : AppCompatActivity(R.layout.activity_menu_demo) {
    private var showFragment = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        findViewById<View>(R.id.toggle_fragment_visibility).setOnClickListener {
            toggleFragmentVisibility()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        super.onCreateOptionsMenu(menu)
        menuInflater.inflate(R.menu.menu_activity_demo, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.demo_activity_menu_item) {
            Toast.makeText(this@MenuDemoActivity, R.string.msg_activity_menu_clicked, Toast.LENGTH_SHORT).show()
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    private fun toggleFragmentVisibility() {
        showFragment = !showFragment
        if (showFragment) showFragment() else hideFragment()
    }

    private fun showFragment() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, MenuDemoFragment())
            .commit()
    }

    private fun hideFragment() {
        supportFragmentManager.findFragmentById(R.id.fragment_container)?.let {
            supportFragmentManager.beginTransaction()
                .remove(it)
                .commit()
        }
    }
}
