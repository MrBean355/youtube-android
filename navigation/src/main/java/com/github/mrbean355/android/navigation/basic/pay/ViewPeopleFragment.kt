package com.github.mrbean355.android.navigation.basic.pay

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.github.mrbean355.android.navigation.R
import com.github.mrbean355.android.navigation.basic.pay.adapter.PeopleAdapter

/**
 * See the project README for the equivalent Java code.
 */
class ViewPeopleFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_view_people, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter = PeopleAdapter()
        adapter.setItems(PEOPLE)
        adapter.setOnItemClickedListener { name ->
            val directions = ViewPeopleFragmentDirections.actionViewPeopleFragmentToPayPersonFragment(name)
            findNavController().navigate(directions)
        }
        view.findViewById<RecyclerView>(R.id.people_recycler_view).adapter = adapter
    }

    private companion object {
        // Names generated by www.name-generator.org.uk
        private val PEOPLE = listOf(
            "Kaelan Puckett",
            "Salim Bevan",
            "Alisha Lambert",
            "Leland Johnston",
            "Mared Logan",
            "Kit Summers",
            "Kyran Pearson",
            "Aaliya O'Sullivan",
            "Saffa Davies",
            "Muhammad Villalobos",
            "Angelica Crouch",
            "Collette Boyd",
            "Issac Oakley",
            "Alaina Solis",
            "Marianne Brookes",
            "Jon Rowe",
            "Aryaan Vasquez",
            "Virginia Devlin",
            "Minnie Wright",
            "Chandni Hale",
            "Jacque Snider",
            "Aniqa Potts",
            "Esmee Spence",
            "Kealan O'Moore",
            "Summer Lopez"
        )
    }
}