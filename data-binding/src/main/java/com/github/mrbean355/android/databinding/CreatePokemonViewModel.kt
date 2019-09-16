package com.github.mrbean355.android.databinding

import androidx.databinding.ObservableField

class CreatePokemonViewModel {
    val name = ObservableField<CharSequence>()

    fun update() {
        name.set("Mike J")
    }
}