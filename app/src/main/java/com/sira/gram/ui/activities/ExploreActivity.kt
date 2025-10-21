package com.sira.gram.ui.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.sira.gram.R
import com.sira.gram.adapters.ExploreAdapter
import com.sira.gram.models.SmartFeature

class ExploreActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_explore)

        val recyclerView: RecyclerView = findViewById(R.id.explore_recycler_view)
        val features = listOf(
            SmartFeature("Smart Assistant", "Help with responses"),
            SmartFeature("Smart Compose", "Auto suggestions"),
            SmartFeature("Smart Summary", "Summarize chats"),
            SmartFeature("Smart Translate", "Translate messages"),
            SmartFeature("Voice Understanding", "Voice to text"),
            SmartFeature("Image Insight", "Analyze images"),
            SmartFeature("Smart Search", "Quick search")
        )

        val adapter = ExploreAdapter(features)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter
    }
}