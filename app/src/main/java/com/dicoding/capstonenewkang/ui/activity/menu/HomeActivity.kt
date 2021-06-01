package com.dicoding.capstonenewkang.ui.activity.menu

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.dicoding.capstonenewkang.databinding.ActivityHomeBinding
import com.dicoding.capstonenewkang.ui.activity.OrderActivity
import com.dicoding.capstonenewkang.ui.activity.RecOrderActivity

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnRepairmanNow.setOnClickListener {
            startActivity(Intent(this, RecOrderActivity::class.java))
        }

        binding.serviceToilet.setOnClickListener {
            startActivity(Intent(this, OrderActivity::class.java))
        }

        binding.serviceDoor.setOnClickListener {
            startActivity(Intent(this, OrderActivity::class.java))
        }
    }

}