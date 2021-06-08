package com.dicoding.capstonenewkang.ui.fragment.status

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.dicoding.capstonenewkang.adapter.PayAdapter
import com.dicoding.capstonenewkang.data.DataTukang
import com.dicoding.capstonenewkang.data.Tukang
import com.dicoding.capstonenewkang.databinding.FragmentLetsPayBinding
import java.util.*


class LetsPayFragment : Fragment() {

    private lateinit var fragmentLetsPayBinding: FragmentLetsPayBinding
    private val list = ArrayList<Tukang>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        fragmentLetsPayBinding = FragmentLetsPayBinding.inflate(layoutInflater, container, false)
        return fragmentLetsPayBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (activity != null) {

            list.clear()
            val payAdapter = PayAdapter()
            list.addAll(DataTukang.listData)
            payAdapter.setData(list)
            payAdapter.notifyDataSetChanged()

            with(fragmentLetsPayBinding.rvOrder) {
                layoutManager = LinearLayoutManager(context)
                setHasFixedSize(true)
                adapter = payAdapter
            }
        }
    }
}