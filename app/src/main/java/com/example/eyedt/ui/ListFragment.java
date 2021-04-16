//package com.example.eyedt.ui;
//
//import android.os.Bundle;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.BaseAdapter;
//
//import androidx.annotation.NonNull;
//import androidx.annotation.Nullable;
//import androidx.fragment.app.Fragment;
//import androidx.recyclerview.widget.LinearLayoutManager;
//import androidx.recyclerview.widget.RecyclerView;
//import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
//
//import com.example.eyedt.R;
//
//public class ListFragment extends Fragment {
//    RecyclerView recyclerView;
//    SwipeRefreshLayout swipeRefreshLayout;
//
//    @Nullable
//    @Override
//    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        View root = inflater.inflate(R.layout.list_fragment,container,false);
//        return root;
//    }
//
//    @Override
//    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
//        recyclerView = view.findViewById(R.id.recyclerview);
//        swipeRefreshLayout = view.findViewById(R.id.swipeRefresh);
//
//        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
//            @Override
//            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
//                super.onScrollStateChanged(recyclerView, newState);
//            }
//
//            @Override
//            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
//                super.onScrolled(recyclerView, dx, dy);
//
//                int lastVisibleItem = ((LinearLayoutManager) mLayoutManager).findLastVisibleItemPosition();
//                int totalItemCount = mLayoutManager.getItemCount();//总条目
//                //lastVisibleItem >= totalItemCount - 5 表示剩下5个item实现预加载
//                // dy>0 表示向下滑动,滑动距离
//                if (totalItemCount >= 10 && lastVisibleItem >= totalItemCount - 5 && dy > 0) {
//
//                    if (mIsLoadingMore) {
//                        ToastUtils.showWithShort(getApplicationContext(), "已经预加载了!");
//                    } else {
//                        StartLoadMoreTask();//加载更多
//                    }
//                }
//            }
//        });
//    }
//}
