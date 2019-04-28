package com.github.mrbean355.android.dagger2.factory

import com.github.mrbean355.android.dagger2.ui.ViewHeroesViewModel

object ViewHeroesViewModelFactory {

    fun newInstance(): ViewHeroesViewModel {
        val repository = HeroRepositoryFactory.newInstance()
        return ViewHeroesViewModel(repository)
    }
}