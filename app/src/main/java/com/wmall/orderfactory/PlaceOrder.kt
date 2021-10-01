package com.wmall.orderfactory

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.wmall.orderfactory.SelectProduct.Companion.CUSTOMER_NAME
import com.wmall.orderfactory.SelectProduct.Companion.PRODUCT_NAME
import com.wmall.orderfactory.databinding.ActivityPlaceOrderBinding
import android.text.Html


class PlaceOrder : AppCompatActivity() {
    private lateinit var binding: ActivityPlaceOrderBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPlaceOrderBinding.inflate(layoutInflater)
        supportActionBar?.hide()

        setContentView(binding.root)

        val customerName = intent.getStringExtra(CUSTOMER_NAME)
        val productName = intent.getStringExtra(PRODUCT_NAME)

        val msgString = "Order placed of <b>$productName</b> Successfully for <b>$customerName</b>"

        binding.tvDescription.text = Html.fromHtml(msgString)

        Handler().postDelayed({
            val homeIntent = Intent(this@PlaceOrder, HomeActivity::class.java)
            startActivity(homeIntent)
            finishAffinity()
        }, 3000)

    }
}