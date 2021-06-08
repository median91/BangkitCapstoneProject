package com.dicoding.capstonenewkang.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.dicoding.capstonenewkang.ui.activity.PaymentActivity
import com.dicoding.capstonenewkang.data.Tukang
import com.dicoding.capstonenewkang.databinding.ItemOrderPayBinding

class PayAdapter : RecyclerView.Adapter<PayAdapter.ListViewHolder>() {

    private val listUser = ArrayList<Tukang>()

    fun setData(items: ArrayList<Tukang>) {
        if (items.isNullOrEmpty()) return
        this.listUser.clear()
        this.listUser.addAll(items)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val itemsOrderPayBinding =
            ItemOrderPayBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ListViewHolder(itemsOrderPayBinding)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val data = listUser[position]
        holder.bind(data)
    }

    override fun getItemCount(): Int = listUser.size

    class ListViewHolder(private val binding: ItemOrderPayBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(userItems: Tukang) {
            with(binding) {
                binding.tvService.text = userItems.title
                binding.orderDate.text = userItems.orderDate
                binding.payBefore.text = userItems.payDate

                Glide.with(itemView.context)
                    .load(userItems.photo)
                    .apply(RequestOptions().override(35, 35))
                    .into(imgService)

                btnPay.setOnClickListener {
                    val intent = Intent(itemView.context, PaymentActivity::class.java)
                    intent.putExtra(PaymentActivity.EXTRA_DATA, userItems)
                    itemView.context.startActivity(intent)
                }

            }
        }
    }
}