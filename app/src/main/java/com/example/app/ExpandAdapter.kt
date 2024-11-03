import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.app.R

class ExpandAdapter(private val context: Context, private val productList: List<Product>) :
    RecyclerView.Adapter<ExpandAdapter.ProductViewHolder>() {

    inner class ProductViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val productImageView: ImageView = itemView.findViewById(R.id.productImageView)
        val productNameTextView: TextView = itemView.findViewById(R.id.productNameTextView)
        val quantityTextView: TextView = itemView.findViewById(R.id.quantityTextView)
        val discountBadge: TextView = itemView.findViewById(R.id.discountBadge)
        val discountedPriceTextView: TextView = itemView.findViewById(R.id.discountedPriceTextView)
        val incrementButton: Button = itemView.findViewById(R.id.incrementButton)
        val decrementButton: Button = itemView.findViewById(R.id.decrementButton)
        val addToCartButton: Button = itemView.findViewById(R.id.addToCartButton)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.detail_product_item, parent, false)
        return ProductViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val product = productList[position]
        holder.productNameTextView.text = product.name
        holder.quantityTextView.text = product.quantity
        holder.discountBadge.text = product.discount
        holder.discountedPriceTextView.text = product.discountedPrice
        holder.productImageView.setImageResource(product.imageResource)

        // Increment and decrement logic
        holder.incrementButton.setOnClickListener {
            // Implement increment logic here
        }

        holder.decrementButton.setOnClickListener {
            // Implement decrement logic here
        }

        holder.addToCartButton.setOnClickListener {
            // Implement add to cart logic here
        }
    }

    override fun getItemCount() = productList.size
}
