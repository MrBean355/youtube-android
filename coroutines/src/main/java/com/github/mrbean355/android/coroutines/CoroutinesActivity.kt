package com.github.mrbean355.android.coroutines

import android.os.Bundle
import android.widget.ProgressBar
import android.widget.TextView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible

// Nothing special in the activity regarding coroutines.
class CoroutinesActivity : AppCompatActivity(R.layout.activity_coroutines) {
    private val viewModel by viewModels<CoroutinesViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val progressBar = findViewById<ProgressBar>(R.id.progress_bar)
        val result = findViewById<TextView>(R.id.coroutines_result)

        viewModel.onCreate()
        viewModel.loading.observe(this) {
            progressBar.isVisible = it
        }
        viewModel.result.observe(this) {
            result.text = it
        }
    }
}