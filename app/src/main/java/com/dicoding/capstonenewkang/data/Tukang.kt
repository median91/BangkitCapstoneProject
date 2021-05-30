package com.dicoding.capstonenewkang.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Tukang(
    var title: String = "",
    var orderDate: String = "",
    var payDate: String = "",
    var doDate: String = "",
    var total: String = "",
    var photo: Int = 0
) : Parcelable