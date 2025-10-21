package com.sira.gram.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.sira.gram.R
import com.sira.gram.adapters.CallAdapter
import com.sira.gram.models.Call

class CallFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_call, container, false)

        val recyclerView: RecyclerView = view.findViewById(R.id.call_recycler_view)
        val calls = listOf(
            Call("User1", "Incoming"),
            Call("User2", "Outgoing")
        )

        val adapter = CallAdapter(calls)
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = adapter

        return view
    }
}