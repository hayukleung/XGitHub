package com.hayukleung.xgithub.view.star;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewGroup;
import butterknife.BindView;
import com.hayukleung.xgithub.R;
import com.hayukleung.xgithub.common.RecyclerViewUtils;
import com.hayukleung.xgithub.common.wrapper.XLog;
import com.hayukleung.xgithub.contract.ContractStar.IPresenterStar;
import com.hayukleung.xgithub.model.Stub;
import com.hayukleung.xgithub.view.UIUtils;
import com.hayukleung.xgithub.view.XFragment;

/**
 * XGitHub
 * com.hayukleung.xgithub.view.star
 * StarFragment.java
 *
 * by hayukleung
 * at 2017-04-03 20:52
 */

public class StarFragment extends XFragment<Stub, IPresenterStar> implements StarView {

  @BindView(R.id.swipe_refresh_layout) SwipeRefreshLayout mSwipeRefreshLayout;
  @BindView(R.id.recycler_view) RecyclerView mRecyclerView;
  @BindView(R.id.toolbar) Toolbar mToolbar;

  private StarAdapter mStarAdapter;

  private int mLatestAlpha = 0;
  private int mScrolledY = 0;

  @Override public void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
  }

  @Override public void onResume() {
    super.onResume();
    UIUtils.requestStatusBarLight(this, 0 != mLatestAlpha,
        getResources().getColor(R.color.colorPrimary));
  }

  @Override protected int getContentView() {
    return R.layout.content_star;
  }

  @Override protected View.OnClickListener getRetryListener() {
    return null;
  }

  @Override public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);

    //    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
    //      ViewGroup.MarginLayoutParams params =
    //          (ViewGroup.MarginLayoutParams) mToolbar.getLayoutParams();
    //      params.topMargin = getSystemBarConfig().getStatusBarHeight();
    //      mToolbar.setLayoutParams(params);
    //    } else {
    //      ViewGroup.LayoutParams params = getStatusBar().getLayoutParams();
    //      params.height = getSystemBarConfig().getStatusBarHeight();
    //      getStatusBar().setLayoutParams(params);
    //    }

    ViewGroup.LayoutParams params = mToolbar.getLayoutParams();
    params.height += getSystemBarConfig().getStatusBarHeight();
    mToolbar.setLayoutParams(params);
    mToolbar.setPadding(0, mToolbar.getPaddingTop() + getSystemBarConfig().getStatusBarHeight(), 0,
        0);

    mSwipeRefreshLayout.setColorSchemeResources(R.color.colorPrimary);
    // mSwipeRefreshLayout.setProgressViewEndTarget(false, Screen.getInstance(getActivity()).dp2px(120));
    mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
      @Override public void onRefresh() {
      }
    });

    mRecyclerView.setLayoutManager(
        new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
    mStarAdapter = new StarAdapter();
    mRecyclerView.setAdapter(mStarAdapter);
    mRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {

      @Override public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
        super.onScrollStateChanged(recyclerView, newState);
      }

      @Override public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
        mScrolledY += dy;
        XLog.e("scrolledY --> " + mScrolledY);
        int scrollY = RecyclerViewUtils.getRecyclerViewScrollY(mRecyclerView);
        int toolbarHeight = mToolbar.getHeight();
        int alpha = (int) ((float) scrollY / toolbarHeight * 255);
        if (alpha > 255) alpha = 255;
        if (alpha < 0) alpha = 0;
        if (mScrolledY > mStarAdapter.getStarHeaderHeight(getActivity()) - mToolbar.getHeight()) {
          alpha = 255;
        }
        if (alpha == 0) {
          UIUtils.requestStatusBarLight(StarFragment.this, false,
              getResources().getColor(R.color.colorPrimary));
        } else {
          UIUtils.requestStatusBarLight(StarFragment.this, true,
              getResources().getColor(R.color.colorPrimary));
        }
        mToolbar.setBackgroundColor(Color.argb(alpha, 255, 255, 255));
        mLatestAlpha = alpha;
      }
    });
  }
}
