package com.github.mrbean355.android.viewmodel

import androidx.lifecycle.ViewModel
import com.github.mrbean355.android.framework.PokemonRepository

class ViewPokemonViewModel : ViewModel() {
    // Store your data in a field, so it is retained when the activity/fragment is recreated.
    val pokemon = PokemonRepository().getAllAsLiveData()
}