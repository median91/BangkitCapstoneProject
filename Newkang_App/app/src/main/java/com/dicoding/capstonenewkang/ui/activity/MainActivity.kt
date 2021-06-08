package com.dicoding.capstonenewkang.ui.activity

import android.app.TabActivity
import android.content.Intent
import android.content.res.Resources
import android.os.Bundle
import android.widget.TabHost
import android.widget.TabHost.TabSpec
import com.dicoding.capstonenewkang.R
import com.dicoding.capstonenewkang.ui.activity.menu.AccountActivity
import com.dicoding.capstonenewkang.ui.activity.menu.HomeActivity
import com.dicoding.capstonenewkang.ui.activity.menu.StatusActivity
import com.synnapps.carouselview.CarouselView


class MainActivity : TabActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val ressources: Resources = resources
        val tabHost: TabHost = getTabHost()

        val intentActivity= Intent().setClass(this, StatusActivity::class.java)
        val tabStatus: TabSpec = tabHost
            .newTabSpec("Status")
            .setIndicator("", ressources.getDrawable(R.drawable.icon_activity))
            .setContent(intentActivity)

        val intentHome = Intent().setClass(this, HomeActivity::class.java)
        val tabHome: TabSpec = tabHost
            .newTabSpec("Home")
            .setIndicator("", ressources.getDrawable(R.drawable.icon_home))
            .setContent(intentHome)

        val intentAccount = Intent().setClass(this, AccountActivity::class.java)
        val tabAccount = tabHost
            .newTabSpec("Account")
            .setIndicator("", ressources.getDrawable(R.drawable.icon_account))
            .setContent(intentAccount)

        tabHost.addTab(tabStatus)
        tabHost.addTab(tabHome)
        tabHost.addTab(tabAccount)

        tabHost.setCurrentTab(1);




    }
}