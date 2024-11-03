package com.example.app

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize // This makes it Parcelable
data class CartItem(
    val name: String,
    val quantity: Int,
    val price: Int,
    val originalPrice: Int,
    val discount: Int,
    val imageResId: Int // Resource ID for the image
) : Parcelable
