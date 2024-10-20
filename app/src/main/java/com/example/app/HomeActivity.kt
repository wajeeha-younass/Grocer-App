
package com.example.app

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

//class HomeActivity : AppCompatActivity() {
//    @SuppressLint("MissingInflatedId")
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_home) // Ensure this layout file exists
//
//        // Update the ID here to match the XML layout
//        val recyclerViewProducts: RecyclerView = findViewById(R.id.productsRecyclerView)
//        recyclerViewProducts.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
//
//        val products = listOf(
//            Product("Onion", "1 kg", 240, 221, "8% OFF"),
//            Product("Tomato", "1 kg", 130, 120, "8% OFF")
//        )
//
//        val adapter = ProductAdapter(products)
//        recyclerViewProducts.adapter = adapter
//    }
//}




class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val categoryRecyclerView: RecyclerView = findViewById(R.id.categoryRecyclerView)

        // Sample data for categories
        val categories = listOf(
            Category(R.drawable.banana, "Fruits & Vegetables", "Fruits, Vegetables & Exotic Vegetables"),
            Category(R.drawable.cro, "Crockery & Household", "Broom, Waste bins, Crockery"),
            Category(R.drawable.machine, "Electronics Store", "Charging Cable, Cells, & More") ,
            Category(R.drawable.bread, "Fruits & Vegetables", "Fruits, Vegetables & Exotic Vegetables"),
        Category(R.drawable.diary, "Crockery & Household", "Broom, Waste bins, Crockery"),
        Category(R.drawable.gg, "Electronics Store", "Charging Cable, Cells, & More"),
        Category(R.drawable.banana, "Fruits & Vegetables", "Fruits, Vegetables & Exotic Vegetables"),
            Category(R.drawable.cro, "Crockery & Household", "Broom, Waste bins, Crockery")

        )

        val adapter = CategoryAdapter(categories)
        categoryRecyclerView.layoutManager = LinearLayoutManager(this)
        categoryRecyclerView.adapter = adapter
    }
}


