package com.wmall.orderfactory

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.wmall.orderfactory.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()
        binding.ivProfilePic.setImageResource(R.drawable.img)

        binding.flMakeOrder.setOnClickListener{
            val intent = Intent(this@HomeActivity, SelectCustomer::class.java)
            startActivity(intent)
        }
        binding.btnLogOut.setOnClickListener {
            val logout_intent = Intent(this@HomeActivity, LoginActivity::class.java)
            startActivity(logout_intent)
            finish()
        }
        binding.flCollections.setOnClickListener {
            Toast.makeText(this@HomeActivity,"feature under Construction", Toast.LENGTH_LONG).show()
        }
        binding.flViewOrders.setOnClickListener {
            Toast.makeText(this@HomeActivity,"feature under Construction", Toast.LENGTH_LONG).show()
        }
        binding.flSettings.setOnClickListener {
            Toast.makeText(this@HomeActivity,"feature under Construction", Toast.LENGTH_LONG).show()
        }

    }
}