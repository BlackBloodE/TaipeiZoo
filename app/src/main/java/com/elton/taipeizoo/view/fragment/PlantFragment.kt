package com.elton.taipeizoo.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.elton.taipeizoo.R
import com.elton.taipeizoo.base.BaseFragment
import com.elton.taipeizoo.api.data.PlantResults
import com.elton.taipeizoo.databinding.FragmentPlantBinding

class PlantFragment : BaseFragment() {
    private lateinit var binding: FragmentPlantBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPlantBinding.inflate(layoutInflater)

        init()
        return binding.root
    }

    private fun init() {
        val data = arguments?.getSerializable("data") as PlantResults
        setToolBar(data.name_Ch, true)
        Glide.with(this)
            .load(data.pic01_URL)
            .placeholder(R.drawable.brvah_sample_footer_loading)
            .error(R.drawable.ic_baseline_image_not_supported_24)
            .into(binding.ivPlant)
        binding.tvPlantName.text = data.name_Ch
        binding.tvPlantNameEn.text = data.name_En
        binding.tvAlsoKnow.text = data.alsoKnow
        binding.tvBrief.text = data.brief
        binding.tvFeature.text = data.feature
        binding.tvFunApp.text = data.fun_app
        binding.tvUpdateTime.text = binding.tvUpdateTime.text.toString() + data.update
    }
}