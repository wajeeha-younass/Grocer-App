package com.example.app

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        // Back button functionality
        val backButton = findViewById<ImageView>(R.id.backButton)
        backButton.setOnClickListener {
            finish()  // Closes the current activity and goes back to the previous one
        }

        // Continue button to navigate to the next screen
        val continueButton = findViewById<Button>(R.id.continueButton)
        continueButton.setOnClickListener {
            // Intent to navigate to the next activity, replace `PhoneActivity::class.java` with your target activity class
            val intent = Intent(this, PhoneActivity::class.java)
            startActivity(intent)
        }
    }
}
