package com.github.mrbean355.android.dagger2.data

import retrofit2.Call
import retrofit2.http.GET

interface OpenDotaService {

    @GET("heroes")
    fun getHeroes(): Call<List<Hero>>
}