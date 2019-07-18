package com.github.mrbean355.android.framework

import retrofit2.Call
import retrofit2.http.GET

internal interface PokemonService {

    @GET("pokemon?limit=1000")
    fun getAll(): Call<PokemonResponse>
}

internal data class PokemonResponse(
        val count: Int,
        val results: List<Pokemon>)