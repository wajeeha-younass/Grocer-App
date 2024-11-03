package com.example.app

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ExpandableListView
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class FAQActivity : AppCompatActivity() {

    private lateinit var expandableListView: ExpandableListView
    private lateinit var faqList: List<String>
    private lateinit var answerMap: HashMap<String, String>
    private lateinit var faqAdapter: FAQExpandableListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_faq)

        expandableListView = findViewById(R.id.faq_expandable_list)

        // FAQ data
        faqList = listOf(
            "What is GrocerApp?",
            "How is GrocerApp different from other online grocery stores?",
            "How do I order via GrocerApp?",
            "What kind of products do you sell?",
            "Which cities and areas are your services available in?",
            "What is the minimum order value?",
            "How will I know if an item in my order is not available?",
            "Where is your headquarters located?"
        )

        answerMap = hashMapOf(
            "What is GrocerApp?" to "GrocerApp is an online grocery delivery service...",
            "How is GrocerApp different from other online grocery stores?" to "Here at GrocerApp, not only do we handpick each item...",
            "How do I order via GrocerApp?" to "To order via GrocerApp, simply browse our app...",
            "What kind of products do you sell?" to "We sell fresh groceries, household essentials, and more...",
            "Which cities and areas are your services available in?" to "We are available in major cities including...",
            "What is the minimum order value?" to "The minimum order value for free delivery is $10...",
            "How will I know if an item in my order is not available?" to "If an item is unavailable, we will notify you via...",
            "Where is your headquarters located?" to "Our headquarters are located in [City, Country]..."
        )

        faqAdapter = FAQExpandableListAdapter(this, faqList, answerMap)
        expandableListView.setAdapter(faqAdapter)

        // Back button click listener
        findViewById<ImageButton>(R.id.back_button).setOnClickListener {
            onBackPressed()
        }
    }
}
