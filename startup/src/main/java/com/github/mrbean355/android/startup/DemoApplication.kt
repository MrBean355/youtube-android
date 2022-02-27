package com.github.mrbean355.android.startup

import android.app.Application
import androidx.core.app.NotificationChannelCompat
import androidx.core.app.NotificationManagerCompat

// This is not referenced from the manifest; it exists for demo purposes only.
class DemoApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        SimpleLogger.initialise("TEST")

        NotificationManagerCompat.from(this)
            .createNotificationChannel(
                NotificationChannelCompat.Builder("123", NotificationManagerCompat.IMPORTANCE_DEFAULT)
                    .setName(getString(R.string.notification_channel_name))
                    .build()
            )

        SimpleLogger.log("Notification channel created")
    }
}