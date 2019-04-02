package com.github.mrbean355.navigation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_main.*

/**
 * See the project README for the equivalent Java code.
 */
class MainFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view_balances_button.setOnClickListener {
            findNavController().navigate(R.id.action_mainFragment_to_viewBalancesFragment)
        }
        pay_someone_button.setOnClickListener {
            findNavController().navigate(R.id.action_mainFragment_to_viewPeopleFragment)
        }
    }
}