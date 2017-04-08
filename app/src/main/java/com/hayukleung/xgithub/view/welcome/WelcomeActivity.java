package com.hayukleung.xgithub.view.welcome;

import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.TextPaint;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.hayukleung.xgithub.R;
import com.hayukleung.xgithub.view.Activities;
import com.hayukleung.xgithub.view.FullScreenActivity;
import com.hayukleung.xgithub.view.main.MainFragment;
import com.hayukleung.xgithub.widget.ShyaringanView;

import static com.hayukleung.absolutescreenmatch.R.dimen.xp20_0;

/**
 * XGitHub
 * com.hayukleung.xgithub.view.welcome
 * WelcomeActivity.java
 *
 * by hayukleung
 * at 2017-04-03 15:03
 */

public class WelcomeActivity extends FullScreenActivity {

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    FrameLayout.LayoutParams layoutParams =
        new FrameLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
            ViewGroup.LayoutParams.WRAP_CONTENT);
    layoutParams.gravity = Gravity.CENTER;
    int margin = (int) getResources().getDimension(xp20_0);
    layoutParams.leftMargin = layoutParams.rightMargin = margin;
    mContent.removeAllViews();
    ShyaringanView shyaringanView = new ShyaringanView(this);
    mContent.addView(shyaringanView, layoutParams);

    layoutParams = new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
        ViewGroup.LayoutParams.WRAP_CONTENT);
    layoutParams.gravity = Gravity.CENTER_HORIZONTAL;
    layoutParams.topMargin = margin;
    TextView name = new TextView(this);
    name.setText(R.string.app_name);
    name.setTextColor(Color.BLACK);
    name.setGravity(Gravity.CENTER);
    name.setTextSize(getResources().getDimensionPixelSize(R.dimen.xp6_0));
    name.setBackground(null);
    TextPaint textPaint = name.getPaint();
    textPaint.setFakeBoldText(true);
    mContent.addView(name, layoutParams);

    layoutParams = new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
        ViewGroup.LayoutParams.WRAP_CONTENT);
    layoutParams.gravity = Gravity.CENTER_HORIZONTAL;
    layoutParams.topMargin = margin;
    name = new TextView(this);
    name.setText(R.string.app_name);
    name.setTextColor(getResources().getColor(R.color.colorPrimary));
    name.setGravity(Gravity.CENTER);
    name.setTextSize(getResources().getDimensionPixelSize(R.dimen.xp6_0));
    name.setBackground(null);
    mContent.addView(name, layoutParams);

    CountDownTimer timer = new CountDownTimer(3 * 1000, 3 * 1000) {
      @Override public void onTick(long millisUntilFinished) {
      }

      @Override public void onFinish() {
        Activities.startActivity(WelcomeActivity.this, MainFragment.class);
        finish();
      }
    };
    timer.start();
  }
}
