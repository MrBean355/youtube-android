package com.github.mrbean355.android.viewmodel.data

import com.github.mrbean355.android.viewmodel.data.dto.PokemonResponse
import retrofit2.Call
import retrofit2.http.GET

interface PokemonService {

    @GET("pokemon?limit=1000")
    fun getAll(): Call<PokemonResponse>
}