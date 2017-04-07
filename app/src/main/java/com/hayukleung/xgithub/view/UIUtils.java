package com.hayukleung.xgithub.view;

import android.os.Build;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * XGitHub
 * com.hayukleung.xgithub.view
 * UIUtils.java
 *
 * by hayukleung
 * at 2017-04-05 15:37
 */

public class UIUtils {

  public static boolean isWindowTranslucentStatus(FragmentActivity activity) {
    Window window = activity.getWindow();
    WindowManager.LayoutParams params = window.getAttributes();
    View decorView = window.getDecorView();
    return ((params.flags & WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
        == WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS) || (Build.VERSION.SDK_INT
        >= Build.VERSION_CODES.LOLLIPOP
        && (decorView.getSystemUiVisibility() & (View.SYSTEM_UI_FLAG_LAYOUT_STABLE
        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN)) == (View.SYSTEM_UI_FLAG_LAYOUT_STABLE
        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN));
  }

  /**
   * @param fragment
   * @param isLight true: 白色背景, 深色文字
   */
  public static void requestStatusBarLight(XFragment fragment, boolean isLight) {
    requestStatusBarLight(fragment, isLight, isLight ? 0xffcccccc : 0xffffffff);
  }

  /**
   * @param fragment
   * @param isLight 6.0及以上系统生效
   * @param color 6.0以下系统生效
   */
  public static void requestStatusBarLight(XFragment fragment, boolean isLight, int color) {
    View decorView = fragment.getActivity().getWindow().getDecorView();
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
      if (isLight) {
        decorView.setSystemUiVisibility(
            decorView.getSystemUiVisibility() | View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
      } else {
        decorView.setSystemUiVisibility(
            decorView.getSystemUiVisibility() & ~View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
      }
      processPrivateAPI(fragment.getActivity().getWindow(), isLight);
    } else {
      // TODO Android 6.0 以下系统适配
      // fragment.getStatusBar().setBackgroundColor(color);
    }
  }

  private static void processPrivateAPI(Window window, boolean lightStatusBar) {
    try {
      processFlyMe(window, lightStatusBar);
    } catch (Exception e) {
      try {
        processMIUI(window, lightStatusBar);
      } catch (Exception e2) {
        //
      }
    }
  }

  /**
   * 改变魅族的状态栏字体为黑色，要求 FlyMe 4 以上
   *
   * @param window
   * @param isLightStatusBar
   * @throws Exception
   */
  private static void processFlyMe(Window window, boolean isLightStatusBar) throws Exception {
    WindowManager.LayoutParams lp = window.getAttributes();
    Class<?> instance = Class.forName("android.view.WindowManager$LayoutParams");
    int value = instance.getDeclaredField("MEIZU_FLAG_DARK_STATUS_BAR_ICON").getInt(lp);
    Field field = instance.getDeclaredField("meizuFlags");
    field.setAccessible(true);
    int origin = field.getInt(lp);
    if (isLightStatusBar) {
      field.set(lp, origin | value);
    } else {
      field.set(lp, (~value) & origin);
    }
  }

  /**
   * 改变小米的状态栏字体颜色为黑色, 要求 MIUI 6 以上
   * Tested on: MIUI V7 5.0 Redmi-Note3
   *
   * @param window
   * @param lightStatusBar
   * @throws Exception
   */
  private static void processMIUI(Window window, boolean lightStatusBar) throws Exception {
    Class<? extends Window> clazz = window.getClass();
    int darkModeFlag;
    Class<?> layoutParams = Class.forName("android.view.MiuiWindowManager$LayoutParams");
    Field field = layoutParams.getField("EXTRA_FLAG_STATUS_BAR_DARK_MODE");
    darkModeFlag = field.getInt(layoutParams);
    Method extraFlagField = clazz.getMethod("setExtraFlags", int.class, int.class);
    extraFlagField.invoke(window, lightStatusBar ? darkModeFlag : 0, darkModeFlag);
  }
}
