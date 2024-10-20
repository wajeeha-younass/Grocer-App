package com.example.app
//
//import android.os.Bundle
//import android.view.MenuItem
//import android.widget.ImageButton
//import androidx.appcompat.app.AppCompatActivity
//import androidx.core.view.GravityCompat
//import androidx.drawerlayout.widget.DrawerLayout
//import androidx.recyclerview.widget.LinearLayoutManager
//import androidx.recyclerview.widget.RecyclerView
//import com.google.android.material.navigation.NavigationView
//
//class HomeActivity : AppCompatActivity() {
//    private lateinit var drawerLayout: DrawerLayout
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_home)
//
//        drawerLayout = findViewById(R.id.drawer_layout)
//
//        val menuIcon: ImageButton = findViewById(R.id.menu_icon)
//        menuIcon.setOnClickListener {
//            drawerLayout.openDrawer(GravityCompat.START)
//        }
//
//        // Setup RecyclerView
//        val categoryRecyclerView: RecyclerView = findViewById(R.id.categoryRecyclerView)
//        val categories = listOf(
//            Category(R.drawable.banana, "Fruits & Vegetables", "Fruits, Vegetables & Exotic Vegetables"),
//            Category(R.drawable.cro, "Crockery & Household", "Broom, Waste bins, Crockery"),
//            Category(R.drawable.machine, "Electronics Store", "Charging Cable, Cells, & More"),
//            Category(R.drawable.bread, "Fruits & Vegetables", "Fruits, Vegetables & Exotic Vegetables"),
//            Category(R.drawable.diary, "Crockery & Household", "Broom, Waste bins, Crockery"),
//            Category(R.drawable.gg, "Electronics Store", "Charging Cable, Cells, & More"),
//            Category(R.drawable.banana, "Fruits & Vegetables", "Fruits, Vegetables & Exotic Vegetables"),
//            Category(R.drawable.cro, "Crockery & Household", "Broom, Waste bins, Crockery")
//        )
//
//        val adapter = CategoryAdapter(categories)
//        categoryRecyclerView.layoutManager = LinearLayoutManager(this)
//        categoryRecyclerView.adapter = adapter
//    }
//
//    override fun onOptionsItemSelected(item: MenuItem): Boolean {
//        return when (item.itemId) {
//            android.R.id.home -> {
//                drawerLayout.openDrawer(GravityCompat.START)
//                true
//            }
//            else -> super.onOptionsItemSelected(item)
//        }
//    }
//
//    override fun onBackPressed() {
//        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
//            drawerLayout.closeDrawer(GravityCompat.START)
//        } else {
//            super.onBackPressed()
//        }
//    }
//}
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

        // Setup RecyclerView
        val categoryRecyclerView: RecyclerView = findViewById(R.id.categoryRecyclerView)
        val categories = listOf(
            Category(R.drawable.banana, "Fruits & Vegetables", "Fruits, Vegetables & Exotic Vegetables"),
            Category(R.drawable.cro, "Crockery & Household", "Broom, Waste bins, Crockery"),
            Category(R.drawable.machine, "Electronics Store", "Charging Cable, Cells, & More"),
            Category(R.drawable.bread, "Fruits & Vegetables", "Fruits, Vegetables & Exotic Vegetables"),
            Category(R.drawable.diary, "Crockery & Household", "Broom, Waste bins, Crockery"),
            Category(R.drawable.gg, "Electronics Store", "Charging Cable, Cells, & More"),
            Category(R.drawable.banana, "Fruits & Vegetables", "Fruits, Vegetables & Exotic Vegetables"),
            Category(R.drawable.cro, "Crockery & Household", "Broom, Waste bins, Crockery")

        )

        val adapter = CategoryAdapter(categories)
        categoryRecyclerView.layoutManager = LinearLayoutManager(this)
        categoryRecyclerView.adapter = adapter

        // Handle navigation item clicks
        navigationView.setNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.nav_profile -> {
                    // Start ProfileActivity when profile is clicked
                    val intent = Intent(this, ProfileActivity::class.java)
                    startActivity(intent)
                    drawerLayout.closeDrawer(GravityCompat.START) // Close the drawer after item is clicked
                    true
                }
                // Add other menu items if needed
                else -> false
            }
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

