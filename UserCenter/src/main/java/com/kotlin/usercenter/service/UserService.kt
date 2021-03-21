package com.kotlin.usercenter.service

interface UserService {
    fun register(mobile:String,verifyCode:String,pwd:String): rx.Observable<Boolean>
}