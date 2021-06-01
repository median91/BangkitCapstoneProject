package com.dicoding.capstonenewkang.ui.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.ActionBar
import com.dicoding.capstonenewkang.databinding.ActivityOrderBinding

class OrderActivity : AppCompatActivity() {

    private var title = "Service"
    private lateinit var binding: ActivityOrderBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOrderBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setActionBarTitle(title)

        binding.btnRight.setOnClickListener {
            startActivity(Intent(this, PaymentActivity::class.java))
        }
    }

    private fun setActionBarTitle(title: String) {
        if (supportActionBar != null) {
            (supportActionBar as ActionBar).title = title
        }
    }
}