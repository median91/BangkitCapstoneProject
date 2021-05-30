package com.dicoding.capstonenewkang.adapter.pager

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.dicoding.capstonenewkang.ui.fragment.AccountFragment
import com.dicoding.capstonenewkang.ui.fragment.ActivityFragment
import com.dicoding.capstonenewkang.ui.fragment.HomeFragment

internal class PagerAdapterHomepage (fragmentManager: FragmentManager) : FragmentPagerAdapter(fragmentManager){

    override fun getItem(position: Int): Fragment {
        return when(position) {
            0 -> ActivityFragment()
            1-> HomeFragment()
            2-> AccountFragment()
            else -> HomeFragment()
        }
    }

    override fun getCount(): Int {
       return 3
    }
}