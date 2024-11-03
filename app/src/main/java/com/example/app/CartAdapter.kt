package com.example.app

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CartAdapter(private val cartItems: List<CartItem>) : RecyclerView.Adapter<CartAdapter.CartViewHolder>() {

    class CartViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val itemName: TextView = view.findViewById(R.id.item_name) // Assuming you have a TextView with this ID in your layout
        val itemQuantity: TextView = view.findViewById(R.id.item_quantity) // Assuming you have this ID
        val itemPrice: TextView = view.findViewById(R.id.item_price) // Assuming you have this ID
        val itemImage: ImageView = view.findViewById(R.id.item_image) // Assuming you have this ID
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.cart_item, parent, false) // Replace with your item layout
        return CartViewHolder(view)
    }

    override fun onBindViewHolder(holder: CartViewHolder, position: Int) {
        val cartItem = cartItems[position]
        holder.itemName.text = cartItem.name
        holder.itemQuantity.text = "Quantity: ${cartItem.quantity}"
        holder.itemPrice.text = "Price: Rs ${cartItem.price}"
        holder.itemImage.setImageResource(cartItem.imageResId) // Set image resource
    }

    override fun getItemCount(): Int = cartItems.size
}
