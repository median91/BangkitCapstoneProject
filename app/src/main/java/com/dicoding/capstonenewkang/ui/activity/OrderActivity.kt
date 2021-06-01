package com.dicoding.capstonenewkang.ui.activity

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.ActionBar
import com.dicoding.capstonenewkang.databinding.ContentOrderBinding
import com.dicoding.capstonenewkang.ui.fragment.DatePickerFragment
import java.text.SimpleDateFormat
import java.util.*

class OrderActivity : AppCompatActivity(), DatePickerFragment.DialogDateListener {

    private var title = "Service"
    private lateinit var binding: ContentOrderBinding

    companion object {
        private const val DATE_PICKER_TAG = "DatePicker"
        const val REQUEST_CODE = 100
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ContentOrderBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setActionBarTitle(title)

        var quantity = 0
        val salary = 150000
        var sum = 150000
        binding.tvPrice.text = sum.toString()

        binding.btnPlus.setOnClickListener {
            binding.tvPrice.text = sum.toString()
            quantity++
            binding.totalTukang.text = quantity.toString()

            sum += (salary * 1)
        }

        binding.btnMinus.setOnClickListener {

            if (quantity > 1) {
                quantity--
                sum -= (salary * 1)
            }
            binding.tvPrice.text = sum.toString()
            binding.totalTukang.text = quantity.toString()

        }

        binding.btnDatePicker.setOnClickListener {
            val datePickerFragment = DatePickerFragment()
            datePickerFragment.show(supportFragmentManager, DATE_PICKER_TAG)

        }

        binding.btnPickImage.setOnClickListener {
            pickImageGallery()
        }

        binding.btnRight.setOnClickListener {
            startActivity(Intent(this, PaymentActivity::class.java))
        }
    }

    override fun onDialogDateSet(tag: String?, year: Int, month: Int, dayOfMonth: Int) {

        val calendar = Calendar.getInstance()
        calendar.set(year, month, dayOfMonth)
        val dateFormat = SimpleDateFormat("dd-MM- yyyy", Locale.getDefault())

        binding.scheduleDate.text = dateFormat.format(calendar.time)
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