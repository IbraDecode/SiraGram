package com.sira.gram.network

import okhttp3.OkHttpClient

object ApiClient {
    val client = OkHttpClient.Builder().build()
}