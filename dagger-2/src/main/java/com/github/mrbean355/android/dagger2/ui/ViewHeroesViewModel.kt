package com.github.mrbean355.android.dagger2.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.github.mrbean355.android.dagger2.data.Hero
import com.github.mrbean355.android.dagger2.data.HeroRepository
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import javax.inject.Inject

class ViewHeroesViewModel @Inject constructor(private val repository: HeroRepository) {

    fun getHeroes(): LiveData<List<Hero>> {
        val liveData = MutableLiveData<List<Hero>>()
        GlobalScope.launch(context = IO) {
            liveData.postValue(repository.getHeroes())
        }
        return liveData
    }
}