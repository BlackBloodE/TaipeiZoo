package com.elton.taipeizoo.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.elton.taipeizoo.R
import com.elton.taipeizoo.adapter.PlantAdapter
import com.elton.taipeizoo.base.BaseFragment
import com.elton.taipeizoo.contract.ZooInfoContract
import com.elton.taipeizoo.api.data.PlantResults
import com.elton.taipeizoo.api.data.ZooResults
import com.elton.taipeizoo.databinding.FragmentZooInfoBinding
import com.elton.taipeizoo.presenter.ZooInfoPresenter

class ZooInfoFragment : BaseFragment(), ZooInfoContract.IZooInfoView {
    private lateinit var binding: FragmentZooInfoBinding
    private lateinit var presenter: ZooInfoContract.IZooInfoPresenter
    private lateinit var adapter: PlantAdapter

    private var isFirst = true
    private var lastScrollY = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentZooInfoBinding.inflate(inflater, container, false)

        init()
        return binding.root
    }

    private fun init() {
        val data = arguments?.getSerializable("data") as ZooResults
        setToolBar(data.e_name, true)
        Glide.with(this)
            .load(data.e_pic_url)
            .placeholder(R.drawable.brvah_sample_footer_loading)
            .error(R.drawable.ic_baseline_image_not_supported_24)
            .into(binding.ivHead)
        binding.tvInfo2.text = data.e_info
        binding.tvMemo2.text = data.e_memo
        binding.tvCategory.text = data.e_category

        if (isFirst) {
            presenter = ZooInfoPresenter()
        } else {
            binding.svZooInfo.scrollY = lastScrollY
        }
        presenter.attachView(this)
        presenter.loadPlantData(data.e_name, isFirst)
    }

    override fun setRecyclerView(dataList: ArrayList<PlantResults>) {
        adapter = PlantAdapter(R.layout.item, dataList)
        adapter.setOnItemClickListener { _, _, position ->
            gotoNextPage(adapter.getItem(position))
        }

        binding.recyclerPlant.layoutManager = LinearLayoutManager(this.context)
        binding.recyclerPlant.adapter = adapter
        binding.recyclerPlant.addItemDecoration(
            DividerItemDecoration(
                binding.root.context,
                DividerItemDecoration.VERTICAL
            )
        )
    }

    private fun gotoNextPage(data: PlantResults) {
        val bundle = bundleOf("data" to data)
        findNavController().navigate(
            R.id.action_secondFragment_to_plantFragment,
            bundle,
            null,
            null
        )
    }

    override fun showProgress() {
        binding.pbPlant.visibility = View.VISIBLE
    }

    override fun closeProgress() {
        binding.pbPlant.visibility = View.GONE
    }

    override fun showLoadStatus(msg: String) {
        binding.tvStatusPlant.text = msg
    }

    override fun onDestroyView() {
        super.onDestroyView()
        lastScrollY = binding.svZooInfo.scrollX
        isFirst = false
        presenter.detachView()
    }
}