package com.github.mrbean355.android.dagger2

import com.github.mrbean355.android.dagger2.data.HeroRepository
import com.github.mrbean355.android.dagger2.data.HeroRepositoryImpl
import com.github.mrbean355.android.dagger2.data.OpenDotaService
import com.github.mrbean355.android.dagger2.ui.ViewHeroesActivity
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.android.ContributesAndroidInjector
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
interface HeroesModule {

    @ContributesAndroidInjector
    fun contributeViewHeroesActivity(): ViewHeroesActivity

    @Binds
    fun bindRepo(impl: HeroRepositoryImpl): HeroRepository

    companion object {

        @Provides
        @Singleton
        fun provideService(): OpenDotaService = Retrofit.Builder()
            .baseUrl("https://api.opendota.com/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create()
    }
}
