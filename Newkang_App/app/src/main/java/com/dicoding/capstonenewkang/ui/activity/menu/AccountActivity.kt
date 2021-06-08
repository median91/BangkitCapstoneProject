package com.dicoding.capstonenewkang.ui.activity.menu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.dicoding.capstonenewkang.databinding.ActivityAccountBinding


class AccountActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAccountBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAccountBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}