package com.example.simpleshoppingapp

data class CartItem(val name: String, val imageResId: Int, val price: String)

object Cart {
    private val items = mutableListOf<CartItem>()

    fun addItem(item: CartItem) {
        items.add(item)
    }

    fun getItems(): List<CartItem> = items

    fun removeItem(item: CartItem) {
        items.remove(item)
    }

    fun clear() {
        items.clear()
    }
}
