package com.github.mrbean355.android.viewmodel

import android.os.Handler
import android.os.Looper
import com.github.mrbean355.android.viewmodel.data.PokemonRepository
import com.github.mrbean355.android.viewmodel.data.dto.Pokemon

class ViewPokemonViewModel {
    private val repository = PokemonRepository()
    private val handler = Handler(Looper.getMainLooper())
    private var items: List<Pokemon>? = null

    fun initialise(view: ViewPokemonView) {
        val i1 = items
        if (i1 != null) {
            view.displayItems(i1)
        } else {
            Thread {
                val i2 = repository.getAll()
                handler.post {
                    items = i2
                    view.displayItems(i2)
                }
            }.start()
        }
    }
}