package com.github.mrbean355.android.room

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_view_pokemon.*

class ViewPokemonActivity : AppCompatActivity() {
    private lateinit var adapter: PokemonAdapter
    private lateinit var viewModel: ViewPokemonViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_pokemon)

        adapter = PokemonAdapter()
        recycler_view.adapter = adapter

        viewModel = ViewPokemonViewModel(PokemonRepository.newInstance())
        viewModel.initialise { items ->
            runOnUiThread {
                progress_bar.visibility = View.GONE
                adapter.setItems(items)
            }
        }
    }
}
