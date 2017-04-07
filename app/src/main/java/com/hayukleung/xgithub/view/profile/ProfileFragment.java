package com.hayukleung.xgithub.view.profile;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.OnClick;
import com.hayukleung.xgithub.R;
import com.hayukleung.xgithub.common.wrapper.XImage;
import com.hayukleung.xgithub.contract.ContractProfile;
import com.hayukleung.xgithub.di.HasComponent;
import com.hayukleung.xgithub.di.component.DaggerProfileComponent;
import com.hayukleung.xgithub.di.component.ProfileComponent;
import com.hayukleung.xgithub.di.module.ActivityModule;
import com.hayukleung.xgithub.model.GitHub;
import com.hayukleung.xgithub.presenter.PresenterProfile;
import com.hayukleung.xgithub.view.UIUtils;
import com.hayukleung.xgithub.view.XFragment;
import com.trello.rxlifecycle2.android.FragmentEvent;
import javax.inject.Inject;

/**
 * XGitHub
 * com.hayukleung.xgithub.view.profile
 * ProfileFragment.java
 *
 * by hayukleung
 * at 2017-04-03 20:53
 */

public class ProfileFragment extends XFragment<GitHub, ContractProfile.IPresenterProfile>
    implements ProfileView, HasComponent<ProfileComponent> {

  @Inject protected PresenterProfile mPresenterProfile;

  @BindView(R.id.collapsing_toolbar) CollapsingToolbarLayout mCollapsingToolbar;
  @BindView(R.id.bar_layout) AppBarLayout mBarLayout;
  @BindView(R.id.toolbar) Toolbar mToolbar;
  @BindView(R.id.icon) ImageView mIcon;
  @BindView(R.id.bg) ImageView mBg;
  @BindView(R.id.name) TextView mName;
  @BindView(R.id.layout_user) LinearLayout mLayoutUser;
  @BindView(R.id.header) RelativeLayout mHeader;
  @BindView(R.id.scrollable_layout) CoordinatorLayout mScrollableLayout;
  @BindView(R.id.title) TextView mTitleView;
  @BindView(R.id.action) ImageView mRightView;
  @BindView(R.id.recycler_view) RecyclerView mRecyclerView;

  @Override public void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    getComponent().inject(this);
    mPresenterProfile.attachView(this);
  }

  @Override public ProfileComponent getComponent() {
    return DaggerProfileComponent.builder()
        .appComponent(getBaseActivity().getAppComponent())
        .activityModule(new ActivityModule(getBaseActivity()))
        .build();
  }

  @Override public void onResume() {
    super.onResume();
    UIUtils.requestStatusBarLight(this, true, getResources().getColor(R.color.colorPrimary));
  }

  @Override protected int getContentView() {
    return R.layout.content_profile;
  }

  @Override protected View.OnClickListener getRetryListener() {
    return null;
  }

  @Override public void showContent(GitHub data) {
    super.showContent(data);

    XImage.load(getActivity(), data.getAvatar_url(), mIcon);
    mName.setText(data.getName());
  }

  @Override public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);

    // if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
    // ViewGroup.MarginLayoutParams params =
    // (ViewGroup.MarginLayoutParams) mToolbar.getLayoutParams();
    // params.topMargin = getSystemBarConfig().getStatusBarHeight();
    // mToolbar.setLayoutParams(params);
    // } else {
    // ViewGroup.LayoutParams params = getStatusBar().getLayoutParams();
    // params.height = getSystemBarConfig().getStatusBarHeight();
    // getStatusBar().setLayoutParams(params);
    // }

    ViewGroup.LayoutParams params = mToolbar.getLayoutParams();
    params.height += getSystemBarConfig().getStatusBarHeight();
    mToolbar.setLayoutParams(params);
    mToolbar.setPadding(0, mToolbar.getPaddingTop() + getSystemBarConfig().getStatusBarHeight(), 0,
        0);
    mLayoutUser.setPadding(0,
        mLayoutUser.getPaddingTop() + getSystemBarConfig().getStatusBarHeight(), 0, 0);

    mRecyclerView.setLayoutManager(
        new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
    mRecyclerView.setAdapter(new ProfileAdapter());

    mPresenterProfile.request(getGitHubApiModule(), bindUntilEvent(FragmentEvent.PAUSE));
  }

  @Override public void onDestroy() {
    mPresenterProfile.detachView();
    super.onDestroy();
  }

  @Override public void onActivityCreated(@Nullable Bundle savedInstanceState) {
    super.onActivityCreated(savedInstanceState);
  }

  @OnClick({}) void onClick(View view) {

  }
}
