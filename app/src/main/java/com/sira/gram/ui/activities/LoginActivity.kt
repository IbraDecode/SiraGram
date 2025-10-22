package com.sira.gram.ui.activities

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.sira.gram.R
import com.sira.gram.network.ApiService

class LoginActivity : AppCompatActivity() {

    private lateinit var apiService: ApiService

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        apiService = ApiService()

        val phoneInput: EditText = findViewById(R.id.phone_input)
        val otpInput: EditText = findViewById(R.id.otp_input)
        val sendOtpButton: Button = findViewById(R.id.send_otp_button)
        val verifyOtpButton: Button = findViewById(R.id.verify_otp_button)

        sendOtpButton.setOnClickListener {
            val phone = phoneInput.text.toString()
            if (phone.isNotEmpty()) {
                // Call API to send OTP
                apiService.sendOtp(phone) { success ->
                    runOnUiThread {
                        if (success) {
                            Toast.makeText(this@LoginActivity, "OTP sent", Toast.LENGTH_SHORT).show()
                        } else {
                            Toast.makeText(this@LoginActivity, "Failed to send OTP", Toast.LENGTH_SHORT).show()
                        }
                    }
                }
            } else {
                Toast.makeText(this, "Enter phone number", Toast.LENGTH_SHORT).show()
            }
        }

        verifyOtpButton.setOnClickListener {
            val phone = phoneInput.text.toString()
            val code = otpInput.text.toString()
            if (phone.isNotEmpty() && code.isNotEmpty()) {
                // Call API to verify OTP
                apiService.verifyOtp(phone, code) { success ->
                    runOnUiThread {
                        if (success) {
                            Toast.makeText(this@LoginActivity, "Logged in", Toast.LENGTH_SHORT).show()
                            startActivity(Intent(this@LoginActivity, MainActivity::class.java))
                            finish()
                        } else {
                            Toast.makeText(this@LoginActivity, "Failed to verify OTP", Toast.LENGTH_SHORT).show()
                        }
                    }
                }
            } else {
                Toast.makeText(this, "Enter phone and OTP", Toast.LENGTH_SHORT).show()
            }
        }
    }
}