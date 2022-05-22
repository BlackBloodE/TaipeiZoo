package com.elton.taipeizoo.presenter

import com.elton.taipeizoo.api.data.ZooData
import com.elton.taipeizoo.base.BasePresenter
import com.elton.taipeizoo.contract.ZooContract
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ZooPresenter : BasePresenter<ZooContract.IZooView>(), ZooContract.IZooPresenter {
    private lateinit var result: ZooData

    override fun loadZooData(isFirst: Boolean) {
        if (isFirst) {
            launch {
                try {
                    val resultData = apiInterface.getZoomList()
                    if (resultData.isSuccessful) {
                        result = resultData.body()!!
                        for (results in result.result.results) {
                            if (results.e_memo.isEmpty()) {
                                results.e_memo = "無休館資訊"
                            }
                        }

                        withContext(Dispatchers.Main) {
                            mView!!.closeProgress()
                            mView!!.setRecyclerView(result.result.results)
                            changeLoadStatus()
                        }
                    } else {
                        var errMsg = "Load failed\n\n"
                        errMsg += "Code: ${resultData.code()}\n"
                        errMsg += "Message: ${resultData.message()}"

                        withContext(Dispatchers.Main) {
                            mView!!.closeProgress()
                            mView!!.showLoadStatus(errMsg)
                        }
                    }
                } catch (e: Exception) {
                    e.printStackTrace()
                    val errMsg = "Load failed\nPlease check your network status"

                    withContext(Dispatchers.Main) {
                        mView!!.closeProgress()
                        mView!!.showLoadStatus(errMsg)
                    }
                }
            }
        } else {
            mView!!.setRecyclerView(result.result.results)
            mView!!.closeProgress()
            changeLoadStatus()
        }
    }

    private fun changeLoadStatus() {
        if (result.result.results.size == 0) {
            mView!!.showLoadStatus("No Data")
        } else {
            mView!!.showLoadStatus("")
        }
    }
}