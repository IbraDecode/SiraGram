package com.sira.gram.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.sira.gram.R
import com.sira.gram.models.Call

class CallAdapter(private val calls: List<Call>) : RecyclerView.Adapter<CallAdapter.CallViewHolder>() {

    class CallViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val nameText: TextView = view.findViewById(R.id.call_name)
        val typeText: TextView = view.findViewById(R.id.call_type)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CallViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_call, parent, false)
        return CallViewHolder(view)
    }

    override fun onBindViewHolder(holder: CallViewHolder, position: Int) {
        val call = calls[position]
        holder.nameText.text = call.name
        holder.typeText.text = call.type
    }

    override fun getItemCount() = calls.size
}