package com.github.mrbean355.android.menuprovider

import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.WavingHand
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.core.view.MenuProvider
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle

class MenuDemoFragment : Fragment(), MenuProvider {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return ComposeView(requireContext()).apply {
            setContent {
                Column(
                    verticalArrangement = Arrangement.spacedBy(16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Image(
                        painter = rememberVectorPainter(Icons.Default.WavingHand),
                        colorFilter = ColorFilter.tint(colorResource(R.color.colorAccent)),
                        contentDescription = stringResource(R.string.demo_fragment_image_description),
                        modifier = Modifier.size(48.dp)
                    )
                    Text(
                        text = stringResource(R.string.demo_fragment_text),
                        style = MaterialTheme.typography.h6
                    )
                }
            }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Only add the MenuProvider while the fragment's view lifecycle is 'resumed':
        activity?.addMenuProvider(this, viewLifecycleOwner, Lifecycle.State.RESUMED)
    }

    override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
        // Inflate the menu's XML file as usual:
        menuInflater.inflate(R.menu.menu_fragment_demo, menu)
    }

    override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
        // Handle the menu item click as usual:
        if (menuItem.itemId == R.id.demo_fragment_menu_item) {
            Toast.makeText(requireContext(), R.string.msg_fragment_menu_clicked, Toast.LENGTH_SHORT).show()
            return true
        }
        return false
    }
}
