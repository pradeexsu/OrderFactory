package com.wmall.orderfactory

import android.R
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.wmall.orderfactory.databinding.ActivitySelectCustomerBinding
import android.widget.Toast


import android.widget.ArrayAdapter
import android.widget.SearchView
import android.widget.AdapterView

import android.widget.AdapterView.OnItemClickListener





class SelectCustomer : AppCompatActivity() {
    private lateinit var binding: ActivitySelectCustomerBinding
    private lateinit var adapter: ArrayAdapter<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySelectCustomerBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()

        val searchView = binding.searchView
        val listView = binding.listView
        var list = ArrayList<String>()
        list.add("Samantha	Hardacre")
        list.add("Alison	Ince")
        list.add("Sally	Skinner")
        list.add("Nicholas	Clarkson")
        list.add("Angela	Mackay")
        list.add("Cameron	Reid")
        list.add("Eric	Mills")
        list.add("Vanessa	Underwood")
        list.add("Vanessa	Tucker")
        list.add("Harry	Turner")



        adapter = ArrayAdapter<String>(this, R.layout.simple_list_item_1, list)
        listView.adapter = adapter

        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                if (list.contains(query)) {
                    adapter.filter.filter(query)
                } else {
                    Toast.makeText(this@SelectCustomer, "No Match found", Toast.LENGTH_LONG).show()
                }
                return false
            }
            override fun onQueryTextChange(newText: String?): Boolean {
                    adapter.filter.filter(newText)
                return false
            }

        })
        listView.onItemClickListener =
            OnItemClickListener { listView, itemView, itemPosition, itemId ->
                val intent = Intent(this@SelectCustomer,SelectProduct::class.java)
                intent.putExtra(SelectProduct.CUSTOMER_NAME, list[itemPosition])
                startActivity(intent)
            }


    }
}

