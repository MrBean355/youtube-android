package com.github.mrbean355.android.dagger2.ui

import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.github.mrbean355.android.dagger2.R
import dagger.android.AndroidInjection
import javax.inject.Inject

class ViewHeroesActivity : AppCompatActivity() {
    @Inject
    lateinit var viewModel: ViewHeroesViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_heroes)

        val progressBar = findViewById<ProgressBar>(R.id.progress_bar)
        val adapter = HeroAdapter()
        findViewById<RecyclerView>(R.id.recycler_view).adapter = adapter

        viewModel.getHeroes().observe(this) {
            progressBar.visibility = if (it.isEmpty()) View.VISIBLE else View.GONE
            adapter.setItems(it)
        }
    }
}
