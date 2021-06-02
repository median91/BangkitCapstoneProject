package com.dicoding.capstonenewkang.ui.activity

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.ActionBar
import com.dicoding.capstonenewkang.databinding.ActivityOrderBinding
import com.google.android.material.datepicker.MaterialDatePicker
import java.text.SimpleDateFormat
import java.util.*

class OrderActivity : AppCompatActivity() {

    private var title = "Service"
    private lateinit var binding: ActivityOrderBinding

    companion object {
        const val REQUEST_CODE = 100
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOrderBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setActionBarTitle(title)

        var quantity = 1

        val salary = 100000
        var sum = 100000

        binding.tvPrice.text = sum.toString()
        binding.tvTotalPrice.text = sum.toString()

        binding.btnPlus.setOnClickListener {

            quantity++
            sum += salary
            binding.totalTukang.text = quantity.toString()
            binding.tvPrice.text = sum.toString()
            binding.tvTotalPrice.text = sum.toString()

        }

        binding.btnMinus.setOnClickListener {
            if (quantity > 1) {
                quantity--
                sum -= salary
            }
            binding.totalTukang.text = quantity.toString()
            binding.tvPrice.text = sum.toString()
            binding.tvTotalPrice.text = sum.toString()

        }

        binding.btnDatePicker.setOnClickListener {
            showDataRangePicker()
        }

        binding.btnPickImage.setOnClickListener {
            pickImageGallery()
        }

        binding.btnRight.setOnClickListener {
            startActivity(Intent(this, PaymentActivity::class.java))
        }
    }

    private fun showDataRangePicker() {

        val dateRangePicker = MaterialDatePicker
                .Builder.dateRangePicker()
                .setTitleText("Select Date")
                .build()

        dateRangePicker.show(
            supportFragmentManager,
            "date_range_picker"
        )

        dateRangePicker.addOnPositiveButtonClickListener { dateSelected ->

            val startDate = dateSelected.first
            val endDate = dateSelected.second

            if (startDate != null && endDate != null) {
                binding.scheduleDate.text = "${convertLongToTime(startDate)} - " + "${convertLongToTime(endDate)}"
            }
        }

    }

    private fun convertLongToTime(time: Long): String {
        val date = Date(time)
        val format = SimpleDateFormat(
            "dd.MM.yyyy",
            Locale.getDefault()
        )
        return format.format(date)
    }


    private fun pickImageGallery() {
        val intent = Intent(Intent.ACTION_PICK)
        intent.type = "image/*"
        startActivityForResult(intent, REQUEST_CODE);
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_OK && requestCode == REQUEST_CODE) {
            binding.ivPhoto.setImageURI(data?.data) // handle chosen image
        }
    }

    private fun setActionBarTitle(title: String) {
        if (supportActionBar != null) {
            (supportActionBar as ActionBar).title = title
        }
    }

}