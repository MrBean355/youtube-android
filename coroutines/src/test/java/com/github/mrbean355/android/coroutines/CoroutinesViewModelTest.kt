package com.github.mrbean355.android.coroutines

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runBlockingTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify
import org.mockito.MockitoAnnotations.initMocks

@ExperimentalCoroutinesApi
class CoroutinesViewModelTest {
    @Mock
    private lateinit var mockRepo: CoroutinesRepo
    private lateinit var viewModel: CoroutinesViewModel

    @get:Rule
    val rule = InstantTaskExecutorRule()

    @Before
    fun setUp() {
        initMocks(this)

        // When running tests without Robolectric, no main dispatcher is loaded.
        // We can set the main dispatcher to a test one.
        // Be sure to reset it in @After of your tests.
        Dispatchers.setMain(Dispatchers.Unconfined)

        // Since 'fetchData()' is a suspend function, it needs to be called from a coroutine.
        // In tests, we can use 'runBlocking { }' or 'runBlockingTest { }'.
        runBlocking {
            `when`(mockRepo.fetchData()).thenReturn(listOf("1", "2", "3"))
        }

        viewModel = CoroutinesViewModel(mockRepo)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun testOnCreate_FetchesData() = runBlockingTest {
        viewModel.onCreate()

        verify(mockRepo).fetchData()
    }

    @Test
    fun testOnCreate_UpdatesLiveData() {
        viewModel.onCreate()

        assertEquals("1, 2, 3", viewModel.result.value)
    }
}