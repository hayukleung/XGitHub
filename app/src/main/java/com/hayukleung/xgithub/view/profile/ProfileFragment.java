package com.hayukleung.xgithub.view.profile;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import butterknife.BindView;
import butterknife.OnClick;
import com.hayukleung.xgithub.R;
import com.hayukleung.xgithub.di.HasComponent;
import com.hayukleung.xgithub.di.component.DaggerProfileComponent;
import com.hayukleung.xgithub.di.component.ProfileComponent;
import com.hayukleung.xgithub.di.module.ActivityModule;
import com.hayukleung.xgithub.model.GitHub;
import com.hayukleung.xgithub.presenter.ProfilePresenter;
import com.hayukleung.xgithub.view.XFragment;
import javax.inject.Inject;

/**
 * XGitHub
 * com.hayukleung.xgithub.view.profile
 * ProfileFragment.java
 *
 * by hayukleung
 * at 2017-04-03 20:53
 */

public class ProfileFragment extends XFragment<GitHub>
    implements ProfileView, HasComponent<ProfileComponent> {

  @Inject protected ProfilePresenter mProfilePresenter;

  @BindView(R.id.collapsing_toolbar) CollapsingToolbarLayout mCollapsingToolbar;
  @BindView(R.id.bar_layout) AppBarLayout mBarLayout;
  @BindView(R.id.toolbar) Toolbar mToolbar;
  @BindView(R.id.icon) ImageView mIcon;
  @BindView(R.id.bg) ImageView mBg;
  @BindView(R.id.name) TextView mName;
  @BindView(R.id.user_layout) LinearLayout mUserLayout;
  @BindView(R.id.user_header_layout) RelativeLayout mUserHeaderLayout;
  @BindView(R.id.scrollable_layout) CoordinatorLayout mScrollableLayout;
  @BindView(R.id.title) TextView mTitleView;
  @BindView(R.id.action) ImageView mRightView;

  @Override public void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    getComponent().inject(this);
    mProfilePresenter.attachView(this);
  }

  @Override public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
    mProfilePresenter.request(getGitHubApiModule());
  }

  @Override public void onActivityCreated(@Nullable Bundle savedInstanceState) {
    super.onActivityCreated(savedInstanceState);
  }

  @Override public void onDestroy() {
    mProfilePresenter.detachView();
    super.onDestroy();
  }

  @Override public ProfileComponent getComponent() {
    return DaggerProfileComponent.builder()
        .appComponent(getBaseActivity().getAppComponent())
        .activityModule(new ActivityModule(getBaseActivity()))
        .build();
  }

  @Override protected int getContentView() {
    return R.layout.content_profile;
  }

  @Override protected View.OnClickListener getRetryListener() {
    return null;
  }

  @Override public void showContent(GitHub data) {
    super.showContent(data);
    Toast.makeText(getActivity(), "showContent", Toast.LENGTH_SHORT).show();
  }

  @OnClick({}) void onClick(View view) {

  }
}
