package com.example.app

import android.graphics.Paint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ProductAdapter(private val products: List<Product>) : RecyclerView.Adapter<ProductAdapter.ProductViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        // Inflate the layout for each product item
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_product, parent, false)
        return ProductViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        // Get the product at the current position
        val product = products[position]

        // Bind the product details to the view
        holder.productName.text = product.name
        holder.productQuantity.text = product.quantity
        holder.productOriginalPrice.text = "Rs ${product.originalPrice}"
        holder.productDiscountedPrice.text = "Rs ${product.discountedPrice}"
        holder.productDiscount.text = product.discount

        // Apply strikethrough to the original price
        holder.productOriginalPrice.paintFlags = holder.productOriginalPrice.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG
    }

    override fun getItemCount(): Int = products.size

    // ViewHolder class to represent each product item view
    class ProductViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val productName: TextView = view.findViewById(R.id.productName)
        val productQuantity: TextView = view.findViewById(R.id.productQuantity)
        val productOriginalPrice: TextView = view.findViewById(R.id.productOriginalPrice)
        val productDiscountedPrice: TextView = view.findViewById(R.id.productDiscountedPrice)
        val productDiscount: TextView = view.findViewById(R.id.productDiscount)
    }
}
