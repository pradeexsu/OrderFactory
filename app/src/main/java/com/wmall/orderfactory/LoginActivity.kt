package com.wmall.orderfactory

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Html
import android.view.View
import com.wmall.orderfactory.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()
        val termNCondition = Html.fromHtml("By proceeding you accept <u>Terms of Service</u> and <u>Privacy Policy</u>")
        binding.tvTermsNCondition?.text = termNCondition

    }
    fun loggedIn(view: View){
        val intent = Intent(this@LoginActivity, VerifyOtpActivity::class.java)
        startActivity(intent)
    }

    fun changeNumber(view: android.view.View) {
        onBackPressed()
    }


}