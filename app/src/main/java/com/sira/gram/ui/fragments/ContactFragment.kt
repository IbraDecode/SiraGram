package com.sira.gram.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.sira.gram.R
import com.sira.gram.adapters.ContactAdapter
import com.sira.gram.models.Contact

class ContactFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_contact, container, false)

        val recyclerView: RecyclerView = view.findViewById(R.id.contact_recycler_view)
        val contacts = listOf(
            Contact("User1"),
            Contact("User2")
        )

        val adapter = ContactAdapter(contacts)
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = adapter

        return view
    }
}