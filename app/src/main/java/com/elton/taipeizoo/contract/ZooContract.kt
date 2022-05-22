package com.elton.taipeizoo.contract

import com.elton.taipeizoo.api.data.ZooResults
import com.elton.taipeizoo.base.BaseContract

interface ZooContract {
    interface IZooView : BaseContract.IBaseView {
        fun setRecyclerView(dataList: ArrayList<ZooResults>)
        fun showProgress()
        fun closeProgress()
        fun showLoadStatus(msg: String)
    }
    interface IZooPresenter : BaseContract.IBasePresenter<IZooView> {
        fun loadZooData(isFirst: Boolean)
    }
}