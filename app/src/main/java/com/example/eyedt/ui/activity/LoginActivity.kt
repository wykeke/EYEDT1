package com.example.eyedt.ui.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.eyedt.R
//import com.kotlin.usercenter.ui.activity.RegisterActivity
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        Login.setOnClickListener {
            val intent= Intent(this,MainActivity::class.java)
            startActivity(intent)
        }
//       SingIn.setOnClickListener {
//           val intent=Intent(this,RegisterActivity::class.java)
//           startActivity(intent)
//       }
    }
}