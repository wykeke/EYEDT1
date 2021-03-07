package com.kotlin.usercenter.presenter

import com.kotlin.baselibrary.ext.execute
import com.kotlin.baselibrary.presenter.BasePresenter
import com.kotlin.baselibrary.rx.BaseSubscriber
import com.kotlin.usercenter.presenter.view.RegisterView
import com.kotlin.usercenter.service.impl.UserServiceImpl
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers

open class RegisterPresenter: BasePresenter<RegisterView>() {

    fun register(moblie:String,verifyCode:String,pwd:String){
        /*
        业务逻辑
         */

        val userService = UserServiceImpl()
        userService.register(moblie,verifyCode, pwd)
            .execute(object :BaseSubscriber<Boolean>(){
                override fun onNext(t: Boolean) {
                    mView.onRegisterResult(t)
                }
            })
    }

    fun login(moblie:String,pwd:String){
        /*
        业务逻辑
         */

        val userService = UserServiceImpl()
        userService.register(moblie,"",pwd)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe(object: BaseSubscriber<Boolean>(){
                override fun onNext(t: Boolean) {
                    mView.onRegisterResult(t)
                }
            })

    }

}