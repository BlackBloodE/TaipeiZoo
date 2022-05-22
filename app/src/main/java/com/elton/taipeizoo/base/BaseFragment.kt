package com.elton.taipeizoo.base

import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import com.elton.taipeizoo.R
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.cancel
import kotlin.coroutines.CoroutineContext

open class BaseFragment : Fragment(), CoroutineScope, BaseContract.IBaseView {

    private val job = Job()
    override val coroutineContext: CoroutineContext = job + Dispatchers.Main

    override fun setToolBar(title: String, returnable: Boolean) {
        val toolbar = activity?.findViewById<Toolbar>(R.id.toolbar)
        toolbar?.title = title

        if (returnable) {
            toolbar?.setNavigationIcon(R.drawable.ic_baseline_arrow_back_24)
            toolbar?.setNavigationOnClickListener {
                activity?.onBackPressed()
            }
        } else {
            toolbar?.setNavigationIcon(R.drawable.ic_baseline_menu_24)
        }
    }

    override fun onDestroy() {
        job.cancel()
        cancel()
        super.onDestroy()
    }
}