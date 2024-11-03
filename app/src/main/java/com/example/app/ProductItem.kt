package com.example.app

data class ProductItem(
    val id: String,
    val title: String,
    val price: Double,
    val image: Int, // Assume this is a drawable resource ID
    var isCart: Boolean = false // Add this field if needed for cart management
)