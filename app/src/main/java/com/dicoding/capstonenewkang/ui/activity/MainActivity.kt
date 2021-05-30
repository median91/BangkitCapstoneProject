package com.dicoding.capstonenewkang.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.viewpager.widget.ViewPager
import com.dicoding.capstonenewkang.R
import com.dicoding.capstonenewkang.adapter.pager.PagerAdapterHomepage

class MainActivity : AppCompatActivity() {

    private lateinit var ivActivity: ImageView
    private lateinit var ivHome: ImageView
    private lateinit var ivAccount: ImageView

    private lateinit var mViewPager: ViewPager
    private lateinit var mPagerAdapterHomepage: PagerAdapterHomepage


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //init views
        mViewPager = findViewById(R.id.mViewPager)

        ivActivity = findViewById(R.id.ivActivity)
        ivHome = findViewById(R.id.ivHome)
        ivAccount = findViewById(R.id.ivAccount)


        //onClick listener
        ivActivity.setOnClickListener {
            mViewPager.currentItem = 0
        }
        ivHome.setOnClickListener {
            mViewPager.currentItem = 1
        }
        ivAccount.setOnClickListener {
            mViewPager.currentItem = 2
        }


        mPagerAdapterHomepage = PagerAdapterHomepage(supportFragmentManager)
        mViewPager.adapter = mPagerAdapterHomepage
        mViewPager.offscreenPageLimit = 3

        mViewPager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrollStateChanged(state: Int) {

            }

            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {

            }

            override fun onPageSelected(position: Int) {
                changeTabs(position)
            }
        })

        //default tab
        mViewPager.currentItem = 1
        ivHome.setImageResource(R.drawable.ic_baseline_home_active)
    }

    private fun changeTabs(position: Int) {
        if (position == 0) {
            ivActivity.setImageResource(R.drawable.ic_baseline_activity_active)
            ivHome.setImageResource(R.drawable.ic_baseline_home)
            ivAccount.setImageResource(R.drawable.ic_baseline_account)
        }
        else if (position == 1) {
            ivActivity.setImageResource(R.drawable.ic_baseline_activity)
            ivHome.setImageResource(R.drawable.ic_baseline_home_active)
            ivAccount.setImageResource(R.drawable.ic_baseline_account)
        }
        else {
            ivActivity.setImageResource(R.drawable.ic_baseline_activity)
            ivHome.setImageResource(R.drawable.ic_baseline_home)
            ivAccount.setImageResource(R.drawable.ic_baseline_account_active)
        }
    }
}