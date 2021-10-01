package com.wmall.orderfactory

import android.R
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Html
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.SearchView
import android.widget.Toast
import com.wmall.orderfactory.databinding.ActivitySelectCustomerBinding
import com.wmall.orderfactory.databinding.ActivitySelectProductBinding

class SelectProduct : AppCompatActivity() {
    private lateinit var binding: ActivitySelectProductBinding
    private lateinit var adapter: ArrayAdapter<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySelectProductBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()

        val searchView = binding.searchView
        val listView = binding.listView

        val productList = ArrayList<String>()
        productList.add("Lamp")
        productList.add("Extravagance")
        productList.add("Casa")
        productList.add("Sofa")
        productList.add("Panther")
        productList.add("Divine")
        productList.add("Kristina")
        productList.add("Atlantis")
        productList.add("Reflection")
        productList.add("Million")
        productList.add("Mebel")
        productList.add("Linen")
        productList.add("Stallion")
        productList.add("Ware")
        productList.add("Sphynx")
        productList.add("Blanket")
        productList.add("Homelux")
        productList.add("Homeish")
        productList.add("Amber")
        productList.add("Versatile")

        adapter = ArrayAdapter<String>(this, R.layout.simple_list_item_1, productList)
        listView.adapter = adapter
        val customerName = intent.getStringExtra(CUSTOMER_NAME)
        val customerMsg = Html.fromHtml("Select Product for <b>$customerName</b>")
        binding.tvCustomerName.text = customerMsg


        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                if (productList.contains(query)) {
                    adapter.filter.filter(query)
                } else {
                    Toast.makeText(this@SelectProduct, "No Match found", Toast.LENGTH_LONG).show()
                }
                return false
            }
            override fun onQueryTextChange(newText: String?): Boolean {
                adapter.filter.filter(newText)
                return false
            }

        })
        listView.onItemClickListener =
            AdapterView.OnItemClickListener { listView, itemView, itemPosition, itemId ->
                val pintent = Intent(this@SelectProduct, PlaceOrder::class.java)
                pintent.putExtra(PRODUCT_NAME, productList[itemPosition])
                pintent.putExtra(CUSTOMER_NAME, intent.getStringExtra(CUSTOMER_NAME))
                startActivity(pintent)
                finishAffinity()
            }

    }
    companion object{
        const val PRODUCT_NAME = "product_name"
        const val CUSTOMER_NAME = "customer_name"
    }
}