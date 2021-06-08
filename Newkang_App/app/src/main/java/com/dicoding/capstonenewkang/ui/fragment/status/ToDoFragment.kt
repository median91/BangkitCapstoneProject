package com.dicoding.capstonenewkang.ui.fragment.status


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.dicoding.capstonenewkang.adapter.OrderAdapter
import com.dicoding.capstonenewkang.data.DataTukang
import com.dicoding.capstonenewkang.data.Tukang
import com.dicoding.capstonenewkang.databinding.FragmentToDoBinding
import java.util.ArrayList

class ToDoFragment : Fragment() {

    private lateinit var fragmentToDoBinding: FragmentToDoBinding
    private val list = ArrayList<Tukang>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        fragmentToDoBinding = FragmentToDoBinding.inflate(layoutInflater, container, false)
        return fragmentToDoBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (activity != null) {

            list.clear()
            val orderAdapter = OrderAdapter()
            list.addAll(DataTukang.listData)
            orderAdapter.setData(list)
            orderAdapter.notifyDataSetChanged()

            with(fragmentToDoBinding.rvOrder) {
                layoutManager = LinearLayoutManager(context)
                setHasFixedSize(true)
                adapter = orderAdapter
            }
        }
    }
}

