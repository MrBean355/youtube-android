package com.github.mrbean355.navigation.pay

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import com.github.mrbean355.navigation.R
import kotlinx.android.synthetic.main.fragment_pay_person.*

class PayPersonFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_pay_person, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // TODO: Load person from args.

        disclaimer_button.setOnClickListener {
            // TODO: Navigate to disclaimer.
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?, inflater: MenuInflater?) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater?.inflate(R.menu.next, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if (item?.itemId == R.id.action_next) {
            // TODO: Navigate to next fragment.
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}