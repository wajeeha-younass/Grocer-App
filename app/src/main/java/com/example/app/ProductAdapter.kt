import android.graphics.Paint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.app.R

class ProductAdapter(private val products: List<Product>) : RecyclerView.Adapter<ProductAdapter.ProductViewHolder>() {

    private val expandedStates = BooleanArray(products.size) // Track expanded states

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_product, parent, false)
        return ProductViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val product = products[position]

        // Set product details
        holder.productName.text = product.name
        holder.productImage.setImageResource(product.imageResource) // Assume Product class has an imageResource

        // Check if the product is expanded
        if (expandedStates[position]) {
            holder.productQuantity.visibility = View.VISIBLE
            holder.productOriginalPrice.visibility = View.VISIBLE
            holder.productDiscountedPrice.visibility = View.VISIBLE
            holder.productDiscount.visibility = View.VISIBLE
        } else {
            holder.productQuantity.visibility = View.GONE
            holder.productOriginalPrice.visibility = View.GONE
            holder.productDiscountedPrice.visibility = View.GONE
            holder.productDiscount.visibility = View.GONE
        }

        // Set OnClickListener for the image to toggle expansion
        holder.productImage.setOnClickListener {
            expandedStates[position] = !expandedStates[position] // Toggle expanded state
            notifyItemChanged(position) // Notify the adapter to refresh this item
        }

        // Apply strikethrough to the original price
        holder.productOriginalPrice.paintFlags = holder.productOriginalPrice.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG
    }

    override fun getItemCount(): Int = products.size

    class ProductViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val productName: TextView = view.findViewById(R.id.productName)
        val productQuantity: TextView = view.findViewById(R.id.productQuantity)
        val productOriginalPrice: TextView = view.findViewById(R.id.productOriginalPrice)
        val productDiscountedPrice: TextView = view.findViewById(R.id.productDiscountedPrice)
        val productDiscount: TextView = view.findViewById(R.id.productDiscount);
        val productImage: ImageView = view.findViewById(R.id.productImage) // Reference to the image
    }
    }