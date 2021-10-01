package com.wmall.orderfactory

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Html
import android.util.Log
import android.widget.Toast
import com.wmall.orderfactory.LoginActivity.Companion.MOBILE_NO
import com.wmall.orderfactory.databinding.ActivityVerifyOtpBinding

class VerifyOtpActivity : AppCompatActivity() {
    private lateinit var binding: ActivityVerifyOtpBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityVerifyOtpBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()

        val mobileNumber = intent.getStringExtra(MOBILE_NO)
        Log.d("test", mobileNumber.toString())
        Toast.makeText(this, mobileNumber.toString(), Toast.LENGTH_LONG).show()

        binding.tvOtpMsg.text = Html.fromHtml("We have sent 4 digit OTP to <b>$mobileNumber</b>")

        binding.tvTermsNCondition.text = Html.fromHtml("By proceeding you accept <u>Terms of Service</u> and <u>Privacy Policy</u>")


        binding.ivBackBtn.setOnClickListener {
            onBackPressed()
        }

        binding.btnConfirmOtp.setOnClickListener {
            Toast.makeText(this, mobileNumber, Toast.LENGTH_LONG).show()

            val intent = Intent(this@VerifyOtpActivity, HomeActivity::class.java)
            intent.putExtra(MOBILE_NO, mobileNumber)
            startActivity(intent)
            finish()
        }
    }

}