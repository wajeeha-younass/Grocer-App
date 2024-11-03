package com.example.app

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ProductDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_detail)

        // Get product details from the intent
        val productName = intent.getStringExtra("productName") ?: "Unknown Product"
        val productPrice = intent.getDoubleExtra("productPrice", 0.0)
        val productDiscount = intent.getDoubleExtra("productDiscount", 0.0)
        val productImageResId = intent.getIntExtra("productImageResId", R.drawable.bread)

        // Find views by ID
        val productImageView: ImageView = findViewById(R.id.productImageView)
        val productNameTextView: TextView = findViewById(R.id.productNameTextView)
        val productPriceTextView: TextView = findViewById(R.id.productPriceTextView)
        val productDiscountTextView: TextView = findViewById(R.id.productDiscountTextView)
        val addToCartButton: Button = findViewById(R.id.addToCartButton)

        // Set product details to views
        productImageView.setImageResource(productImageResId)
        productNameTextView.text = productName
        productPriceTextView.text = "Price: $$productPrice"
        productDiscountTextView.text = "Discount: ${productDiscount}%"

        // Add to Cart button functionality
        addToCartButton.setOnClickListener {
            // Create an Intent to start the AddtoCart activity
            val intent = Intent(this, AddtoCart::class.java)
            startActivity(intent)
        }

    }
}
