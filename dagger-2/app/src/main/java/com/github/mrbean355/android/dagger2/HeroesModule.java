package com.github.mrbean355.android.dagger2;

import com.github.mrbean355.android.dagger2.data.HeroRepository;
import com.github.mrbean355.android.dagger2.data.HeroRepositoryImpl;
import com.github.mrbean355.android.dagger2.data.OpenDotaService;
import com.github.mrbean355.android.dagger2.ui.ViewHeroesActivity;

import javax.inject.Singleton;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import dagger.android.ContributesAndroidInjector;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public abstract class HeroesModule {

    @ContributesAndroidInjector
    abstract ViewHeroesActivity contributeViewHeroesActivity();

    @Binds
    abstract HeroRepository bindRepo(HeroRepositoryImpl impl);

    @Provides
    @Singleton
    static OpenDotaService provideService() {
        return new Retrofit.Builder()
                .baseUrl("https://api.opendota.com/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(OpenDotaService.class);
    }
}
