package com.example.eyedt.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.eyedt.R
import com.example.eyedt.ui.fragment.Eye_Fragment
import com.example.eyedt.ui.fragment.Recovery_Fragment
import com.example.eyedt.ui.fragment.We_Fragment
import kotlinx.android.synthetic.main.activity_main.*
//import org.jetbrains.anko.toast

class MainActivity : AppCompatActivity() ,View.OnClickListener{

    val mEye_Fragment = Eye_Fragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction().add(R.id.fragment,mEye_Fragment).commit()

        v1.setOnClickListener(this)
        v2.setOnClickListener(this)
        v3.setOnClickListener(this)
    }

    override fun onClick(view: View?) {
        val fragmentManager = supportFragmentManager //获取FragmentManager实例
        val transaction = fragmentManager.beginTransaction() //开启一个事物
        var f : Fragment? = null
        when(view?.id) {
            R.id.v1 -> {
                //如果不是主界面则切换到主界面，
                f = Eye_Fragment()
            }
            R.id.v2 -> f = Recovery_Fragment()
            R.id.v3 -> f = We_Fragment()
        }

        //切换
        if (f != null) {
            transaction.replace(R.id.fragment,f)
        }
        transaction.commit() //提交事务
    }

}