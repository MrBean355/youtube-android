package com.github.mrbean355.android.yt.enhancedadapter

import android.os.Bundle
import android.view.Menu
import android.view.View
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.RecyclerView
import com.github.mrbean355.android.framework.PokemonRepository

class ViewPokemonActivity : AppCompatActivity() {
    private lateinit var adapter: PokemonAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_pokemon)

        val progressBar = findViewById<ProgressBar>(R.id.progress_bar)
        adapter = PokemonAdapter()
        findViewById<RecyclerView>(R.id.recycler_view).adapter = adapter

        PokemonRepository().getAllAsLiveData().observe(this) {
            progressBar.visibility = View.GONE
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
