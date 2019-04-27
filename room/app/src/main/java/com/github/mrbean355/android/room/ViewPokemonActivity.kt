package com.github.mrbean355.android.room

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.github.mrbean355.android.room.db.PokemonDatabase
import com.github.mrbean355.android.room.db.PokemonEntity
import com.github.mrbean355.android.room.dto.Pokemon
import kotlinx.android.synthetic.main.activity_view_pokemon.*
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * NOTE: All this logic should be moved out of the activity!
 * For example, a view model + repository could be used.
 */
class ViewPokemonActivity : AppCompatActivity() {
    private lateinit var adapter: PokemonAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_pokemon)

        adapter = PokemonAdapter()
        recycler_view.adapter = adapter
        loadPokemon()
    }

    private fun loadPokemon() {
        Thread {
            var items = loadFromDatabase()
            if (items.isEmpty()) {
                items = loadFromService()
                saveToDatabase(items)
            }
            runOnUiThread {
                adapter.setItems(items)
                progress_bar.visibility = View.GONE
            }
        }.start()
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

    private fun loadFromService(): List<Pokemon> {
        val service = Retrofit.Builder()
                .baseUrl("https://pokeapi.co/api/v2/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(PokemonService::class.java)

        // Simulate a long-running service call. Don't do this!
        Thread.sleep(2000)
        return service.getAll().execute().body()?.results.orEmpty()
    }
}
