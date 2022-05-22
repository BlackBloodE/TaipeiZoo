package com.elton.taipeizoo.presenter

import com.elton.taipeizoo.contract.ZooInfoContract
import com.elton.taipeizoo.api.data.PlantResults
import com.elton.taipeizoo.base.BasePresenter
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ZooInfoPresenter :
    BasePresenter<ZooInfoContract.IZooInfoView>(),
    ZooInfoContract.IZooInfoPresenter {
    private var finalResults: ArrayList<PlantResults> = ArrayList()

    override fun loadPlantData(location: String, isFirst: Boolean) {
        if (isFirst) {
            launch {
                try {
                    val resultData = apiInterface.getPlantList()
                    if (resultData.isSuccessful) {
                        finalResults.clear()
                        for (results in resultData.body()!!.result.results) {
                            if (results.location.contains(location)) {
                                finalResults.add(results)
                            }
                        }

                        withContext(Dispatchers.Main) {
                            mView!!.setRecyclerView(finalResults)
                            mView!!.closeProgress()
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
            mView!!.setRecyclerView(finalResults)
            mView!!.closeProgress()
            changeLoadStatus()
        }
    }

    private fun changeLoadStatus() {
        if (finalResults.size == 0) {
            mView!!.showLoadStatus("No Data")
        } else {
            mView!!.showLoadStatus("")
        }
    }
}