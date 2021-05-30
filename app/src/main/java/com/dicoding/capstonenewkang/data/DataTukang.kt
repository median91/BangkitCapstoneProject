package com.dicoding.capstonenewkang.data

import com.dicoding.capstonenewkang.R
import java.util.ArrayList

object DataTukang {
    private val serviceNames = arrayOf(
        "Perbaikan Genteng"
    )

    private val orderDateService = arrayOf(
        "8 July 2021, 09:00 "
    )

    private val payDateService = arrayOf(
        "9 July 2021, 17:00"
    )

    private val doDateService = arrayOf(
        "10 July 2021 - 12 July 2021"
    )

    private val totalPay = arrayOf(
        "Rp. 450.000"
    )

    private val photoService = intArrayOf(
        R.drawable.hammer,
    )

    val listData: ArrayList<Tukang>
        get() {
            val list = arrayListOf<Tukang>()
            for (position in serviceNames.indices) {
                val tukang= Tukang()
                tukang.title = serviceNames[position]
                tukang.orderDate = orderDateService[position]
                tukang.payDate = payDateService[position]
                tukang.doDate = doDateService[position]
                tukang.total = totalPay[position]
                tukang.photo = photoService[position]
                list.add(tukang)
            }
            return list
        }
}