package com.hayukleung.xgithub.view.star;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.hayukleung.xgithub.R;
import com.hayukleung.xgithub.model.Stub;
import java.util.ArrayList;
import java.util.List;

/**
 * XGitHub
 * com.hayukleung.xgithub.view.star
 * StarAdapter.java
 *
 * by hayukleung
 * at 2017-04-07 12:26
 */

public class StarAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

  private static final int VIEW_TYPE_STAR_HEADER = 0;
  private static final int VIEW_TYPE_STAR = 1;

  private List<Stub> mStubList = new ArrayList<>(20);

  public StarAdapter() {
    for (int i = 0; i < 20; i++) {
      mStubList.add(new Stub());
    }
  }

  @Override public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    switch (viewType) {
      case VIEW_TYPE_STAR:
      default: {
        return new StarHolder(
            LayoutInflater.from(parent.getContext()).inflate(R.layout.item_star, parent, false));
      }
      case VIEW_TYPE_STAR_HEADER: {
        return new StarHeaderHolder(LayoutInflater.from(parent.getContext())
            .inflate(R.layout.item_star_header, parent, false));
      }
    }
  }

  @Override public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

  }

  @Override public int getItemViewType(int position) {
    switch (position) {
      case 0: {
        return VIEW_TYPE_STAR_HEADER;
      }
      default: {
        return VIEW_TYPE_STAR;
      }
    }
  }

  @Override public int getItemCount() {
    return mStubList.size() + 1;
  }
}
