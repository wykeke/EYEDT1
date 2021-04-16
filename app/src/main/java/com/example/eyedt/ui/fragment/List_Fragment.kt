package com.example.eyedt.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.eyedt.R
import com.example.eyedt.ui.adapter.Bean_grid
import com.example.eyedt.ui.adapter.Bean_mainList
import com.example.eyedt.ui.adapter.List_Adapter
import kotlinx.android.synthetic.main.list_fragment.*
import org.jetbrains.anko.support.v4.runOnUiThread
import org.jetbrains.anko.support.v4.toast
import kotlin.concurrent.thread


class List_Fragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var gridView: GridView
    private var adapter: List_Adapter? = null

    var list = ArrayList<Bean_mainList>()  //存放展示的图片和文字列表

    //网格布局图片
    internal var imageIds = intArrayOf(R.drawable.love, R.drawable.love,
        R.drawable.love,R.drawable.love)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.list_fragment, container, false)
        recyclerView = view.findViewById(R.id.recyclerview)
//        gridView = view.findViewById(R.id.grid)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        initList()

        val layoutManager = GridLayoutManager(context,2)  //设置排布方式
        recyclerView.layoutManager = layoutManager
        adapter = List_Adapter(
            R.layout.list_item,
            list
        )//适配器
        recyclerView.adapter = adapter

        //添加头部
        val headerView = LayoutInflater.from(context).inflate(R.layout.list_header,null)
        adapter!!.addHeaderView(headerView)

        // 创建一个List对象，List对象的元素是Map
        val listItems = ArrayList<Map<String, Any>>()

        for (i in imageIds.indices)
        {
            val listItem = HashMap<String, Any>()
            listItem["image"] = imageIds[i]
            listItems.add(listItem)
        }

        val gridList: MutableList<Bean_grid> = java.util.ArrayList()
        for (i in 0..4){
            gridList.add(Bean_grid(
                "樱桃小丸子",
                "https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fcdn.duitang.com%2Fuploads%2Fitem%2F201410%2F20%2F20141020162058_UrMNe.jpeg&refer=http%3A%2F%2Fcdn.duitang.com&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=jpeg?sec=1620913801&t=ee2ff3e8f40b082221a141066b779bb6"
            ))
        }

        // 创建一个SimpleAdapter
        val simpleAdapter = SimpleAdapter(context, listItems, R.layout.grid_item,
            arrayOf("image"), intArrayOf(R.id.grid_img)) // 使用/layout/cell.xml文件作为界面布局

        gridView = headerView.findViewById(R.id.grid)
        gridView.adapter = simpleAdapter
        gridView.onItemSelectedListener = object : AdapterView.OnItemSelectedListener
        {
            override fun onItemSelected(parent: AdapterView<*>,
                                        view: View, position: Int, id: Long)
            {
                // 显示当前被选中的图片
                //imageView.setImageResource(imageIds[position])
            }

            override fun onNothingSelected(parent: AdapterView<*>)
            {
            }
        }
        //点击事件
        gridView.onItemClickListener = object:AdapterView.OnItemClickListener{
            override fun onItemClick(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                toast("点击了第${position}项,值为${imageIds[position]}")
            }
        }



//        val gridList: MutableList<Bean_grid> = java.util.ArrayList()
//        for (i in 0..4){
//            gridList.add(Bean_grid(
//                "樱桃小丸子",
//                "https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fcdn.duitang.com%2Fuploads%2Fitem%2F201410%2F20%2F20141020162058_UrMNe.jpeg&refer=http%3A%2F%2Fcdn.duitang.com&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=jpeg?sec=1620913801&t=ee2ff3e8f40b082221a141066b779bb6"
//            ))
//        }
        //val gAdapter = GridAdapter(context!!,gridList)
        //gridView.adapter = gAdapter


        //下拉刷新
        swipeRefresh.setOnRefreshListener {
            Toast.makeText(context,"下拉刷新",Toast.LENGTH_SHORT).show()
            refresh(recyclerView.adapter as List_Adapter)
        }

        //上滑刷新
        recyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrollStateChanged(
                recyclerView: RecyclerView,
                newState: Int
            ) {
                super.onScrollStateChanged(recyclerView, newState)
            }

            override fun onScrolled(
                recyclerView: RecyclerView,
                dx: Int,
                dy: Int
            ) {
                super.onScrolled(recyclerView, dx, dy)
                val lastVisibleItem = (layoutManager as LinearLayoutManager).findLastVisibleItemPosition()
                val totalItemCount: Int = layoutManager.itemCount //总条目
                //lastVisibleItem >= totalItemCount - 5 表示剩下5个item实现预加载
                // dy>0 表示向下滑动,滑动距离
                if (totalItemCount >= 8 && lastVisibleItem >= totalItemCount - 2 && dy > 0) {
                    Toast.makeText(context,"上滑刷新",Toast.LENGTH_SHORT).show()
                    refresh(recyclerView.adapter as List_Adapter)
                }
            }
        })

    }

    //添加列表数据
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