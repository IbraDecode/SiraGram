package com.sira.gram.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.sira.gram.R
import com.sira.gram.models.Chat

class ChatListAdapter(private val chats: List<Chat>) : RecyclerView.Adapter<ChatListAdapter.ChatViewHolder>() {

    class ChatViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val nameText: TextView = view.findViewById(R.id.chat_name)
        val lastMessageText: TextView = view.findViewById(R.id.chat_last_message)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChatViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_chat, parent, false)
        return ChatViewHolder(view)
    }

    override fun onBindViewHolder(holder: ChatViewHolder, position: Int) {
        val chat = chats[position]
        holder.nameText.text = chat.name
        holder.lastMessageText.text = chat.lastMessage
    }

    override fun getItemCount() = chats.size
}