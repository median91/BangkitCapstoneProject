package com.dicoding.capstonenewkang.ui.activity.menu

import android.content.res.Resources
import android.os.Bundle
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import com.dicoding.capstonenewkang.adapter.pager.SectionsPagerAdapter
import com.dicoding.capstonenewkang.databinding.ActivityStatusBinding

class StatusActivity : AppCompatActivity() {

    private lateinit var activityStatusBinding: ActivityStatusBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityStatusBinding = ActivityStatusBinding.inflate(layoutInflater)
        setContentView(activityStatusBinding.root)

        val sectionsPagerAdapter = SectionsPagerAdapter(this, supportFragmentManager)
        activityStatusBinding.viewPager.adapter = sectionsPagerAdapter
        activityStatusBinding.tabLayout.setupWithViewPager(activityStatusBinding.viewPager)
        for (i in 0 until activityStatusBinding.tabLayout.getTabCount()) {
            val tab = (activityStatusBinding.tabLayout.getChildAt(0) as ViewGroup).getChildAt(i)
            val p = tab.layoutParams as ViewGroup.MarginLayoutParams
            p.setMargins(dpToPx(10), 0, dpToPx(10), 0)
            tab.requestLayout()
        }
        supportActionBar?.elevation = 0f
    }
    private fun dpToPx(dp: Int): Int {
        return ((dp * Resources.getSystem().displayMetrics.density).toInt());
    }
}