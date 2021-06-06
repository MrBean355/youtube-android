package com.github.mrbean355.android.yt.enhancedadapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.github.mrbean355.android.EnhancedAdapter
import com.github.mrbean355.android.framework.Pokemon

class PokemonAdapter : EnhancedAdapter<Pokemon, PokemonAdapter.ViewHolder>(PokemonDiffCallbacks(), 5) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return ViewHolder(inflater.inflate(R.layout.item_pokemon, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val itemAt = getItemAt(position)
        holder.name.text = itemAt.name
        holder.url.text = itemAt.url
        holder.itemView.setBackgroundColor(ContextCompat.getColor(holder.itemView.context, if (isItemSelected(position)) R.color.colorAccent else android.R.color.transparent))
        holder.itemView.setOnClickListener {
            onItemClicked(holder.bindingAdapterPosition)
        }
    }

    override fun compareItems(lhs: Pokemon, rhs: Pokemon): Int {
        return lhs.name.compareTo(rhs.name, ignoreCase = true)
    }

    override fun testItem(item: Pokemon, query: String): Boolean {
        return item.name.contains(query, ignoreCase = true)
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val name: TextView = itemView.findViewById(R.id.pokemon_name)
        val url: TextView = itemView.findViewById(R.id.pokemon_url)
    }
}

private class PokemonDiffCallbacks : DiffUtil.ItemCallback<Pokemon>() {

    override fun areItemsTheSame(oldItem: Pokemon, newItem: Pokemon): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: Pokemon, newItem: Pokemon): Boolean {
        return true
    }
}