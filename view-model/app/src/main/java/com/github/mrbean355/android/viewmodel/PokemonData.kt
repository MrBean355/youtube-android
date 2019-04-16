package com.github.mrbean355.android.viewmodel

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

class PokemonRepository {
    private val service = Retrofit.Builder()
        .baseUrl("https://pokeapi.co/api/v2/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(PokemonService::class.java)

    fun getAll(): List<Pokemon> {
        Thread.sleep(2000)
        return service.getAll().execute().body()?.results.orEmpty()
    }
}

interface PokemonService {

    @GET("pokemon?limit=1000")
    fun getAll(): Call<PokemonResponse>
}

data class PokemonResponse(
    val count: Int,
    val results: List<Pokemon>
)

data class Pokemon(val name: String, val url: String)
