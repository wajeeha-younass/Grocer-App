package com.example.app

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class PhoneActivity : AppCompatActivity() {

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_phone) // Ensure this layout exists

        val phoneNumberInput = findViewById<EditText>(R.id.phoneNumberInput)
        val loginButton = findViewById<Button>(R.id.loginButton)

        // Set up a TextWatcher to listen for changes in the EditText
        phoneNumberInput.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                // Change button color when user starts typing
                if (!s.isNullOrEmpty()) {
                    loginButton.setBackgroundColor(0xFFFFA500.toInt()) // Orange color
                } else {
                    loginButton.setBackgroundColor(0xFFD8A6) // Default color (you can set the original color here)
                }
            }

            override fun afterTextChanged(s: Editable?) {}
        })

        loginButton.setOnClickListener {
            val phoneNumber = phoneNumberInput.text.toString()
            if (phoneNumber.isNotEmpty()) {
                // Navigate to ProfileSetupActivity
                val intent = Intent(this, ProfileSetupActivity::class.java)
                startActivity(intent)
            } else {
                Toast.makeText(this, "Please enter your phone number", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
