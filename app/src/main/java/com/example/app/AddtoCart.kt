package com.example.app

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.app.databinding.ActivityAddtocartBinding // Ensure you have this import

class AddtoCart : AppCompatActivity() {

    private lateinit var binding: ActivityAddtocartBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Set up View Binding
        binding = ActivityAddtocartBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Set up Toolbar
        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true) // Enable the back button
        supportActionBar?.setHomeButtonEnabled(true) // Enable the home button

        // Handling back button click
        binding.toolbar.setNavigationOnClickListener {
            onBackPressed() // This will handle the back navigation
        }

        // Setting up RecyclerView for cart items
        binding.cartItemsRecyclerView.layoutManager = LinearLayoutManager(this)
        binding.cartItemsRecyclerView.adapter = CartAdapter(getCartItems())

        // Set up progress indicator for billing steps
        binding.billingProgressIndicator.progress = 1 // Set progress here

        // Set up promo code toggle
        binding.promoCodeSection.setOnClickListener {
            binding.promoCodeContent.visibility =
                if (binding.promoCodeContent.visibility == View.VISIBLE) View.GONE else View.VISIBLE
        }

        // Checkout button click
        binding.checkoutButton.setOnClickListener {
            // Intent to start CheckoutActivity
            val intent = Intent(this, CheckoutActivity::class.java)
            startActivity(intent)
        }
    }

    private fun getCartItems(): List<CartItem> {
        // Sample data
        return listOf(
            CartItem(
                name = "Fresh Eggs | Pack of 6 eggs",
                quantity = 1,
                price = 171,
                originalPrice = 180,
                discount = 5,
                imageResId = R.drawable.milk // Ensure this drawable exists
            )
            // Add more items if needed
        )
    }
}
