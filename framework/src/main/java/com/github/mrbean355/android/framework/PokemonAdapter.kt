package com.github.mrbean355.android.framework

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class PokemonAdapter : RecyclerView.Adapter<PokemonAdapter.ViewHolder>() {
    private var items: List<Pokemon> = emptyList()

    fun setItems(items: List<Pokemon>) {
        this.items = items.sortedBy { it.name }
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return ViewHolder(inflater.inflate(R.layout.item_pokemon, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.name.text = items[position].name
        holder.url.text = items[position].url
    }

    override fun getItemCount() = items.size

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val name: TextView = itemView.findViewById(R.id.pokemon_name)
        val url: TextView = itemView.findViewById(R.id.pokemon_url)
    }
}