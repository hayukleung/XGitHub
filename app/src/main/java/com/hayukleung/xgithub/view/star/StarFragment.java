package com.hayukleung.xgithub.view.star;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import butterknife.BindView;
import com.hayukleung.xgithub.R;
import com.hayukleung.xgithub.contract.ContractStar.IPresenterStar;
import com.hayukleung.xgithub.model.Stub;
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

  @Override public void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
  }

  @Override public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);

    mSwipeRefreshLayout.setColorSchemeResources(R.color.colorPrimary);
    // mSwipeRefreshLayout.setProgressViewEndTarget(false, Screen.getInstance(getActivity()).dp2px(120));
    mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
      @Override public void onRefresh() {
      }
    });

    // mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
  }

  @Override protected int getContentView() {
    return R.layout.content_star;
  }

  @Override protected View.OnClickListener getRetryListener() {
    return null;
  }
}
