package com.github.mrbean355.android.coroutines

import androidx.annotation.VisibleForTesting
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class CoroutinesViewModel @VisibleForTesting internal constructor(
        private val repo: CoroutinesRepo
) : ViewModel() {

    private val _loading = MutableLiveData<Boolean>()
    val loading: LiveData<Boolean> = _loading

    private val _result = MutableLiveData<String>()
    val result: LiveData<String> = _result

    @Suppress("unused") // Needed by ViewModelProvider.
    constructor() : this(CoroutinesRepo())

    fun onCreate() {
        // Launch a new coroutine.
        // Similar to starting a new thread, but 'viewModelScope' defaults to the main thread.
        viewModelScope.launch {
            // At this point, we're still on the main thread, since that's what 'viewModelScope'
            // defaults to.
            _loading.value = true

            // 'fetchData()' will switch to a background thread while it executes.
            val data = repo.fetchData()

            // We're still on the main thread here, we can update the UI without worrying about
            // updating views from a background thread.
            _loading.value = false
            _result.value = data.joinToString()
        }
    }
}