package com.wmall.orderfactory

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.wmall.orderfactory.data.Product
import com.wmall.orderfactory.databinding.ItemProductStatusBinding

class ProductAdapter(
    private val context: Context,
) : RecyclerView.Adapter<ProductAdapter.ProductHolder>() {
    lateinit var productList: List<Product>


    inner class ProductHolder(private val binding: ItemProductStatusBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(product: Product) {
            binding.tvProductName.text = product.productName
            binding.tvProductPrice.text = "₹${product.price}"
            binding.tvQuantity.text = "Quantity: ${product.quantity}"
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductHolder {
        return ProductHolder(
            ItemProductStatusBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ProductHolder, position: Int) {
        holder.bind(productList[position])
    }

    override fun getItemCount(): Int {
        return productList.size
    }
    fun setData(products: List<Product>){
        productList = products
        notifyDataSetChanged()
    }

}