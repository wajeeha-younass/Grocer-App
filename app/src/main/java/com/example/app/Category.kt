package com.example.app

data class Category(
    val imageResId: Int,
    val title: String,
    val description: String,
    var isExpanded: Boolean = false  // Track expansion state
)
