package com.sir.app.swipe;

import android.content.Context;
import android.os.Bundle;
import android.widget.TextView;

import com.sir.app.base.BaseActivity;
import com.sir.app.refresh.OnLoadMoreListener;
import com.sir.app.refresh.OnRefreshListener;
import com.sir.app.refresh.SwipeToLoadLayout;

/**
 * Created by zhuyinan on 2017/12/1.
 * Contact by 445181052@qq.com
 */
public class TextActivity extends BaseActivity implements OnRefreshListener, OnLoadMoreListener {

    private SwipeToLoadLayout swipeToLoadLayout;
    private TextView tvTitle;

    @Override
    public int bindLayout() {
        return R.layout.activity_textview;
    }

    @Override
    public void initView(Bundle savedInstanceState) {
        swipeToLoadLayout = (SwipeToLoadLayout) findViewById(R.id.swipeToLoadLayout);
    }

    @Override
    public void doBusiness(Context mContext) {
        swipeToLoadLayout.setOnRefreshListener(this);
        swipeToLoadLayout.setOnLoadMoreListener(this);
    }


    @Override
    public void onRefresh() {
        swipeToLoadLayout.postDelayed(new Runnable() {
            @Override
            public void run() {
                swipeToLoadLayout.setRefreshing(false);
            }
        }, 2000);
    }

    @Override
    public void onLoadMore() {
        swipeToLoadLayout.postDelayed(new Runnable() {
            @Override
            public void run() {
                swipeToLoadLayout.setLoadingMore(false);
            }
        }, 2000);
    }
}
