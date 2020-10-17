package com.github.mrbean355.android.coroutines

import androidx.annotation.VisibleForTesting
import com.github.mrbean355.android.framework.PokemonService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import kotlin.coroutines.CoroutineContext

// Also see the unit tests for this class.
class CoroutinesRepo @VisibleForTesting internal constructor(
        private val dispatcher: CoroutineContext,
        private val pokemonService: PokemonService
) {

    constructor() : this(Dispatchers.IO, PokemonService())

    // Use the 'suspend' modifier because it calls another suspend function: 'withContext()'.
    // The function body is wrapped in 'withContext()', meaning it will switch to the IO dispatcher
    // while the function executes.
    // Once it finishes, it will switch back to the previous dispatcher (main in this case).
    suspend fun fetchData(): List<String> = withContext(dispatcher) {
        pokemonService.getAll().body()?.results.orEmpty()
                .take(10)
                .map { it.name }
    }
}