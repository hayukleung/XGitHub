package com.hayukleung.xgithub.view;

import android.os.Bundle;
import android.support.annotation.CallSuper;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import butterknife.ButterKnife;
import com.hayukleung.mvp.lce.LCEView;
import com.hayukleung.xgithub.R;

public abstract class XFragment<M> extends BaseFragment implements LCEView<M> {

  private LinearLayout mContentView;
  private RelativeLayout mEmptyView;
  private RelativeLayout mErrorView;
  private RelativeLayout mLoadingView;

  public XFragment() {
  }

  @Nullable @Override
  public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
      @Nullable Bundle savedInstanceState) {

    View baseView = inflater.inflate(R.layout.fragment_x, container, false);
    mContentView = (LinearLayout) baseView.findViewById(R.id.content_frame);
    mContentView.removeAllViews();
    mContentView.addView(inflater.inflate(getContentView(), null),
        new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.MATCH_PARENT));

    mEmptyView = (RelativeLayout) baseView.findViewById(R.id.empty_root_layout);
    mEmptyView.setVisibility(View.GONE);
    mErrorView = (RelativeLayout) baseView.findViewById(R.id.error_root_layout);
    mErrorView.findViewById(R.id.retry_btn).setOnClickListener(getRetryListener());
    mErrorView.setVisibility(View.GONE);
    mLoadingView = (RelativeLayout) baseView.findViewById(R.id.loading_layout);
    mLoadingView.setVisibility(View.GONE);

    ButterKnife.bind(this, mContentView);
    return baseView;
  }

  abstract protected int getContentView();

  abstract protected View.OnClickListener getRetryListener();

  @Override public void showLoading() {
    mContentView.setVisibility(View.GONE);
    mEmptyView.setVisibility(View.GONE);
    mErrorView.setVisibility(View.GONE);
    mLoadingView.setVisibility(View.VISIBLE);
  }

  @Override public void dismissLoading() {
    mLoadingView.setVisibility(View.GONE);
  }

  @CallSuper @Override public void showContent(M data) {
    dismissLoading();
    mEmptyView.setVisibility(View.GONE);
    mErrorView.setVisibility(View.GONE);
    mContentView.setVisibility(View.VISIBLE);
  }

  @Override public void showError(Throwable e) {
    dismissLoading();
    mContentView.setVisibility(View.GONE);
    mEmptyView.setVisibility(View.GONE);
    mErrorView.setVisibility(View.VISIBLE);
  }

  @Override public void showEmpty() {
    dismissLoading();
    mContentView.setVisibility(View.GONE);
    mErrorView.setVisibility(View.GONE);
    mEmptyView.setVisibility(View.VISIBLE);
  }
}
