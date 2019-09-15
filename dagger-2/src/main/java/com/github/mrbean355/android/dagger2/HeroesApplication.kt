package com.github.mrbean355.android.dagger2

import android.app.Application
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import javax.inject.Inject

/**
 * Dagger Note:
 * From Dagger version 2.24, we don't need separate `Has*Injector` interfaces for each type.
 * We only need our Application to implement [HasAndroidInjector] and all types (Activities, Fragments etc.) will be supported.
 * In Kotlin, the field type should be `DispatchingAndroidInjector<Any>`.
 * In Java, the field type should be `DispatchingAndroidInjector<Object>`.
 */
class HeroesApplication : Application(), HasAndroidInjector {
    @Inject
    lateinit var androidInjector: DispatchingAndroidInjector<Any>

    override fun onCreate() {
        super.onCreate()
        DaggerAppComponent
            .create()
            .inject(this)
    }

    override fun androidInjector() = androidInjector
}