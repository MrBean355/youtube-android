package com.github.mrbean355.android.coroutines

import com.github.mrbean355.android.framework.Pokemon
import com.github.mrbean355.android.framework.PokemonResponse
import com.github.mrbean355.android.framework.PokemonService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mock
import org.mockito.junit.MockitoJUnit
import org.mockito.junit.MockitoRule
import org.mockito.kotlin.whenever
import retrofit2.Response

@ExperimentalCoroutinesApi
class CoroutinesRepoTest {
    @Mock
    private lateinit var service: PokemonService
    private lateinit var repo: CoroutinesRepo

    @get:Rule
    val mockitoRule: MockitoRule = MockitoJUnit.rule()

    @Before
    fun setUp() {
        // This function has been deprecated; see the 'mockitoRule' property above.
        // initMocks(this)
        repo = CoroutinesRepo(Dispatchers.Unconfined, service)
    }

    // Use 'runTest { }' when you need to call a suspend function from tests.
    // 'runBlockingTest { }' was deprecated in Coroutines 1.6.0.
    @Test
    fun testFetchData_ShouldReturnFixedString() = runTest {
        whenever(service.getAll()).thenReturn(Response.success(getMockData()))

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