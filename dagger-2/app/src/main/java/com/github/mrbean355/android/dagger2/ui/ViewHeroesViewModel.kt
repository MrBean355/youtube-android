package com.github.mrbean355.android.dagger2.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.github.mrbean355.android.dagger2.data.Hero
import com.github.mrbean355.android.dagger2.data.HeroRepository

class ViewHeroesViewModel(private val repository: HeroRepository) {

    fun getHeroes(): LiveData<List<Hero>> {
        val liveData = MutableLiveData<List<Hero>>()
        Thread {
            liveData.postValue(repository.getHeroes())
        }.start()
        return liveData
    }
}