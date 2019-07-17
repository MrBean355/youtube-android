package com.github.mrbean355.android.viewmodel

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.github.mrbean355.android.viewmodel.data.dto.Pokemon
import kotlinx.android.synthetic.main.fragment_view_pokemon.*

class ViewPokemonFragment : Fragment(), ViewPokemonView {
    private lateinit var adapter: PokemonAdapter
    private lateinit var viewModel: ViewPokemonViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_view_pokemon, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter = PokemonAdapter()
        recycler_view.adapter = adapter

        viewModel = ViewPokemonViewModel()
        viewModel.initialise(this)
    }

    override fun displayItems(items: List<Pokemon>) {
        requireActivity().title = "${items.size} Pokemon"
        progress_bar.visibility = View.GONE
        adapter.setItems(items)
    }
}