package com.dicoding.capstonenewkang.ui.fragment.status


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.dicoding.capstonenewkang.adapter.DoneAdapter
import com.dicoding.capstonenewkang.data.DataTukang
import com.dicoding.capstonenewkang.data.Tukang
import com.dicoding.capstonenewkang.databinding.FragmentDoneBinding
import java.util.ArrayList

class DoneFragment : Fragment() {

    private lateinit var fragmentDoneBinding: FragmentDoneBinding
    private val list = ArrayList<Tukang>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        fragmentDoneBinding = FragmentDoneBinding.inflate(layoutInflater, container, false)
        return fragmentDoneBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (activity != null) {

            list.clear()
            val doneAdapter = DoneAdapter()
            list.addAll(DataTukang.listData)
            doneAdapter.setData(list)
            doneAdapter.notifyDataSetChanged()

            with(fragmentDoneBinding.rvOrder) {
                layoutManager = LinearLayoutManager(context)
                setHasFixedSize(true)
                adapter = doneAdapter
            }
        }

    }

}