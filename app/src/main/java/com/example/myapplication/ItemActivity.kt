package com.example.myapplication

import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.ComponentActivity

class ItemActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_item)
        val titleView = findViewById<TextView>(R.id.title)
        val imageView = findViewById<ImageView>(R.id.src)
        val descriptionView = findViewById<TextView>(R.id.description)
        val ratingView = findViewById<TextView>(R.id.rating)
        val priceView = findViewById<TextView>(R.id.price)

        intent.extras?.getString("name")?.let {
            Log.d("ItemActivity", "name: $it")
            titleView.text = it
        }
        intent.extras?.getInt("image")?.let {
            imageView.setImageResource(it)
        }
        intent.extras?.getString("description")?.let {
            descriptionView.text = it
        }
        intent.extras?.getString("rating")?.let {
            ratingView.text = "Rating : $it Stars"
        }
        intent.extras?.getString("price")?.let {
            priceView.text = "Price : $it"
        }
    }
}