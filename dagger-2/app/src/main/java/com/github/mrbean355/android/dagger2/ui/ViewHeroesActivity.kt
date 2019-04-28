package com.github.mrbean355.android.dagger2.ui

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.github.mrbean355.android.dagger2.R
import com.github.mrbean355.android.dagger2.factory.ViewHeroesViewModelFactory
import kotlinx.android.synthetic.main.activity_view_heroes.*

class ViewHeroesActivity : AppCompatActivity() {
    private lateinit var viewModel: ViewHeroesViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_heroes)

        val adapter = HeroAdapter()
        recycler_view.adapter = adapter

        viewModel = ViewHeroesViewModelFactory.newInstance()
        viewModel.getHeroes().observe(this, Observer {
            progress_bar.visibility = if (it.isEmpty()) View.VISIBLE else View.GONE
            adapter.setItems(it)
        })
    }
}
