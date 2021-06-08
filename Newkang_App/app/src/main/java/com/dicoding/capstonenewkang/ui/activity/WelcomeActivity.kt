package com.dicoding.capstonenewkang.ui.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.dicoding.capstonenewkang.R

class WelcomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)

        val btnGo = findViewById<Button>(R.id.btnGo)
        btnGo.setOnClickListener {
            Intent(this@WelcomeActivity, LoginActivity::class.java).also {
                startActivity(it)
            }
        }

    }

}

