package com.example.app

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class NavBar : AppCompatActivity() {

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.navbar) // Ensure this is the correct layout for your navbar

        // Find buttons by their IDs
        val categoriesButton: Button = findViewById(R.id.nav_categories)
        val cartButton: Button = findViewById(R.id.nav_cart)
        val profileButton: Button = findViewById(R.id.nav_profile)
        val ordersButton: Button = findViewById(R.id.nav_orders) // Make sure this ID matches your layout
        val walletButton: Button = findViewById(R.id.nav_wallet)
        val promoAlertsButton: Button = findViewById(R.id.nav_promo_alerts)
        val savedLocationsButton: Button = findViewById(R.id.nav_saved_locations)
        val shareButton: Button = findViewById(R.id.nav_share)
        val faqsButton: Button = findViewById(R.id.nav_faqs)
        val helpCenterButton: Button = findViewById(R.id.nav_help_center)
        val checkoutButton: Button = findViewById(R.id.nav_check_out)
        val signOutButton: Button = findViewById(R.id.nav_sign_out)

        // Set click listeners
        categoriesButton.setOnClickListener {
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
        }

        cartButton.setOnClickListener {
            val intent = Intent(this, CartActivity::class.java)
            startActivity(intent)
        }

        profileButton.setOnClickListener {
            Log.d("NavBar", "Profile button clicked")
            val intent = Intent(this, ProfileActivity::class.java)
            startActivity(intent)
        }

        ordersButton.setOnClickListener {
            Log.d("NavBar", "Orders button clicked")
            val intent = Intent(this, OrdersActivity::class.java)
            startActivity(intent)
        }


        walletButton.setOnClickListener {
            val intent = Intent(this, WalletActivity::class.java)
            startActivity(intent)
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
            val intent = Intent(this, FAQActivity::class.java)
            startActivity(intent)
        }
        helpCenterButton.setOnClickListener {
            Toast.makeText(this, "Help Center clicked", Toast.LENGTH_SHORT).show()
        }

        checkoutButton.setOnClickListener {
            val intent = Intent(this, CheckoutActivity::class.java) // Replace with your CheckoutActivity
            startActivity(intent)
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

