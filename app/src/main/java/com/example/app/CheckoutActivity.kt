package com.example.app

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.RadioButton
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class CheckoutActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_checkout)

        val ivBack: ImageView = findViewById(R.id.ivBack)
        val btnPlaceOrder: Button = findViewById(R.id.btnPlaceOrder)
        val tvDeliveryDay: TextView = findViewById(R.id.tvDeliveryDay)
        val tvDeliveryWindow: TextView = findViewById(R.id.tvDeliveryWindow)
        val radioCashOnDelivery: RadioButton = findViewById(R.id.radioCashOnDelivery)

        ivBack.setOnClickListener {
            finish() // Go back to previous screen
        }

        btnPlaceOrder.setOnClickListener {
            if (radioCashOnDelivery.isChecked) {
                // Add logic to place the order
                Toast.makeText(this, "Order Placed Successfully!", Toast.LENGTH_LONG).show()
            } else {
                Toast.makeText(this, "Please select a payment method", Toast.LENGTH_SHORT).show()
            }
        }

        // Example for setting dynamic text for Delivery Day and Window
        tvDeliveryDay.text = "Tomorrow"
        tvDeliveryWindow.text = "09:00 - 12:00 PM"
    }
}
