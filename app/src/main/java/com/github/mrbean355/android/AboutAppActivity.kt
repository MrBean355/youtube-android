package com.github.mrbean355.android

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class AboutAppActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                Scaffold {
                    Column(
                        verticalArrangement = Arrangement.spacedBy(16.dp),
                        modifier = Modifier
                            .padding(it)
                            .padding(horizontal = 16.dp)
                            .padding(top = 16.dp)
                    ) {
                        Text(
                            text = stringResource(R.string.about_app_title),
                            style = MaterialTheme.typography.h4,
                            modifier = Modifier.align(Alignment.CenterHorizontally),
                        )
                        Text(
                            text = stringResource(R.string.about_app_author),
                            style = MaterialTheme.typography.subtitle2,
                            modifier = Modifier.align(Alignment.CenterHorizontally),
                        )
                        Text(
                            text = stringResource(R.string.about_app_subtitle),
                            fontSize = 18.sp,
                            textAlign = TextAlign.Center
                        )
                        Divider()
                        Text(text = stringResource(R.string.about_app_info_links))
                        Text(text = stringResource(R.string.about_app_info_github))
                        Spacer(modifier = Modifier.weight(1f))
                        Image(
                            painter = painterResource(R.drawable.android_logo),
                            contentDescription = stringResource(R.string.about_app_android_logo),
                            modifier = Modifier.fillMaxWidth()
                        )
                    }
                }
            }
        }
    }
}