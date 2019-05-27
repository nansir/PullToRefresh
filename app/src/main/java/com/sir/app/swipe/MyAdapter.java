package com.sir.app.swipe;

import android.app.Activity;

import com.sir.library.base.BaseRecyclerAdapter;
import com.sir.library.base.help.ViewHolder;

/**
 * Created by zhuyinan on 2017/7/7.
 * Contact by 445181052@qq.com
 */
public class MyAdapter extends BaseRecyclerAdapter<String> {

    public MyAdapter(Activity mContext) {
        super(mContext);
    }

    @Override
    public int bindLayout() {
        return R.layout.adpter_item;
    }

    @Override
    public void onBindHolder(ViewHolder holder, int position) {
        String bean = getItem(position);
        holder.setText(R.id.name, bean);
    }
}
