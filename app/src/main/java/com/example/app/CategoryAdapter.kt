// CategoryAdapter.kt

package com.example.app

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CategoryAdapter(private val categories: List<Category>, private val context: Context) :
    RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_category, parent, false)
        return CategoryViewHolder(view)
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        val category = categories[position]

        // Bind category data
        holder.categoryTitle.text = category.title
        holder.categoryDescription.text = category.description
        holder.categoryImage.setImageResource(category.imageResId)

        // Handle expand/collapse logic
        holder.expandableLayout.visibility = if (category.isExpanded) View.VISIBLE else View.GONE
        holder.expandButton.setImageResource(
            if (category.isExpanded) R.drawable.arrowup else R.drawable.arrowdown
        )

        // Clear previous product views
        holder.productList.removeAllViews()

        // Add product views dynamically as buttons if expanded
        if (category.isExpanded) {
            for (product in category.products) {
                val productButton = LayoutInflater.from(holder.itemView.context)
                    .inflate(R.layout.product_button_item, holder.productList, false) as TextView
                productButton.text = product.name
                productButton.setOnClickListener {
                    // Intent to open ProductDetailActivity
                    val intent = Intent(context, ProductDetailActivity::class.java)

                    intent.putExtra("productName", product.name)
                    intent.putExtra("productPrice", product.price)
                    intent.putExtra("productDiscount", product.discount)
                    intent.putExtra("productImageResId", product.imageResId)

                    context.startActivity(intent)
                }

                holder.productList.addView(productButton)
            }
        }

        // Toggle expansion on click
        holder.expandButton.setOnClickListener {
            category.isExpanded = !category.isExpanded
            notifyItemChanged(position) // Notify the adapter to refresh the item
        }
    }

    override fun getItemCount(): Int {
        return categories.size
    }

    class CategoryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val categoryImage: ImageView = itemView.findViewById(R.id.categoryImage)
        val categoryTitle: TextView = itemView.findViewById(R.id.categoryTitle)
        val categoryDescription: TextView = itemView.findViewById(R.id.categoryDescription)
        val expandButton: ImageButton = itemView.findViewById(R.id.expandButton)
        val expandableLayout: LinearLayout = itemView.findViewById(R.id.expandableLayout)
        val productList: LinearLayout = itemView.findViewById(R.id.productList)
    }
}
