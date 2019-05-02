package com.github.mrbean355.android.dagger2.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.github.mrbean355.android.dagger2.R
import com.github.mrbean355.android.dagger2.data.Hero

class HeroAdapter : RecyclerView.Adapter<HeroAdapter.ViewHolder>() {
    private var items: List<Hero> = emptyList()

    fun setItems(items: List<Hero>) {
        this.items = items.sortedBy { it.localized_name }
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return ViewHolder(inflater.inflate(R.layout.item_hero, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.name.text = items[position].localized_name
        holder.roles.text = items[position].roles.toString()
    }

    override fun getItemCount() = items.size

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val name: TextView = itemView.findViewById(R.id.hero_name)
        val roles: TextView = itemView.findViewById(R.id.hero_roles)
    }
}