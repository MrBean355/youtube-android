package com.github.mrbean355.android.dagger2.data

class HeroRepositoryImpl(private val openDotaService: OpenDotaService) : HeroRepository {

    override fun getHeroes(): List<Hero> {
        return openDotaService.getHeroes().execute().body().orEmpty()
    }
}