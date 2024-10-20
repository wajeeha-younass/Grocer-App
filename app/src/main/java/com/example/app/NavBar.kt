package com.example.app
import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class NavBar : AppCompatActivity() {

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.navbar) // Update with your actual layout file

        // Find buttons by their IDs
        val categoriesButton: Button = findViewById(R.id.nav_categories)
        val cartButton: Button = findViewById(R.id.nav_cart)
        val profileButton: Button = findViewById(R.id.nav_profile) // Only declare it once
        val ordersButton: Button = findViewById(R.id.nav_orders)
        val walletButton: Button = findViewById(R.id.nav_wallet)
        val promoAlertsButton: Button = findViewById(R.id.nav_promo_alerts)
        val savedLocationsButton: Button = findViewById(R.id.nav_saved_locations)
        val shareButton: Button = findViewById(R.id.nav_share)
        val faqsButton: Button = findViewById(R.id.nav_faqs)
        val helpCenterButton: Button = findViewById(R.id.nav_help_center)
        val wishListButton: Button = findViewById(R.id.nav_wish_list)
        val signOutButton: Button = findViewById(R.id.nav_sign_out)

        // Set click listeners
        categoriesButton.setOnClickListener {
            Toast.makeText(this, "Categories clicked", Toast.LENGTH_SHORT).show()
        }

        cartButton.setOnClickListener {
            Toast.makeText(this, "Cart clicked", Toast.LENGTH_SHORT).show()
        }

        // Set click listener to navigate to ProfileActivity
        profileButton.setOnClickListener {
            Log.d("NavBar", "Profile button clicked") // Add this to verify the click
            val intent = Intent(this, ProfileActivity::class.java)
            startActivity(intent)
        }


        ordersButton.setOnClickListener {
            Toast.makeText(this, "Orders clicked", Toast.LENGTH_SHORT).show()
        }

        walletButton.setOnClickListener {
            Toast.makeText(this, "Wallet clicked", Toast.LENGTH_SHORT).show()
        }

        promoAlertsButton.setOnClickListener {
            Toast.makeText(this, "Promo Alerts clicked", Toast.LENGTH_SHORT).show()
        }

        savedLocationsButton.setOnClickListener {
            Toast.makeText(this, "Saved Locations clicked", Toast.LENGTH_SHORT).show()
        }

        shareButton.setOnClickListener {
            Toast.makeText(this, "Share clicked", Toast.LENGTH_SHORT).show()
        }

        faqsButton.setOnClickListener {
            Toast.makeText(this, "FAQs clicked", Toast.LENGTH_SHORT).show()
        }

        helpCenterButton.setOnClickListener {
            Toast.makeText(this, "Help Center clicked", Toast.LENGTH_SHORT).show()
        }

        wishListButton.setOnClickListener {
            Toast.makeText(this, "Wish List clicked", Toast.LENGTH_SHORT).show()
        }

        signOutButton.setOnClickListener {
            Toast.makeText(this, "Sign out clicked", Toast.LENGTH_SHORT).show()
        }
    }
}



//    override fun onBackPressed() {
//        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
//            drawerLayout.closeDrawer(GravityCompat.START)
//        } else {
//            super.onBackPressed()
//        }
//    }

