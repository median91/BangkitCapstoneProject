package com.dicoding.capstonenewkang.ui.activity.menu

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.dicoding.capstonenewkang.R
import com.dicoding.capstonenewkang.databinding.ActivityHomeBinding
import com.dicoding.capstonenewkang.ui.activity.OrderActivity
import com.dicoding.capstonenewkang.ui.activity.RecOrderActivity
import com.synnapps.carouselview.CarouselView
import com.synnapps.carouselview.ImageListener


class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding
    var imgSlider = intArrayOf(
        R.drawable.information1,
        R.drawable.information2,
        R.drawable.information3,
        R.drawable.information4
    )

    var textSlider = arrayOf(
        "Information 1",
        "Information 2",
        "Information 3",
        "Information 4"
    )


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


        val carouselView = findViewById<CarouselView>(R.id.carouselView)
        carouselView.pageCount = textSlider.size

        carouselView.setImageListener(imageListener)
    }
    var imageListener =
        ImageListener { position, imageView -> imageView.setImageResource(imgSlider.get(position)) }



}