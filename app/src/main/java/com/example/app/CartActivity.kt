package com.example.app

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class CartActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cart)

        // Back Button
        val backButton: ImageButton = findViewById(R.id.back_button)
        backButton.setOnClickListener {
            // Close the Cart Activity and go back
            finish()
        }

        // Start Shopping Button
        val startShoppingButton: Button = findViewById(R.id.startShoppingButton)
        startShoppingButton.setOnClickListener {
            // Navigate back to the shopping home page
            Toast.makeText(this, "Returning to Shopping", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
        }
    }
}
