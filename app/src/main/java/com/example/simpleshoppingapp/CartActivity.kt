package com.example.simpleshoppingapp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.ImageView
import com.google.android.material.tabs.TabLayout

class CartActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cart)

        val cartItemsLayout: LinearLayout = findViewById(R.id.cartItemsLayout)
        val cartItems = Cart.getItems()

        for (item in cartItems) {
            val itemView = layoutInflater.inflate(R.layout.cart_item, cartItemsLayout, false)

            val productNameTextView: TextView = itemView.findViewById(R.id.productNameTextView)
            val productImageView: ImageView = itemView.findViewById(R.id.productImageView)
            val productPriceTextView: TextView = itemView.findViewById(R.id.productPriceTextView)
            val deleteImageView: ImageView = itemView.findViewById(R.id.deleteImageView)

            productNameTextView.text = item.name
            productImageView.setImageResource(item.imageResId)
            productPriceTextView.text = item.price

            deleteImageView.setOnClickListener {
                Cart.removeItem(item)
                cartItemsLayout.removeView(itemView)
            }

            cartItemsLayout.addView(itemView)
        }

        findViewById<TabLayout>(R.id.bottomTab).addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                if (tab.position == 0) {
                    startActivity(Intent(this@CartActivity, MainActivity::class.java))
                }
            }

            override fun onTabUnselected(tab: TabLayout.Tab) {}
            override fun onTabReselected(tab: TabLayout.Tab) {}
        })
    }
}
