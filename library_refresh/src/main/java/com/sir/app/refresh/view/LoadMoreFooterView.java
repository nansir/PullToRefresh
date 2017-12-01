package com.sir.app.refresh.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.sir.app.refresh.R;
import com.sir.app.refresh.SwipeLoadMoreFooterLayout;


public class LoadMoreFooterView extends SwipeLoadMoreFooterLayout {

    private TextView tvLoadMore;
    private ImageView ivSuccess;
    private ProgressBar progressBar;
    private Context mContext;
    private int mFooterHeight;

    public LoadMoreFooterView(Context context) {
        this(context, null);
    }

    public LoadMoreFooterView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public LoadMoreFooterView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mFooterHeight = getResources().getDimensionPixelOffset(R.dimen.load_more_footer_height);
        mContext = context;
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        tvLoadMore = (TextView) findViewById(R.id.tv_load_more);
        ivSuccess = (ImageView) findViewById(R.id.iv_success);
        progressBar = (ProgressBar) findViewById(R.id.progressbar);
    }

    @Override
    public void onPrepare() {
        ivSuccess.setVisibility(GONE);
    }

    @Override
    public void onMove(int y, boolean isComplete, boolean automatic) {
        if (!isComplete) {
            ivSuccess.setVisibility(GONE);
            progressBar.setVisibility(GONE);
            if (-y >= mFooterHeight) {
                tvLoadMore.setText(mContext.getString(R.string.release_to_load_more));
            } else {
                tvLoadMore.setText(mContext.getString(R.string.swipe_to_load_more));
            }
        }
    }

    @Override
    public void onLoadMore() {
        tvLoadMore.setText(mContext.getString(R.string.loading_more));
        progressBar.setVisibility(VISIBLE);
    }

    @Override
    public void onRelease() {

    }

    @Override
    public void onComplete() {
        progressBar.setVisibility(GONE);
        ivSuccess.setVisibility(VISIBLE);
    }

    @Override
    public void onReset() {
        ivSuccess.setVisibility(GONE);
    }
}
