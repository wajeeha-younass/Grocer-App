package com.example.app

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView // Import ImageView
import androidx.recyclerview.widget.RecyclerView

class BannerAdapter(private val banners: List<Int>) : RecyclerView.Adapter<BannerAdapter.BannerViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BannerViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_banner, parent, false)
        return BannerViewHolder(view)
    }

    override fun onBindViewHolder(holder: BannerViewHolder, position: Int) {
        holder.bind(banners[position])
    }

    override fun getItemCount(): Int = banners.size

    inner class BannerViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bind(banner: Int) {
            // Ensure the ID matches the one in item_banner.xml
            itemView.findViewById<ImageView>(R.id.bannerImage).setImageResource(banner)
        }
    }
}
