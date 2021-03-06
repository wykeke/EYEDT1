package com.kotlin.usercenter.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.kotlin.baselibrary.ui.activity.BaseMvpActivity
import com.kotlin.usercenter.R
import com.kotlin.usercenter.presenter.RegisterPresenter
import com.kotlin.usercenter.presenter.view.RegisterView
import kotlinx.android.synthetic.main.activity_register.*
import org.jetbrains.anko.toast


class RegisterActivity : BaseMvpActivity<RegisterPresenter>(), RegisterView {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        mPresenter= RegisterPresenter()
        mPresenter.mView=this
        Submit.setOnClickListener {
            mPresenter.register("","","")
        }
    }

    override fun onRegisterResult(result: Boolean) {
        toast("注册成功")
    }
}