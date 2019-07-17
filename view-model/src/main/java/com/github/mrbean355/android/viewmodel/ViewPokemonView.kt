package com.github.mrbean355.android.viewmodel

import com.github.mrbean355.android.viewmodel.data.dto.Pokemon

interface ViewPokemonView {

    fun displayItems(items: List<Pokemon>)
}