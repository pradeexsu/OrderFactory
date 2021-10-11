package com.wmall.orderfactory

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.room.Room
import com.wmall.orderfactory.databinding.ActivityProductListBinding

class ProductList : AppCompatActivity() {
    private lateinit var binding: ActivityProductListBinding
    private lateinit var adapter: ProductAdapter
    private lateinit var model: ProductViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        binding = ActivityProductListBinding.inflate(layoutInflater)
        setContentView(binding.root)
        adapter = ProductAdapter(this)

        binding.rvProducts.adapter = adapter
        binding.rvProducts.layoutManager = LinearLayoutManager(this)
        model = ViewModelProvider(this).get(ProductViewModel::class.java)

        model.getProducts().observe(this, Observer {
            adapter.setData (it)
        })

        binding.btnAddProduct.setOnClickListener {
            val intent = Intent(this@ProductList, AddNewProduct::class.java)
            startActivity(intent)
        }

    }
}

