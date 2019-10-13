package com.github.mrbean355.android.viewmodel

import com.github.mrbean355.android.framework.Pokemon
import com.github.mrbean355.android.framework.PokemonRepository
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ViewPokemonViewModel {

    fun initialise(onSuccess: (items: List<Pokemon>) -> Unit) {
        GlobalScope.launch(context = IO) {
            val data = PokemonRepository().getAll()
            withContext(Main) {
                onSuccess(data)
            }
        }
    }
}