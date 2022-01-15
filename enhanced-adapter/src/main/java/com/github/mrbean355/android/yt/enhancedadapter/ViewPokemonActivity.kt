package com.github.mrbean355.android.yt.enhancedadapter

import android.os.Bundle
import android.view.Menu
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import com.github.mrbean355.android.framework.PokemonRepository
import kotlinx.android.synthetic.main.activity_view_pokemon.*

class ViewPokemonActivity : AppCompatActivity() {
    private lateinit var adapter: PokemonAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_pokemon)

        adapter = PokemonAdapter()
        recycler_view.adapter = adapter

        PokemonRepository().getAllAsLiveData().observe(this) {
            progress_bar.visibility = View.GONE
            adapter.setItems(it)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.view_pokemon, menu)
        val searchView = menu.findItem(R.id.action_search)?.actionView as SearchView?
        searchView?.setOnQueryTextListener(object : SearchView.OnQueryTextListener {

            override fun onQueryTextSubmit(query: String?): Boolean {
                adapter.filter(query)
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                adapter.filter(newText)
                return false
            }
        })
        return true
    }
}
