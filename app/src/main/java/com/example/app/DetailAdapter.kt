import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.app.R

class DetailAdapter(private val productList: List<Product>) :
    RecyclerView.Adapter<DetailAdapter.ProductViewHolder>() { // Updated this line

    inner class ProductViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val productNameTextView: TextView = itemView.findViewById(R.id.productNameTextView)
        val quantityTextView: TextView = itemView.findViewById(R.id.quantityTextView)
        val discountedPriceTextView: TextView = itemView.findViewById(R.id.discountedPriceTextView)
        val productImageView: ImageView = itemView.findViewById(R.id.productImageView)
        val addToCartButton: Button = itemView.findViewById(R.id.addToCartButton)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_product, parent, false)
        return ProductViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val product = productList[position]
        holder.productNameTextView.text = product.name
        holder.quantityTextView.text = product.quantity
        holder.discountedPriceTextView.text = "Rs ${product.discountedPrice}"
        holder.productImageView.setImageResource(product.imageResource)

        // Handle add to cart button click (if needed)
        holder.addToCartButton.setOnClickListener {
            // Add product to cart logic
        }
    }

    override fun getItemCount() = productList.size
}
