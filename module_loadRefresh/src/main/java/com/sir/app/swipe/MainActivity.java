package com.sir.app.swipe;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;


import com.sir.app.base.BaseActivity;
import com.sir.app.refresh.OnLoadMoreListener;
import com.sir.app.refresh.OnRefreshListener;
import com.sir.app.refresh.SwipeToLoadLayout;

public class MainActivity extends BaseActivity implements OnRefreshListener, OnLoadMoreListener {


    SwipeToLoadLayout swipeToLoadLayout;

    RecyclerView recycleView;

    MyAdapter adapter;

    @Override
    public int bindLayout() {
        return R.layout.activity_main;
    }

    @Override
    public void initView(Bundle savedInstanceState) {
        recycleView = (RecyclerView) findViewById(R.id.swipe_target);
        swipeToLoadLayout = (SwipeToLoadLayout) findViewById(R.id.swipeToLoadLayout);
    }

    @Override
    public void doBusiness(Context mContext) {
        swipeToLoadLayout.setOnRefreshListener(this);
        swipeToLoadLayout.setOnLoadMoreListener(this);


        adapter = new MyAdapter(this);
        adapter.addItem("2333333333");
        adapter.addItem("233333333333334");
        adapter.addItem("4444444444444");
        adapter.addItem("44444444444444");
        adapter.addItem("55555555555");
        adapter.addItem("666666666666666");
        recycleView.setLayoutManager(new LinearLayoutManager(this));
        recycleView.setAdapter(adapter);
    }


    @Override
    public void onRefresh() {
        Log.e("tag", "onRefresh");
        swipeToLoadLayout.postDelayed(new Runnable() {
            @Override
            public void run() {
                adapter.addItem(0, "1222222");
                swipeToLoadLayout.setRefreshing(false);
            }
        }, 2000);
    }

    @Override
    public void onLoadMore() {
        Log.e("tag", "onLoadMore");
        swipeToLoadLayout.postDelayed(new Runnable() {
            @Override
            public void run() {
                adapter.addItem("22222222222");
                swipeToLoadLayout.setLoadingMore(false);
            }
        }, 2000);
    }

}
