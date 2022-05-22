package com.elton.taipeizoo.contract

import com.elton.taipeizoo.api.data.PlantResults
import com.elton.taipeizoo.base.BaseContract

interface ZooInfoContract {
    interface IZooInfoView : BaseContract.IBaseView {
        fun setRecyclerView(dataList: ArrayList<PlantResults>)
        fun showProgress()
        fun closeProgress()
        fun showLoadStatus(msg: String)
    }
    interface IZooInfoPresenter : BaseContract.IBasePresenter<IZooInfoView> {
        fun loadPlantData(location: String, isFirst: Boolean)
    }
}