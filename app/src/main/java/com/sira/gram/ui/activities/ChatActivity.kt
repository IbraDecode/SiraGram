package com.sira.gram.ui.activities

import android.os.Bundle
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.sira.gram.R
import com.sira.gram.adapters.ChatAdapter
import com.sira.gram.models.Message
import com.sira.gram.network.ApiService

class ChatActivity : AppCompatActivity() {

    private lateinit var chatAdapter: ChatAdapter
    private val messages = mutableListOf<Message>()
    private lateinit var apiService: ApiService
    private val chatId = 123456 // Placeholder chat ID

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chat)

        apiService = ApiService()

        val recyclerView: RecyclerView = findViewById(R.id.chat_recycler_view)
        val messageInput: EditText = findViewById(R.id.message_input)
        val sendButton: ImageButton = findViewById(R.id.send_button)

        chatAdapter = ChatAdapter(messages)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = chatAdapter

        // Load existing messages
        loadMessages()

        sendButton.setOnClickListener {
            val text = messageInput.text.toString()
            if (text.isNotEmpty()) {
                sendMessage(text)
                messageInput.text.clear()
            }
        }
    }

    private fun loadMessages() {
        apiService.getMessages(chatId) { msgs: List<Message> ->
            messages.clear()
            messages.addAll(msgs)
            chatAdapter.notifyDataSetChanged()
        }
    }

    private fun sendMessage(text: String) {
        apiService.sendMessage(chatId, text) { success ->
            if (success) {
                messages.add(Message(text, true))
                chatAdapter.notifyItemInserted(messages.size - 1)
                findViewById<RecyclerView>(R.id.chat_recycler_view).scrollToPosition(messages.size - 1)
            } else {
                Toast.makeText(this, "Failed to send message", Toast.LENGTH_SHORT).show()
            }
        }
    }
}