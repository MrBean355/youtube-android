package com.github.mrbean355.android.room

import com.github.mrbean355.android.room.dto.Pokemon
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class PokemonRepository(private val service: PokemonService) {

    fun getAll(): List<Pokemon> {
        Thread.sleep(2000)
        return service.getAll().execute().body()?.results.orEmpty()
    }

    companion object {

        fun newInstance(): PokemonRepository {
            val service = Retrofit.Builder()
                    .baseUrl("https://pokeapi.co/api/v2/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                    .create(PokemonService::class.java)

            return PokemonRepository(service)
        }
    }
}
