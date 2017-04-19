package com.che58.ljb.rxjava.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.che58.ljb.rxjava.R;
import com.trello.rxlifecycle.components.support.RxFragment;
import rx.Observable;
import rx.functions.Action1;

/**
 * RxJava Demo
 */
public class DemoFragment extends RxFragment {

  @BindView(R.id.txt_demo) TextView tv_msg;
  private StringBuilder sb;

  @Nullable @Override public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.fragment_demo, null);
    ButterKnife.bind(this, view);
    return view;
  }

  @Override public void onActivityCreated(@Nullable Bundle savedInstanceState) {
    super.onActivityCreated(savedInstanceState);
    sb = new StringBuilder();
    hello("1", "2", "3");
  }

  public void hello(String... names) {
    Observable.from(names).subscribe(new Action1<String>() {
      @Override public void call(String s) {
        sb.append(s + "!\t");
        tv_msg.setText(sb.toString());
      }
    });
  }

  @Override public void onPause() {
    super.onPause();
    sb = null;
  }
}
