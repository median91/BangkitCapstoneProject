package com.dicoding.capstonenewkang.adapter.pager

import android.content.Context
import androidx.annotation.StringRes
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.dicoding.capstonenewkang.ui.fragment.status.DoneFragment
import com.dicoding.capstonenewkang.ui.fragment.status.GoFragment
import com.dicoding.capstonenewkang.ui.fragment.status.LetsPayFragment
import com.dicoding.capstonenewkang.ui.fragment.status.ToDoFragment
import com.dicoding.capstonenewkang.R

class SectionsPagerAdapter(private val mContext: Context, fm: FragmentManager) :
    FragmentPagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    companion object {
        @StringRes
        private val TAB_TITLES = intArrayOf(
            R.string.lets_pay,
            R.string.todo,
            R.string.go,
            R.string.done, )
    }

    override fun getItem(position: Int): Fragment =
        when (position) {
            0 -> LetsPayFragment()
            1 -> ToDoFragment()
            2 -> GoFragment()
            3 -> DoneFragment()
            else -> Fragment()
        }

    override fun getPageTitle(position: Int): CharSequence = mContext.resources.getString(TAB_TITLES[position])

    override fun getCount(): Int = TAB_TITLES.size

}