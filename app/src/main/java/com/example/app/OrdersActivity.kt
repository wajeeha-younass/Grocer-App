package com.example.app

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class OrdersActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_orders)

        // Find the Start Shopping button
        val startShoppingButton: Button = findViewById(R.id.start_shopping_button)

        // Set click listener for Start Shopping button
        startShoppingButton.setOnClickListener {
            // Navigate to the home or shopping activity
            val intent = Intent(this, HomeActivity::class.java) // Replace MainActivity with your shopping activity
            startActivity(intent)
        }
    }
}
