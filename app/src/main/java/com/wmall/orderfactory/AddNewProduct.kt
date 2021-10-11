package com.wmall.orderfactory

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import com.wmall.orderfactory.data.Product
import com.wmall.orderfactory.databinding.ActivityAddNewProductBinding

class AddNewProduct : AppCompatActivity() {
    private lateinit var binding: ActivityAddNewProductBinding


    private lateinit var model: ProductViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddNewProductBinding.inflate(layoutInflater)

        setContentView(binding.root)

        val model: ProductViewModel by viewModels()
        supportActionBar?.hide()
        binding.btnBack.setOnClickListener {
            onBackPressed()
        }

        binding.btnAddIt.setOnClickListener {

            val product = Product(
                0,
                binding.etProductName.text.toString(),
                binding.etPrice.text.toString(),
                binding.etQuantity.text.toString()
            )

            model.addProduct( product )
            Toast.makeText(this,"Product Added Successfully", Toast.LENGTH_LONG)
            val intent = Intent(this@AddNewProduct, ProductList::class.java)
            startActivity(intent)
            finishAffinity()

        }
    }
}