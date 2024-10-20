package com.example.app
//
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import android.widget.ImageView
//import android.widget.TextView
//import androidx.recyclerview.widget.RecyclerView
//
//class CategoryAdapter(private val categories: List<Category>) : RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder>() {
//
//    class CategoryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
//        val image: ImageView = itemView.findViewById(R.id.categoryImage)
//        val title: TextView = itemView.findViewById(R.id.categoryTitle)
//        val description: TextView = itemView.findViewById(R.id.categoryDescription)
//    }
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
//        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_category, parent, false)
//        return CategoryViewHolder(view)
//    }
//
//    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
//        val category = categories[position]
//        holder.image.setImageResource(category.imageResId)
//        holder.title.text = category.title
//        holder.description.text = category.description
//    }
//
//    override fun getItemCount(): Int = categories.size
//}

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CategoryAdapter(private val categories: List<Category>) :
    RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_category, parent, false)
        return CategoryViewHolder(view)
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        val category = categories[position]

        // Bind the category data
        holder.categoryTitle.text = category.title
        holder.categoryDescription.text = category.description
        holder.categoryImage.setImageResource(category.imageResId)

        // Handle expand/collapse logic
        holder.expandableLayout.visibility = if (category.isExpanded) View.VISIBLE else View.GONE
        holder.expandButton.setImageResource(
            if (category.isExpanded) R.drawable.arrowup else R.drawable.arrowdown)

        // Toggle expansion on click
        holder.expandButton.setOnClickListener {
            category.isExpanded = !category.isExpanded
            notifyItemChanged(position)
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
    }
}

