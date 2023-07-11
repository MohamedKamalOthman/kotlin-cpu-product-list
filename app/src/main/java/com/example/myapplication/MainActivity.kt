package com.example.myapplication

import android.content.Context
import android.content.res.Resources
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

/**
 * Adapter for recycle view
 * @param data list of products
 * @param resources resources of the app
 * @param packageName name of the package
 * @see RecyclerView.Adapter
 */
class MyAdapter(
    val data: List<Product>,
    private val resources: Resources,
    private val packageName: String
) :
/**
 * View holder for recycle view
 * @param row view of the row
 * @see RecyclerView.ViewHolder
 */
    RecyclerView.Adapter<MyAdapter.MyViewHolder>() {
    class MyViewHolder(val row: View) : RecyclerView.ViewHolder(row) {
        val titleView = row.findViewById<TextView>(R.id.title)
        val imageView = row.findViewById<ImageView>(R.id.src)
        val descriptionView = row.findViewById<TextView>(R.id.description)
    }

    /**
     * Create view holder
     * @param parent parent view
     * @param viewType type of the view
     * @return view holder
     * @see RecyclerView.Adapter.onCreateViewHolder
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val layout = LayoutInflater.from(parent.context).inflate(
            R.layout.item_view,
            parent, false
        )
        return MyViewHolder(layout)
    }

    /**
     * Bind view holder
     * @param holder view holder
     * @param position position of the view
     * @see RecyclerView.Adapter.onBindViewHolder
     * @see Product
     */
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.titleView.text = data.get(position).name
        // find resource
        val res = resources.getIdentifier(
            data[position].image,
            "drawable",
            packageName
        )
        holder.imageView.setImageResource(res)
        holder.descriptionView.text = data[position].description
    }

    /**
     * Get item count
     * @return item count
     */
    override fun getItemCount(): Int = data.size

}

/**
 * Main activity
 */
class MainActivity : ComponentActivity() {

    /**
     * On create
     * @param savedInstanceState saved instance state
     * @see ComponentActivity.onCreate
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // set recycle view
        val rv: RecyclerView = findViewById(R.id.rv)

        rv.layoutManager = LinearLayoutManager(this)

        var products: List<Product>? = null

        // get data from api
        CoroutineScope(Dispatchers.IO).launch {

            // Make the network call on a background thread
            products = ProductsApi.retrofitService.getProducts()
            Log.i("API Call", "Api: $products")
        }
        
        // wait for response
        while (products == null) {
            Thread.sleep(500)
        }

        // process response...
        rv.adapter = MyAdapter(
            products!!, resources, this.getPackageName()
        )
    }


}
