package com.che58.ljb.rxjava.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.che58.ljb.rxjava.R;
import com.jakewharton.rxbinding.view.RxView;
import com.trello.rxlifecycle.components.support.RxFragment;
import java.util.concurrent.TimeUnit;
import rx.functions.Action1;

/**
 * View防止连续点击Demo
 * Created by ljb on 2016/3/24.
 */
public class NotMoreClickFragment extends RxFragment {

  @BindView(R.id.btn_click) Button btn_click;
  @BindView(R.id.txt_show) TextView txtShow;

  private int COUNT = 0;

  @Nullable @Override public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.fragment_not_more_click, null);
    ButterKnife.bind(this, view);
    return view;
  }

  @Override public void onActivityCreated(@Nullable Bundle savedInstanceState) {
    super.onActivityCreated(savedInstanceState);
    notMoreClick();
  }

  /**
   * 3秒内不允许按钮多次点击
   */
  private void notMoreClick() {
    RxView.clicks(btn_click).throttleFirst(3, TimeUnit.SECONDS).subscribe(new Action1<Void>() {
      @Override public void call(Void aVoid) {
        txtShow.setText("Count-->" + COUNT++);
        //Toast.makeText(getActivity(), R.string.des_demo_not_more_click, Toast.LENGTH_SHORT).show();
      }
    });
  }
}
