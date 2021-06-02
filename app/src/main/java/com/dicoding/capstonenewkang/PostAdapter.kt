package com.dicoding.capstonenewkang

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.dicoding.capstonenewkang.databinding.ItemPostBinding

class PostAdapter(private val list: ArrayList<PostResponse>): RecyclerView.Adapter<PostAdapter.PostViewHolder>() {

    private val listPost= ArrayList<PostResponse>()

    class PostViewHolder(private val binding: ItemPostBinding ):
        RecyclerView.ViewHolder(binding.root) {
        fun bind(postItems: PostResponse) {
            with(binding) {
                binding.tvNameTukang.text = postItems.name_tukang.toString()
             //   binding.ratingTukang.text = postItems.rating.toString()
                Glide.with(itemView.context)
                    .load(postItems.foto_tukang)
                    .apply(RequestOptions().override(55,55))

            }
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): PostViewHolder {
        val itemPostBinding = ItemPostBinding.inflate(LayoutInflater.from(viewGroup.context), viewGroup, false)
        return PostViewHolder(itemPostBinding)
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        val data= listPost[position]
        holder.bind(data)
    }

    override fun getItemCount(): Int = listPost.size


}