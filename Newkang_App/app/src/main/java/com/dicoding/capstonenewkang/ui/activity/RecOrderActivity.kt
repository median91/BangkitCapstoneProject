package com.dicoding.capstonenewkang.ui.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.dicoding.capstonenewkang.databinding.ActivityRecOrderBinding

class RecOrderActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRecOrderBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRecOrderBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnRecOrder.setOnClickListener {
            startActivity(Intent(this, ResultRecOrderActivity::class.java))
        }
    }
}