package com.wmall.orderfactory

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Html
import com.wmall.orderfactory.databinding.ActivityVerifyOtpBinding

class VerifyOtpActivity : AppCompatActivity() {
    private lateinit var binding: ActivityVerifyOtpBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityVerifyOtpBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()
        binding.tvTermsNCondition?.text = Html.fromHtml("By proceeding you accept <u>Terms of Service</u> and <u>Privacy Policy</u>")

        binding.ivBackBtn.setOnClickListener {
            onBackPressed()
        }

        binding.btnConfirmOtp.setOnClickListener {
            val intent = Intent(this@VerifyOtpActivity, HomeActivity::class.java)
            startActivity(intent)
            finishAffinity()
        }

    }
}