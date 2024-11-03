package com.example.app

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.navigation.NavigationView

class HomeActivity : AppCompatActivity() {
    private lateinit var drawerLayout: DrawerLayout
    private lateinit var navigationView: NavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        drawerLayout = findViewById(R.id.drawer_layout)
        navigationView = findViewById(R.id.nav_view)

        val menuIcon: ImageButton = findViewById(R.id.menu_icon)
        menuIcon.setOnClickListener {
            drawerLayout.openDrawer(GravityCompat.START)
        }

        // Setup RecyclerView with categories and products
        val categoryRecyclerView: RecyclerView = findViewById(R.id.categoryRecyclerView)
        val categories = listOf(
            Category(
                title = "Fruits & Vegetables",
                description = "Fruits, Vegetables & Exotic Vegetables",
                imageResId = R.drawable.banana,
                products = listOf(
                    Product(name = "Apple", price = 45.0, discount = 78.0, imageResId = R.drawable.apple),
                    Product(name = "Banana", price = 20.0, discount = 0.0, imageResId = R.drawable.banana)
                )
            ),

            Category(
                title = "Dairy Products",
                description = "Milk, Butter, Yogurt, Cheese",
                imageResId = R.drawable.diary,
                products = listOf(
                    Product(name = "Milk", price = 30.0, discount = 0.0, imageResId = R.drawable.milk),
                    Product(name = "Butter", price = 80.0, discount = 5.0, imageResId = R.drawable.butter)
                )
            ),
            Category(
                title = "Beverages",
                description = "Cold Drinks, Juices, Energy Drinks",
                imageResId = R.drawable.beverges,
                products = listOf(
                    Product(name = "Orange Juice", price = 50.0, discount = 0.0, imageResId = R.drawable.orange),
                    Product(name = "Soda", price = 20.0, discount = 2.0, imageResId = R.drawable.soda)
                )
            ),
            Category(
                title = "Snacks & Packaged Foods",
                description = "Chips, Cookies, Nuts, Chocolates",
                imageResId = R.drawable.snacks,
                products = listOf(
                    Product(name = "Chips", price = 15.0, discount = 3.0, imageResId = R.drawable.chips),
                    Product(name = "Chocolate", price = 25.0, discount = 0.0, imageResId = R.drawable.chocolate)
                )
            ),

            Category(
                title = "Cleaning Supplies",
                description = "Detergents, Floor Cleaners, Dishwashing",
                imageResId = R.drawable.cleaner,
                products = listOf(
                    Product(name = "Floor Cleaner", price = 70.0, discount = 5.0, imageResId = R.drawable.cleaner),
                    Product(name = "Dishwashing Liquid", price = 45.0, discount = 2.0, imageResId = R.drawable.dish)
                )
            ),
            Category(
                title = "Personal Care",
                description = "Soaps, Shampoos, Skin Care",
                imageResId = R.drawable.care,
                products = listOf(
                    Product(name = "Shampoo", price = 120.0, discount = 10.0, imageResId = R.drawable.shampoo),
                    Product(name = "Soap", price = 40.0, discount = 0.0, imageResId = R.drawable.soap)
                )
            ),
            Category(
                title = "Crockery & Household",
                description = "Broom, Waste bins, Crockery",
                imageResId = R.drawable.cro,
                products = listOf(
                    Product(name = "Plate", price = 15.0, discount = 5.0, imageResId = R.drawable.plates),
                    Product(name = "Cup", price = 10.0, discount = 2.0, imageResId = R.drawable.cup)
                )
            )
        )

        // Pass `this` as context to the adapter
        val adapter = CategoryAdapter(categories, this)

        categoryRecyclerView.layoutManager = LinearLayoutManager(this)
        categoryRecyclerView.adapter = adapter

        // Handle navigation item clicks
        navigationView.setNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.nav_profile -> {
                    val intent = Intent(this, ProfileActivity::class.java)
                    startActivity(intent)
                    drawerLayout.closeDrawer(GravityCompat.START)
                    true
                }
                R.id.nav_orders -> { // Handle the Orders button click
                    val intent = Intent(this, OrdersActivity::class.java)
                    startActivity(intent)
                    drawerLayout.closeDrawer(GravityCompat.START)
                    true
                }
                R.id.nav_wallet -> { // Handle the Wallet button click
                    val intent = Intent(this, WalletActivity::class.java)
                    startActivity(intent)
                    drawerLayout.closeDrawer(GravityCompat.START)
                    true
                }
                R.id.nav_faqs -> { // Handle the FAQs button click
                    val intent = Intent(this, FAQActivity::class.java)
                    startActivity(intent)
                    drawerLayout.closeDrawer(GravityCompat.START)
                    true
                }
                R.id.nav_check_out -> { // Handle the Checkout button click
                    val intent = Intent(this, CheckoutActivity::class.java) // Replace with your CheckoutActivity
                    startActivity(intent)
                    drawerLayout.closeDrawer(GravityCompat.START)
                    true
                }
                R.id.nav_cart -> { // Handle the Checkout button click
                    val intent = Intent(this, CartActivity::class.java) // Replace with your CheckoutActivity
                    startActivity(intent)
                    drawerLayout.closeDrawer(GravityCompat.START)
                    true
                }
                R.id.nav_categories -> { // Handle the Checkout button click
                    val intent = Intent(this, HomeActivity::class.java) // Replace with your CheckoutActivity
                    startActivity(intent)
                    drawerLayout.closeDrawer(GravityCompat.START)
                    true
                }
                else -> false
            }
        }


        // Set up the cart button click listener
        val cartIcon: ImageButton = findViewById(R.id.cart_icon)
        cartIcon.setOnClickListener {
            val intent = Intent(this, CartActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                drawerLayout.openDrawer(GravityCompat.START)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }
}
