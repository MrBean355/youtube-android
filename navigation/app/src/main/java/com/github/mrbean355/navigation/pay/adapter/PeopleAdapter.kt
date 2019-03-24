package com.github.mrbean355.navigation.pay.adapter

import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class PeopleAdapter : RecyclerView.Adapter<PeopleAdapter.ViewHolder>() {
    private var items: List<String> = emptyList()
    private var onItemClicked: (person: String) -> Unit = {}

    fun setItems(items: List<String>) {
        this.items = items.sortedWith(Comparator { o1, o2 ->
            o1.compareTo(o2)
        })
    }

    fun setOnItemClickedListener(onItemClicked: (person: String) -> Unit) {
        this.onItemClicked = onItemClicked
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(View.inflate(parent.context, android.R.layout.simple_list_item_1, null))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.textView.text = items[position]
        holder.itemView.setOnClickListener {
            onItemClicked(items[holder.adapterPosition])
        }
    }

    override fun getItemCount() = items.size

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textView = itemView as TextView
    }
}