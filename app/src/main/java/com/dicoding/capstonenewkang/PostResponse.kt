package com.dicoding.capstonenewkang

//data class PostResponse (
//    val id: Int,
//    val title: String?,
//    @SerializedName("body")
//    val text: String?
//)

data class PostResponse(
    val name_tukang: ArrayList<PostResponse>,
    val rating: Float,
    val foto_tukang: String = ""
        )


