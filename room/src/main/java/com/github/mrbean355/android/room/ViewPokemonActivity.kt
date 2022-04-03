package com.github.mrbean355.android.room

import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.RecyclerView
import com.github.mrbean355.android.framework.Pokemon
import com.github.mrbean355.android.framework.PokemonAdapter
import com.github.mrbean355.android.framework.PokemonRepository
import com.github.mrbean355.android.room.db.PokemonDatabase
import com.github.mrbean355.android.room.db.PokemonEntity
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

/**
 * NOTE: All this logic should be moved out of the activity!
 * For example, a view model + repository could be used.
 */
class ViewPokemonActivity : AppCompatActivity() {
    private lateinit var adapter: PokemonAdapter
    private lateinit var progressBar: ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_pokemon)
        progressBar = findViewById(R.id.progress_bar)

        adapter = PokemonAdapter()
        findViewById<RecyclerView>(R.id.recycler_view).adapter = adapter
        loadPokemon()
    }

    private fun loadPokemon() {
        lifecycleScope.launch(context = IO) {
            var items = loadFromDatabase()
            if (items.isEmpty()) {
                items = loadFromService()
                saveToDatabase(items)
            }
            withContext(Main) {
                adapter.setItems(items)
                progressBar.visibility = View.GONE
            }
        }
    }

    private fun loadFromDatabase(): List<Pokemon> {
        val db = PokemonDatabase.getInstance(application)
        val dao = db.pokemonDao()
        return dao.getAll().map { Pokemon(it.name, it.url) }
    }

    private fun saveToDatabase(items: List<Pokemon>) {
        val db = PokemonDatabase.getInstance(application)
        val dao = db.pokemonDao()
        dao.insertAll(items.map { PokemonEntity(0, it.name, it.url) })
    }

    private suspend fun loadFromService(): List<Pokemon> {
        return PokemonRepository().getAll()
    }
}
