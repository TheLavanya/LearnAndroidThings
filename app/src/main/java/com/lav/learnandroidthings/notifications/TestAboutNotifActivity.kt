package com.lav.learnandroidthings.notifications

import android.content.Intent
import android.os.Bundle
import android.provider.Settings
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NotificationManagerCompat
import com.lav.learnandroidthings.R
import kotlinx.android.synthetic.main.activity_boot_complete.*

class TestAboutNotifActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_boot_complete)
        btn.setOnClickListener {
            if (!isNotificationEnabled()) {
                val settingsIntent: Intent = Intent(Settings.ACTION_APP_NOTIFICATION_SETTINGS)
                    .addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                    .putExtra(Settings.EXTRA_APP_PACKAGE, packageName)
                    //.putExtra(Settings.EXTRA_CHANNEL_ID, 1)
                startActivity(settingsIntent)
            }
        }
    }

    fun isNotificationEnabled(): Boolean {
        return NotificationManagerCompat.from(applicationContext)
            .areNotificationsEnabled()
    }
}