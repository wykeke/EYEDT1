package com.example.eyedt.ui.adapter

import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class PageAdapter(
    fm: FragmentManager?,
    var list: List<Fragment>,
    var titles: List<String>
): FragmentPagerAdapter(fm!!) {
    //PageAdapter用于适配viewpage

    //返回list对应的position的fragment
    override fun getItem(position: Int): Fragment {
        return list[position]
    }

    override fun getCount(): Int {
        return list.size
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return titles[position]
    }

    override fun destroyItem(container: View, position: Int, `object`: Any) {
//        super.destroyItem(container, position, `object`)
    }
}