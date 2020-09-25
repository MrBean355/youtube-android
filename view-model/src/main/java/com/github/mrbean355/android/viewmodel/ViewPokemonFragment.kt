package com.github.mrbean355.android.viewmodel

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.github.mrbean355.android.framework.PokemonAdapter
import kotlinx.android.synthetic.main.fragment_view_pokemon.*

class ViewPokemonFragment : Fragment() {
    private lateinit var adapter: PokemonAdapter

    // If you don't use Kotlin, instantiate the view model in onViewCreated():
    // viewModel = new ViewModelProvider(this).get(ViewPokemonViewModel.class);
    private val viewModel by viewModels<ViewPokemonViewModel>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_view_pokemon, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter = PokemonAdapter()
        recycler_view.adapter = adapter

        viewModel.pokemon.observe(viewLifecycleOwner) {
            progress_bar.visibility = View.GONE
            adapter.setItems(it)
        }
    }
}