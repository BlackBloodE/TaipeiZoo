package com.elton.taipeizoo.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.blankj.utilcode.util.LogUtils
import com.elton.taipeizoo.R
import com.elton.taipeizoo.adapter.ZooAdapter
import com.elton.taipeizoo.base.BaseFragment
import com.elton.taipeizoo.api.data.ZooResults
import com.elton.taipeizoo.contract.ZooContract
import com.elton.taipeizoo.databinding.FragmentZooBinding
import com.elton.taipeizoo.presenter.ZooPresenter

class ZooFragment : BaseFragment(), ZooContract.IZooView {
    private lateinit var adapter: ZooAdapter
    private lateinit var binding: FragmentZooBinding
    private lateinit var presenter: ZooContract.IZooPresenter

    private var isFirst = true

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentZooBinding.inflate(inflater, container, false)

        init()
        return binding.root
    }

    private fun init() {
        LogUtils.d("MainFragment", "init")
        setToolBar("臺北市立動物園", false)

        if (isFirst) {
            presenter = ZooPresenter()
        }
        presenter.attachView(this)
        presenter.loadZooData(isFirst)
    }

    override fun setRecyclerView(dataList: ArrayList<ZooResults>) {
        adapter = ZooAdapter(R.layout.item, dataList)
        adapter.setOnItemClickListener { _, _, position ->
            gotoNextPage(adapter.getItem(position))
        }
        binding.recycler.layoutManager = LinearLayoutManager(this.context)
        binding.recycler.adapter = adapter
        binding.recycler.addItemDecoration(
            DividerItemDecoration(
                binding.root.context,
                DividerItemDecoration.VERTICAL
            )
        )
    }

    private fun gotoNextPage(data: ZooResults) {
        val bundle = bundleOf("data" to data)
        findNavController().navigate(
            R.id.action_mainFragment_to_secondFragment,
            bundle,
            null,
            null
        )
    }

    override fun showProgress() {
        binding.progressBar.visibility = View.VISIBLE
    }

    override fun closeProgress() {
        binding.progressBar.visibility = View.GONE
    }

    override fun showLoadStatus(msg: String) {
        binding.tvStatusZoom.text = msg
    }

    override fun onDestroyView() {
        super.onDestroyView()
        isFirst = false
        presenter.detachView()
    }
}