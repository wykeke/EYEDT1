package com.example.eyedt.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.eyedt.R
import com.example.eyedt.ui.adapter.Bean_mainList
import com.example.eyedt.ui.adapter.List_Adapter
import kotlinx.android.synthetic.main.list_fragment.*
import org.jetbrains.anko.support.v4.runOnUiThread
import kotlin.concurrent.thread

class List_Fragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    var list = ArrayList<Bean_mainList>()  //存放展示的图片和文字列表

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.list_fragment, container, false)
        recyclerView = view.findViewById(R.id.recyclerview)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        initList()

        val layoutManager = GridLayoutManager(context,2)  //设置排布方式
        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = List_Adapter(
            R.layout.list_item,
            list
        )//适配器

        swipeRefresh.setOnRefreshListener {
            Toast.makeText(context,"刷新",Toast.LENGTH_SHORT).show()
            refresh(recyclerView.adapter as List_Adapter)
        }
    }

    private fun initList(){
        val item1 = Bean_mainList(
            "AAAAA",
            "https://ss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=2676935521,922112450&fm=11&gp=0.jpg"
        )
        list.add(item1)
        list.add(item1)

        val item2 = Bean_mainList(
            "BBBBB",
            "https://ss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=3824886304,665215047&fm=26&gp=0.jpg"
        )
        list.add(item2)
        list.add(item2)

    }

    //刷新
    private fun refresh(adapter: List_Adapter) {
        thread {
            Thread.sleep(2000)
            runOnUiThread {
                initList()
                adapter.notifyDataSetChanged()
                swipeRefresh.isRefreshing = false
            } }
    }
}