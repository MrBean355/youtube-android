package com.github.mrbean355.android

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.github.mrbean355.android.dagger2.ui.ViewHeroesActivity
import com.github.mrbean355.android.room.ViewPokemonActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        action_dagger_2.setOnClickListener {
            startActivity(Intent(this, ViewHeroesActivity::class.java))
        }
        action_room.setOnClickListener {
            startActivity(Intent(this, ViewPokemonActivity::class.java))
        }
    }
}
