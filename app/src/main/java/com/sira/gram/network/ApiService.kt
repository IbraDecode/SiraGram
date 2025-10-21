package com.sira.gram.network

import okhttp3.*
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.RequestBody.Companion.toRequestBody
import org.json.JSONObject
import java.io.IOException
import com.sira.gram.models.Message

class ApiService {

    private val client = OkHttpClient()
    private val baseUrl = "http://64.227.177.25:8000" // Backend server URL

    fun sendOtp(phone: String, callback: (Boolean) -> Unit) {
        val json = JSONObject().put("phone", phone).toString()
        val body = json.toRequestBody("application/json".toMediaType())

        val request = Request.Builder()
            .url("$baseUrl/auth/send_otp")
            .post(body)
            .build()

        client.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                callback(false)
            }

            override fun onResponse(call: Call, response: Response) {
                callback(response.isSuccessful)
            }
        })
    }

    fun getMessages(chatId: Int, callback: (List<Message>) -> Unit) {
        val request = Request.Builder()
            .url("$baseUrl/chat/messages/$chatId")
            .build()

        client.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                callback(emptyList())
            }

            override fun onResponse(call: Call, response: Response) {
                // Parse response to list of messages
                callback(emptyList()) // Placeholder
            }
        })
    }

    fun sendMessage(chatId: Int, text: String, callback: (Boolean) -> Unit) {
        val json = JSONObject().put("chat_id", chatId).put("text", text).toString()
        val body = json.toRequestBody("application/json".toMediaType())

        val request = Request.Builder()
            .url("$baseUrl/chat/send")
            .post(body)
            .build()

        client.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                callback(false)
            }

            override fun onResponse(call: Call, response: Response) {
                callback(response.isSuccessful)
            }
        })
    }

    fun smartRespond(prompt: String, callback: (String) -> Unit) {
        val json = JSONObject().put("prompt", prompt).toString()
        val body = json.toRequestBody("application/json".toMediaType())

        val request = Request.Builder()
            .url("$baseUrl/smart/respond")
            .post(body)
            .build()

        client.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                callback("Error")
            }

            override fun onResponse(call: Call, response: Response) {
                val responseBody = response.body?.string()
                callback(responseBody ?: "No response")
            }
        })
    }
}