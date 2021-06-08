package com.dicoding.capstonenewkang.ui.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.ActionBar
import com.dicoding.capstonenewkang.databinding.ActivityReviewBinding
import com.dicoding.capstonenewkang.ui.activity.menu.StatusActivity

class ReviewActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_DATA = "extra_data"
    }
    private var title = "Review"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val activityReviewBinding = ActivityReviewBinding.inflate(layoutInflater)
        setContentView(activityReviewBinding.root)
        setActionBarTitle(title)

        activityReviewBinding.btnBack2home.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
    private fun setActionBarTitle(title: String) {
        if (supportActionBar != null) {
            (supportActionBar as ActionBar).title = title
        }
    }
}