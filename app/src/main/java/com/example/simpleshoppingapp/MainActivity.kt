package com.example.simpleshoppingapp


import android.content.Intent
import android.os.Bundle
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.tabs.TabLayout

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Add product click listeners
        findViewById<LinearLayout>(R.id.product1).setOnClickListener {
            addToCart("Product 1", R.drawable.shoes1, "Price: $10")
        }

        findViewById<LinearLayout>(R.id.product2).setOnClickListener {
            addToCart("Product 2", R.drawable.shoes2, "Price: $15")
        }

        findViewById<LinearLayout>(R.id.product3).setOnClickListener {
            addToCart("Product 3", R.drawable.shoes3, "Price: $20")
        }

        findViewById<LinearLayout>(R.id.product4).setOnClickListener {
            addToCart("Product 4", R.drawable.shoes4, "Price: $25")
        }


        findViewById<TabLayout>(R.id.bottomTab).addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                if (tab.position == 1) { // Assuming the cart tab is at position 1
                    startActivity(Intent(this@MainActivity, CartActivity::class.java))
                }
            }

            override fun onTabUnselected(tab: TabLayout.Tab) {}
            override fun onTabReselected(tab: TabLayout.Tab) {}
        })
    }

    private fun addToCart(name: String, imageResId: Int, price: String) {
        Cart.addItem(CartItem(name, imageResId, price))
    }
}


