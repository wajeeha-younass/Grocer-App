import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.app.R

class ExpandProduct : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var productAdapter: ProductAdapter
    private lateinit var productList: List<Product>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.expand_product)

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        // Sample data
        productList = listOf(
            Product("Product 1", "6 piece", "30% OFF", "Rs 171", "Rs 180", R.drawable.machine),
            Product("Product 2", "10 piece", "20% OFF", "Rs 200", "Rs 250", R.drawable.machine),
            // Add more products as needed
        )

        productAdapter = ProductAdapter(productList)
        recyclerView.adapter = productAdapter
    }
}
