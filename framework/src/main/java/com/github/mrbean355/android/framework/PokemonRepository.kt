package com.github.mrbean355.android.framework

import androidx.annotation.MainThread
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class PokemonRepository {
    private val service = PokemonService()

    /** Make a blocking service call to fetch all Pokemon. */
    suspend fun getAll(): List<Pokemon> {
        delay(1000) // emulate a long service call.
        val response = service.getAll()
        val body = response.body()
        if (response.isSuccessful && body != null) {
            return body.results
        }
        throw RuntimeException("Error fetching Pokemon: ${response.code()}")
    }

    /** Make a non-blocking service call to fetch all Pokemon. */
    @MainThread
    fun getAllAsLiveData(): LiveData<List<Pokemon>> {
        val liveData = MutableLiveData<List<Pokemon>>()
        GlobalScope.launch(context = IO) {
            liveData.postValue(getAll())
        }
        return liveData
    }
}