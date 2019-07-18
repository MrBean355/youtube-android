package com.github.mrbean355.android.viewmodel

import android.os.AsyncTask
import com.github.mrbean355.android.framework.Pokemon
import com.github.mrbean355.android.framework.PokemonRepository

class ViewPokemonViewModel {

    fun initialise(onSuccess: (items: List<Pokemon>) -> Unit) {
        GetPokemonTask(onSuccess).execute()
    }

    private class GetPokemonTask(private val onSuccess: (items: List<Pokemon>) -> Unit)
        : AsyncTask<Void, Void, List<Pokemon>>() {

        private val repository = PokemonRepository()

        override fun doInBackground(vararg params: Void?): List<Pokemon> {
            return repository.getAll()
        }

        override fun onPostExecute(result: List<Pokemon>) {
            onSuccess(result)
        }
    }
}