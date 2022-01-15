package com.github.mrbean355.android.navigation.basic.pay

import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.github.mrbean355.android.navigation.R
import kotlinx.android.synthetic.main.fragment_payment_complete.*

/**
 * See the project README for the equivalent Java code.
 */
class PaymentCompleteFragment : Fragment() {
    private val args: PaymentCompleteFragmentArgs by navArgs()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_payment_complete, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        person_name.text = args.personName
        from_account_number.text = args.accountNumber
        amount.text = args.amount
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.done, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.action_done) {
            findNavController().navigate(R.id.action_paymentCompleteFragment_to_mainFragment)
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}