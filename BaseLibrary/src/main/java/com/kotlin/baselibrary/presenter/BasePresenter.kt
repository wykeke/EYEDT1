package com.kotlin.baselibrary.presenter

import com.kotlin.baselibrary.presenter.view.BaseView

open class BasePresenter<T: BaseView> {
    lateinit var mView:T
}