package com.elton.taipeizoo.base

import com.elton.taipeizoo.api.APIInterface
import com.elton.taipeizoo.api.APIManager
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.cancel
import kotlin.coroutines.CoroutineContext

open class BasePresenter<V : BaseContract.IBaseView> : BaseContract.IBasePresenter<V>, CoroutineScope {
    protected val apiInterface: APIInterface = APIManager.client.create(APIInterface::class.java)
    private val job = Job()
    override val coroutineContext: CoroutineContext = job + Dispatchers.IO

    var mView: V? = null
        private set

    override fun attachView(view: V) {
        this.mView = view
    }

    override fun detachView() {
        job.cancel()
        cancel()
        mView = null
    }
}