package com.wmall.orderfactory

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Html
import android.view.View
import android.widget.Toast
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
//        Toast.makeText(this,binding.etMobileNumber.text, Toast.LENGTH_LONG).show()

        if(binding.etMobileNumber.text.isNullOrEmpty())
            return

        val intent = Intent(this@LoginActivity, VerifyOtpActivity::class.java)

        val mobileNumber = binding.etMobileNumber.text
        intent.putExtra(MOBILE_NO, mobileNumber)
        startActivity(intent)
    }

    fun changeNumber(view: android.view.View) {
        onBackPressed()
    }
    companion object{
        const val MOBILE_NO = "mobile_number"
    }

}