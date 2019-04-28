package com.github.mrbean355.android.dagger2.factory

import com.github.mrbean355.android.dagger2.data.HeroRepository
import com.github.mrbean355.android.dagger2.data.HeroRepositoryImpl

object HeroRepositoryFactory {

    fun newInstance(): HeroRepository {
        val openDotaService = OpenDotaServiceFactory.newInstance()
        return HeroRepositoryImpl(openDotaService)
    }
}