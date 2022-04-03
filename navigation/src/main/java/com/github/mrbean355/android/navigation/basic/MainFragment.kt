package com.github.mrbean355.android.navigation.basic

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.github.mrbean355.android.navigation.R

/**
 * See the project README for the equivalent Java code.
 */
class MainFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<Button>(R.id.view_balances_button).setOnClickListener {
            findNavController().navigate(R.id.action_mainFragment_to_viewBalancesFragment)
        }
        view.findViewById<Button>(R.id.pay_someone_button).setOnClickListener {
            findNavController().navigate(R.id.action_mainFragment_to_viewPeopleFragment)
        }
    }
}