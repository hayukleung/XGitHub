package com.hayukleung.xgithub.view.main;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TabHost;
import android.widget.TextView;
import butterknife.BindView;
import com.hayukleung.xgithub.R;
import com.hayukleung.xgithub.di.HasComponent;
import com.hayukleung.xgithub.di.component.DaggerMainComponent;
import com.hayukleung.xgithub.di.component.MainComponent;
import com.hayukleung.xgithub.di.module.ActivityModule;
import com.hayukleung.xgithub.presenter.MainPresenter;
import com.hayukleung.xgithub.view.XFragment;
import javax.inject.Inject;

/**
 * XGitHub
 * com.hayukleung.xgithub.view.main
 * MainFragment.java
 *
 * by hayukleung
 * at 2017-04-03 16:25
 */

public class MainFragment extends XFragment implements MainView, HasComponent<MainComponent> {

  @Inject protected MainPresenter mPresenter;
  /**
   * FragmentTabHost
   */
  @BindView(android.R.id.tabhost) Footer mFooter;

  @Override public void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    getComponent().inject(this);
    mPresenter.attachView(this);
  }

  @Override public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
    initView();
  }

  @Override public void onDestroy() {
    mPresenter.detachView();
    super.onDestroy();
  }

  /**
   * 初始化组件
   */
  private void initView() {
    // 找到TabHost
    mFooter.setup(getActivity(), getActivity().getSupportFragmentManager(), R.id.real_tab_content);
    mFooter.getTabWidget().setShowDividers(0);

    initTabs();

    mFooter.setCurrentTab(0);
    mFooter.setOnTabChangedListener(new TabHost.OnTabChangeListener() {
      @Override public void onTabChanged(String tabId) {

        final int size = mFooter.getTabWidget().getTabCount();
        for (int i = 0; i < size; i++) {
          View v = mFooter.getTabWidget().getChildAt(i);
          if (i == mFooter.getCurrentTab()) {
            v.setSelected(true);
          } else {
            v.setSelected(false);
          }
        }
        getActivity().supportInvalidateOptionsMenu();
      }
    });
  }

  /**
   * 初始化选项卡
   */
  private void initTabs() {
    // 设置首页模块
    MainTab[] tabs = MainTab.values();
    final int size = tabs.length;
    for (int i = 0; i < size; i++) {
      MainTab mainTab = tabs[i];
      TabHost.TabSpec tab = mFooter.newTabSpec(getString(mainTab.getResName()));
      View indicator = LayoutInflater.from(getActivity().getApplicationContext())
          .inflate(R.layout.item_tab_host, null);
      TextView title = (TextView) indicator.findViewById(R.id.tab);
      Drawable drawable = this.getResources().getDrawable(mainTab.getResIcon());
      title.setCompoundDrawablesWithIntrinsicBounds(null, drawable, null, null);
      title.setText(getString(mainTab.getResName()));
      tab.setIndicator(indicator);
      tab.setContent(new TabHost.TabContentFactory() {

        @Override public View createTabContent(String tag) {
          return new View(getActivity());
        }
      });
      mFooter.addTab(tab, mainTab.getClz(), null);

      mFooter.getTabWidget().getChildAt(i).setOnTouchListener(new View.OnTouchListener() {
        @Override public boolean onTouch(View v, MotionEvent event) {
          // TODO
          return false;
        }
      });
    }
  }

  @Override public MainComponent getComponent() {
    return DaggerMainComponent.builder()
        .appComponent(getBaseActivity().getAppComponent())
        .activityModule(new ActivityModule(getBaseActivity()))
        .build();
  }

  @Nullable @Override
  public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
      @Nullable Bundle savedInstanceState) {
    return super.onCreateView(inflater, container, savedInstanceState);
  }

  @Override protected int getContentView() {
    return R.layout.content_main;
  }

  @Override protected View.OnClickListener getRetryListener() {
    return null;
  }
}
