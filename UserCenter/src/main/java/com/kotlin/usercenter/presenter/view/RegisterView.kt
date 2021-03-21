package com.kotlin.usercenter.presenter.view

import com.kotlin.baselibrary.presenter.view.BaseView

interface RegisterView: BaseView {
    fun onRegisterResult(result:Boolean)
}