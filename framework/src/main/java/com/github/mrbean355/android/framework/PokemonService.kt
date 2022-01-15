package com.github.mrbean355.android.framework

import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface PokemonService {

    @GET("pokemon?limit=1000")
    suspend fun getAll(): Response<PokemonResponse>

}

@Suppress("FunctionName") // Fake constructor.
fun PokemonService(): PokemonService {
    return Retrofit.Builder()
        .baseUrl("https://pokeapi.co/api/v2/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(PokemonService::class.java)
}

data class PokemonResponse(
    val count: Int,
    val results: List<Pokemon>
)