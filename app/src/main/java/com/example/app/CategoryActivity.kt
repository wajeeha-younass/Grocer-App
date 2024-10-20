package com.example.app

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide

class CategoryActivity : AppCompatActivity() {

    private lateinit var categoryLayout: LinearLayout
    private lateinit var expandButton: Button
    private lateinit var categoryImage: ImageView
    private var isExpanded = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_category)

        // Initialize views
        categoryLayout = findViewById(R.id.categoryLayout)
        expandButton = findViewById(R.id.expandButton)
        categoryImage = findViewById(R.id.categoryImage)

        // Load the image using Glide (replace with your image URL or resource)
        Glide.with(this)
            .load(R.drawable.banana) // Placeholder image to replace with actual image
            .into(categoryImage)

        // Set button click listener
        expandButton.setOnClickListener {
            toggleCategoryExpansion()
        }
    }

    private fun toggleCategoryExpansion() {
        if (isExpanded) {
            // Collapse the category layout
            categoryLayout.visibility = View.GONE
            expandButton.text = "Expand Category"
            expandButton.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.arrow, 0)
        } else {
            // Expand the category layout
            categoryLayout.visibility = View.VISIBLE
            expandButton.text = "Collapse Category"
            expandButton.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.arrow, 0)
        }
        isExpanded = !isExpanded
    }
}
