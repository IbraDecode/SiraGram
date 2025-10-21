package com.sira.gram.ui.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.sira.gram.R
import com.sira.gram.adapters.SettingsAdapter
import com.sira.gram.models.SettingItem

class SettingsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)

        val recyclerView: RecyclerView = findViewById(R.id.settings_recycler_view)
        val settings = listOf(
            SettingItem("Account", "Manage your account"),
            SettingItem("Privacy", "Privacy settings"),
            SettingItem("Notifications", "Notification preferences"),
            SettingItem("Appearance", "Theme and appearance"),
            SettingItem("Security", "Security options")
        )

        val adapter = SettingsAdapter(settings)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter
    }
}