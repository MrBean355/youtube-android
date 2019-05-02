package com.github.mrbean355.android.dagger2

import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import javax.inject.Singleton

@Singleton
@Component(modules = [
    AndroidInjectionModule::class,
    HeroesModule::class
])
interface AppComponent : AndroidInjector<HeroesApplication>