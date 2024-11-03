package com.example.app


data class Product(val imageResId: Int, val price: Double,
                   val discount: Double, val name: String)

data class Category(
    val imageResId: Int,
    val title: String,
    val description: String,
    var isExpanded: Boolean = false,
    val products: List<Product> = listOf() // Ensure this is correctly populated
)
