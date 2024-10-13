package com.example.app

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val languageToggle: TextView = findViewById(R.id.languageToggle)
        val loginButton: Button = findViewById(R.id.loginButton)
        val locationButton: Button = findViewById(R.id.locationButton)
        val manualLocation: TextView = findViewById(R.id.manualLocation)

        languageToggle.setOnClickListener {
            // Switch language between English and Urdu
        }

        loginButton.setOnClickListener {
            // Navigate to LoginActivity
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }

        locationButton.setOnClickListener {
            // Use current location logic
        }

        manualLocation.setOnClickListener {
            // Open manual location selection
        }
    }
}
