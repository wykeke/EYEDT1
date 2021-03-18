package com.example.eyedt.ui.adapter

import android.content.Context
import android.view.View
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.example.eyedt.R
import com.example.eyedt.ui.fragment.List_Fragment

class List_Adapter(layoutResId: Int, data: List<Bean_mainList?>?) :
    BaseQuickAdapter<Bean_mainList?, BaseViewHolder?>(layoutResId, data) {

     //绑定数据
    override fun convert(helper: BaseViewHolder?, item: Bean_mainList?) {
//         helper?.setText(R.id.item_name,item?.name)
//         try{
//             Glide.with(mContext).load(item?.imgUrl).into(helper?.getView(R.id.item_img))
//
//             Log.d("testt","加载成功")
//         }catch (e : Throwable){
//             Log.d("testt","错误")
//         }finally {
//
//         }

         helper?.setText(R.id.item_name, item?.name)
         Glide.with(mContext).load(item?.imgUrl)
             .diskCacheStrategy(DiskCacheStrategy.ALL)
             .error(R.drawable.eye)  //异常时显示的图片
             .placeholder(R.drawable.phone) //加载成功前显示的图片
             .fallback(R.drawable.backgrand) // url为空时显示的图片
//             .centerCrop()//圆
             .into(helper?.getView<View>(R.id.item_img) as ImageView)

     }

}