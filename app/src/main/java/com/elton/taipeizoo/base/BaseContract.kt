package com.elton.taipeizoo.base

interface BaseContract {
    interface IBaseView {
        fun setToolBar(title: String, returnable: Boolean)
    }
    interface IBasePresenter<in V: IBaseView> {
        fun attachView(view: V)
        fun detachView()
    }
}