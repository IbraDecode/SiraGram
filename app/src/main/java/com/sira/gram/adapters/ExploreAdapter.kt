package com.sira.gram.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.sira.gram.R
import com.sira.gram.models.SmartFeature

class ExploreAdapter(private val features: List<SmartFeature>) : RecyclerView.Adapter<ExploreAdapter.ExploreViewHolder>() {

    class ExploreViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val titleText: TextView = view.findViewById(R.id.feature_title)
        val descText: TextView = view.findViewById(R.id.feature_desc)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExploreViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_feature, parent, false)
        return ExploreViewHolder(view)
    }

    override fun onBindViewHolder(holder: ExploreViewHolder, position: Int) {
        val feature = features[position]
        holder.titleText.text = feature.title
        holder.descText.text = feature.description
    }

    override fun getItemCount() = features.size
}