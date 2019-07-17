package com.github.mrbean355.android.yt.enhancedadapter

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

data class PokemonResponse(val results: List<Pokemon>)

data class Pokemon(val name: String)

interface PokemonService {

    @GET("pokemon?limit=999")
    fun getPokemon(): Call<PokemonResponse>
}

fun getPokemon(): LiveData<List<Pokemon>> {
    val liveData = MutableLiveData<List<Pokemon>>()

    Retrofit.Builder()
            .baseUrl("https://pokeapi.co/api/v2/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(PokemonService::class.java)
            .getPokemon()
            .enqueue(object : Callback<PokemonResponse> {
                override fun onResponse(call: Call<PokemonResponse>, response: Response<PokemonResponse>) {
                    liveData.value = response.body()?.results.orEmpty()
                }

                override fun onFailure(call: Call<PokemonResponse>, t: Throwable) {
                    Log.e("Pokemon", "Error fetching Pokemon", t)
                }
            })

    return liveData
}