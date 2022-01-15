package com.github.mrbean355.android.viewmodel

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class ViewPokemonActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.vm_activity_view_pokemon)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .add(R.id.fragment_container, ViewPokemonFragment())
                .commit()
        }
    }
}
