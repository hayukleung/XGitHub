package com.hayukleung.xgithub.view.main;

import com.hayukleung.xgithub.R;
import com.hayukleung.xgithub.view.profile.ProfileFragment;
import com.hayukleung.xgithub.view.star.StarFragment;
import com.hayukleung.xgithub.view.trending.TrendingFragment;

/**
 * 配置模块入口
 *
 * MainTab2.java
 * <p>
 * Created by hayukleung on 1/15/16.
 */
public enum MainTab {

  // 第0模块
  _0(0, R.string.tab_0, R.drawable.selector_tab_0, TrendingFragment.class), // 第1模块
  _1(1, R.string.tab_1, R.drawable.selector_tab_1, StarFragment.class), // 第2模块
  _2(2, R.string.tab_2, R.drawable.selector_tab_2, ProfileFragment.class);

  private int idx;
  private int resName;
  private int resIcon;
  private Class<?> clz;

  MainTab(int idx, int resName, int resIcon, Class<?> clz) {
    this.idx = idx;
    this.resName = resName;
    this.resIcon = resIcon;
    this.clz = clz;
  }

  public int getIdx() {
    return idx;
  }

  public void setIdx(int idx) {
    this.idx = idx;
  }

  public int getResName() {
    return resName;
  }

  public void setResName(int resName) {
    this.resName = resName;
  }

  public int getResIcon() {
    return resIcon;
  }

  public void setResIcon(int resIcon) {
    this.resIcon = resIcon;
  }

  public Class<?> getClz() {
    return clz;
  }

  public void setClz(Class<?> clz) {
    this.clz = clz;
  }
}
