package com.github.mrbean355.android.dagger2.factory

import com.github.mrbean355.android.dagger2.data.OpenDotaService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object OpenDotaServiceFactory {
    private val retrofit = Retrofit.Builder()
            .baseUrl("https://api.opendota.com/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    fun newInstance(): OpenDotaService {
        return retrofit.create(OpenDotaService::class.java)
    }
}