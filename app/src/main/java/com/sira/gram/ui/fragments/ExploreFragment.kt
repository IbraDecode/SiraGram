package com.sira.gram.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.sira.gram.R
import com.sira.gram.adapters.ExploreAdapter
import com.sira.gram.models.SmartFeature

class ExploreFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_explore, container, false)

        val recyclerView: RecyclerView = view.findViewById(R.id.explore_fragment_recycler_view)
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
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = adapter

        return view
    }
}