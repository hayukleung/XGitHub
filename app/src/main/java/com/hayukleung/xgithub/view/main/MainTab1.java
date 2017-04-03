package com.hayukleung.xgithub.view.main;

import com.hayukleung.xgithub.R;

/**
 * 配置模块入口
 *
 * MainTab2.java
 * <p>
 * Created by hayukleung on 1/15/16.
 */
public enum MainTab1 {

  /** 第0模块 */
  _0(0, R.string.tab_0, R.drawable.selector_tab_0, Fragment0.class), /** 第1模块 */
  _1(1, R.string.tab_1, R.drawable.selector_tab_1, Fragment1.class), /** 第2模块 */
  _2(2, R.string.tab_2, R.drawable.selector_tab_2, Fragment2.class), /** 第3模块 */
  _3(3, R.string.tab_3, R.drawable.selector_tab_3, Fragment3.class), /** 第4模块 */
  _4(4, R.string.tab_4, R.drawable.selector_tab_4, Fragment4.class);

  private int idx;
  private int resName;
  private int resIcon;
  private Class<?> clz;

  MainTab1(int idx, int resName, int resIcon, Class<?> clz) {
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
