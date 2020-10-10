package com.github.mrbean355.android.coroutines

import com.github.mrbean355.android.framework.Pokemon
import com.github.mrbean355.android.framework.PokemonResponse
import com.github.mrbean355.android.framework.PokemonService
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.whenever
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.MockitoAnnotations.initMocks
import retrofit2.Call
import retrofit2.Response

@ExperimentalCoroutinesApi
class CoroutinesRepoTest {
    @Mock
    private lateinit var service: PokemonService
    private lateinit var repo: CoroutinesRepo

    @Before
    fun setUp() {
        initMocks(this)
        repo = CoroutinesRepo(Dispatchers.Unconfined, service)
    }

    // Use 'runBlockingTest { }' when you need to call a suspend function from tests.
    @Test
    fun testFetchData_ShouldReturnFixedString() = runBlockingTest {
        val call = mock<Call<PokemonResponse>>()
        whenever(call.execute()).thenReturn(Response.success(getMockData()))
        whenever(service.getAll()).thenReturn(call)

        val actual = repo.fetchData()

        assertEquals(listOf("0", "1", "2", "3", "4", "5", "6", "7", "8", "9"), actual)
    }

    private fun getMockData(): PokemonResponse {
        val pokemon = mutableListOf<Pokemon>()
        repeat(10) {
            pokemon += createPokemon(it.toString())
        }
        return PokemonResponse(10, pokemon)
    }

    private fun createPokemon(name: String): Pokemon {
        return Pokemon(name, "")
    }
}