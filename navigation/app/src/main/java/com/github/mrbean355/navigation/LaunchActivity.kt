package com.github.mrbean355.navigation

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.github.mrbean355.navigation.basic.MainActivity
import kotlinx.android.synthetic.main.activity_launch.*

class LaunchActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_launch)
        basic_button.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }
    }
}