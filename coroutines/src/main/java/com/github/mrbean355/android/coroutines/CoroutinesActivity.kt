package com.github.mrbean355.android.coroutines

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import kotlinx.android.synthetic.main.activity_coroutines.*

// Nothing special in the activity regarding coroutines.
class CoroutinesActivity : AppCompatActivity(R.layout.activity_coroutines) {
    private val viewModel by viewModels<CoroutinesViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel.onCreate()
        viewModel.loading.observe(this) {
            progress_bar.isVisible = it
        }
        viewModel.result.observe(this) {
            coroutines_result.text = it
        }
    }
}