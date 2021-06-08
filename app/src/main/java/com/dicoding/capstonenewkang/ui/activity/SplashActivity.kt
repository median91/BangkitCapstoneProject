package com.dicoding.capstonenewkang.ui.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView
import com.dicoding.capstonenewkang.R

class SplashActivity : AppCompatActivity() {

    private lateinit var handler: Handler
    private lateinit var bounceAnimation: Animation
    private lateinit var imageSplash: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        bounceAnimation = AnimationUtils.loadAnimation(this, R.anim.bounce_animation)

        imageSplash = findViewById(R.id.logoNewkang)

        imageSplash.startAnimation(bounceAnimation)

        handler = Handler(Looper.getMainLooper())
        handler.postDelayed({
            val intent = Intent(this, WelcomeActivity::class.java)
            startActivity(intent)
            finish()

        }, 2000)
    }
}