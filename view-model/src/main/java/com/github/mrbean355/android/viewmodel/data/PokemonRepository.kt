package com.github.mrbean355.android.viewmodel.data

import com.github.mrbean355.android.viewmodel.data.dto.Pokemon
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class PokemonRepository {
    private val service = Retrofit.Builder()
            .baseUrl("https://pokeapi.co/api/v2/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(PokemonService::class.java)

    fun getAll(): List<Pokemon> {
        // Simulate a long service call.
        // Don't ever do this!
        Thread.sleep(2000)
        return service.getAll().execute().body()?.results.orEmpty()
    }
}
