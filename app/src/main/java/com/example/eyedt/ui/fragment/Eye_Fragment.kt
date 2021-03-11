package com.example.eyedt.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.example.eyedt.R
import com.google.android.material.tabs.TabLayout

class Eye_Fragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.eye_fragment, container, false)
        val viewPager = view.findViewById<ViewPager2>(R.id.Viewpager)
        val TabLayout = view.findViewById<TabLayout>(R.id.tab)
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        initWidget()
    }

    //初始化控件
    private fun initWidget(){

    }
}