package com.github.mrbean355.android

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.annotation.StringRes
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Divider
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ListItem
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ChevronRight
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import com.github.mrbean355.android.activitycontracts.ContractsDemoActivity
import com.github.mrbean355.android.coroutines.CoroutinesActivity
import com.github.mrbean355.android.dagger2.ui.ViewHeroesActivity
import com.github.mrbean355.android.databinding.CreatePokemonActivity
import com.github.mrbean355.android.navigation.NavigationLandingActivity
import com.github.mrbean355.android.room.ViewPokemonActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                DemoScreen()
            }
        }
    }
}

private val DemoItems = listOf(
    R.string.action_activity_contracts to ContractsDemoActivity::class.java,
    R.string.action_coroutines to CoroutinesActivity::class.java,
    R.string.action_dagger_2 to ViewHeroesActivity::class.java,
    R.string.action_data_binding to CreatePokemonActivity::class.java,
    R.string.action_enhanced_adapter to com.github.mrbean355.android.yt.enhancedadapter.ViewPokemonActivity::class.java,
    R.string.action_navigation to NavigationLandingActivity::class.java,
    R.string.action_room to ViewPokemonActivity::class.java,
    R.string.action_view_model to com.github.mrbean355.android.viewmodel.ViewPokemonActivity::class.java
)

@Composable
private fun DemoScreen() {
    LazyColumn {
        items(DemoItems) {
            DemoItem(it.first, it.second)
        }
    }
}

@Composable
@OptIn(ExperimentalMaterialApi::class)
private fun DemoItem(
    @StringRes labelRes: Int,
    targetActivity: Class<out Activity>
) {
    val context = LocalContext.current
    ListItem(
        trailing = { ChevronIcon() },
        modifier = Modifier.clickable { context.startActivity(Intent(context, targetActivity)) }
    ) {
        Text(text = stringResource(labelRes))
    }
    Divider()
}

@Composable
private fun ChevronIcon() {
    Image(
        painter = rememberVectorPainter(Icons.Default.ChevronRight),
        contentDescription = stringResource(R.string.chevron_content_desc)
    )
}