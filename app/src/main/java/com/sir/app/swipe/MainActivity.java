package com.sir.app.swipe;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.sir.library.base.BaseActivity;
import com.sir.library.refresh.OnLoadMoreListener;
import com.sir.library.refresh.OnRefreshListener;
import com.sir.library.refresh.SwipeToLoadLayout;
import com.sir.library.refresh.view.LoadStateLayout;

import butterknife.BindView;


public class MainActivity extends BaseActivity implements OnRefreshListener, OnLoadMoreListener {


    MyAdapter adapter;
    @BindView(R.id.swipe_recycler_view)
    RecyclerView swipeRecyclerView;
    @BindView(R.id.swipe_load_layout)//必须这个文件ID
    SwipeToLoadLayout swipeLoadLayout;
    @BindView(R.id.loading_state_layout)
    LoadStateLayout loadingStateLayout;

    @Override
    public int bindLayout() {
        return R.layout.activity_main;
    }

    @Override
    public void initView(Bundle savedInstanceState) {

    }

    @Override
    public void doBusiness(Context mContext) {
        swipeLoadLayout.setOnRefreshListener(this);
        swipeLoadLayout.setOnLoadMoreListener(this);

        adapter = new MyAdapter(this);
        swipeRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        adapter.addItem("2333333333");
        adapter.addItem("233333333333334");
        adapter.addItem("4444444444444");
        adapter.addItem("44444444444444");
        adapter.addItem("55555555555");
        adapter.addItem("2333333333");
        adapter.addItem("233333333333334");
        adapter.addItem("4444444444444");
        adapter.addItem("44444444444444");
        adapter.addItem("55555555555");
        adapter.addItem("55555555555");
        adapter.addItem("666666666666666");


        loadingStateLayout.showProgressView();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                swipeRecyclerView.setAdapter(adapter);
                loadingStateLayout.showContentView();
            }
        }, 2000);
    }


    @Override
    public void onRefresh() {
        swipeLoadLayout.postDelayed(new Runnable() {
            @Override
            public void run() {
                adapter.addItem(0, "1222222");
                swipeLoadLayout.setRefreshing(false);
            }
        }, 2000);
    }

    @Override
    public void onLoadMore() {
        swipeLoadLayout.postDelayed(new Runnable() {
            @Override
            public void run() {
                adapter.addItem("22222222222");
                swipeLoadLayout.setLoadingMore(false);
            }
        }, 2000);
    }
}
