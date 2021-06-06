package com.github.mrbean355.android

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.github.mrbean355.android.activitycontracts.ContractsDemoActivity
import com.github.mrbean355.android.coroutines.CoroutinesActivity
import com.github.mrbean355.android.dagger2.ui.ViewHeroesActivity
import com.github.mrbean355.android.databinding.CreatePokemonActivity
import com.github.mrbean355.android.navigation.NavigationLandingActivity
import com.github.mrbean355.android.room.ViewPokemonActivity

class DemoChoicesAdapter(
    private val itemClicked: (Class<out AppCompatActivity>) -> Unit
) : RecyclerView.Adapter<DemoChoicesAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ViewHolder(layoutInflater.inflate(R.layout.item_demo_choice, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val context = holder.itemView.context
        holder.textView.text = context.getString(CHOICES[position].first)
        holder.itemView.setOnClickListener {
            itemClicked(CHOICES[holder.bindingAdapterPosition].second)
        }
    }

    override fun getItemCount() = CHOICES.size

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textView: TextView = itemView.findViewById(android.R.id.text1)
    }

    private companion object {
        private val CHOICES = listOf(
            R.string.action_activity_contracts to ContractsDemoActivity::class.java,
            R.string.action_coroutines to CoroutinesActivity::class.java,
            R.string.action_dagger_2 to ViewHeroesActivity::class.java,
            R.string.action_data_binding to CreatePokemonActivity::class.java,
            R.string.action_enhanced_adapter to com.github.mrbean355.android.yt.enhancedadapter.ViewPokemonActivity::class.java,
            R.string.action_navigation to NavigationLandingActivity::class.java,
            R.string.action_room to ViewPokemonActivity::class.java,
            R.string.action_view_model to com.github.mrbean355.android.viewmodel.ViewPokemonActivity::class.java
        )
    }
}