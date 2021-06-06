package com.dicoding.capstonenewkang.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.dicoding.capstonenewkang.ui.activity.ReviewActivity
import com.dicoding.capstonenewkang.data.Tukang
import com.dicoding.capstonenewkang.databinding.ItemOrderDoneBinding

class DoneAdapter : RecyclerView.Adapter<DoneAdapter.ListViewHolder>() {

    private val listUser = ArrayList<Tukang>()

    fun setData(items: ArrayList<Tukang>) {
        if (items.isNullOrEmpty()) return
        this.listUser.clear()
        this.listUser.addAll(items)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val itemsOrderDoneBinding =
            ItemOrderDoneBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ListViewHolder(itemsOrderDoneBinding)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val data = listUser[position]
        holder.bind(data)
    }

    override fun getItemCount(): Int = listUser.size

    class ListViewHolder(private val binding: ItemOrderDoneBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(userItems: Tukang) {
            with(binding) {
                binding.tvService.text = userItems.title
                binding.doDate.text = userItems.doDate
                binding.total.text = userItems.total

                Glide.with(itemView.context)
                    .load(userItems.photo)
                    .apply(RequestOptions().override(35, 35))
                    .into(imgService)

                btnReview.setOnClickListener {
                    val intent = Intent(itemView.context, ReviewActivity::class.java)
                    intent.putExtra(ReviewActivity.EXTRA_DATA, userItems)
                    itemView.context.startActivity(intent)
                }

            }
        }
    }
}