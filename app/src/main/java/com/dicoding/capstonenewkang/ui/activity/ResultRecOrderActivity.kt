package com.dicoding.capstonenewkang.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.dicoding.capstonenewkang.PostAdapter
import com.dicoding.capstonenewkang.PostResponse
import com.dicoding.capstonenewkang.R
import com.dicoding.capstonenewkang.RetrofitClient
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ResultRecOrderActivity : AppCompatActivity() {

    private val userPost = MutableLiveData<PostResponse>()

    private lateinit var postAdapter: PostAdapter
    private val list = ArrayList<PostResponse>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result_rec_order)

        val rvPost = findViewById<RecyclerView>(R.id.rvRecTukang)
        val tvNameTukang = findViewById<TextView>(R.id.tvNameTukang)
        val tvRating = findViewById<TextView>(R.id.tvRatingTukang)

        rvPost.setHasFixedSize(true)
        rvPost.layoutManager = LinearLayoutManager(this)

        RetrofitClient.instance.getPosts().enqueue(object : Callback<ArrayList<PostResponse>>{

            override fun onResponse(
                call: Call<ArrayList<PostResponse>>,
                response: Response<ArrayList<PostResponse>>
            ) {
                val responseCode = response.code().toString()
                tvNameTukang.text = responseCode

//                val result = String(respon)
//                val responseCode = JSONObject(res)
//                val postResponse = PostResponse
//                userPost.postValue(postResponse)
//                    tvNameTukang.text = responseCode
//                response.body()?.let { list.addAll(it) }
//                val adapter = PostAdapter(list)
//                rvPost.adapter = adapter
            }

            override fun onFailure(call: Call<ArrayList<PostResponse>>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })


    }
}