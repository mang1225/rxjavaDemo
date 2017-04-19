package com.che58.ljb.rxjava.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.che58.ljb.rxjava.R;
import com.che58.ljb.rxjava.utils.XgoLog;
import com.trello.rxlifecycle.android.FragmentEvent;
import com.trello.rxlifecycle.components.support.RxFragment;
import java.util.concurrent.TimeUnit;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;

/**
 * RxJava定时器
 * Created by ljb on 2016/3/28.
 */
public class TimerFragment extends RxFragment {

  @BindView(R.id.iv_welcome) ImageView iv_welcome;

  @Override public void onAttach(Activity activity) {
    super.onAttach(activity);
    XgoLog.d("onAttach()");
  }

  @Nullable @Override public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.fragment_timer, null);
    ButterKnife.bind(this, view);
    XgoLog.d("onCreateView()");
    return view;
  }

  @Override public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
    XgoLog.d("onViewCreated()");
  }

  @Override public void onActivityCreated(@Nullable Bundle savedInstanceState) {
    super.onActivityCreated(savedInstanceState);
    starTimer();
    XgoLog.d("onActivityCreated()");
  }

  @Override public void onStart() {
    super.onStart();
    XgoLog.d("onStart()");
  }

  @Override public void onResume() {
    super.onResume();
    XgoLog.d("onResume()");
  }

  @Override public void onPause() {
    super.onPause();
    XgoLog.d("onPause()");
  }

  @Override public void onStop() {
    super.onStop();
    XgoLog.d("onStop()");
  }

  @Override public void onDestroyView() {
    super.onDestroyView();
    XgoLog.d("onDestroyView()");
  }

  @Override public void onDestroy() {
    super.onDestroy();
    XgoLog.d("onDestroy()");
  }

  @Override public void onDetach() {
    super.onDetach();
    XgoLog.d("onDetach()");
  }

  private void starTimer() {
    //Observable.timer(3000, TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).compose(this.<Long>bindToLifecycle()).subscribe(new Action1<Long>() {
    //  @Override public void call(Long aLong) {
    //    // Glide.with(TimerFragment.this).load("http://static.zuchecdn.com/wap/newversion/images/20151225fanli_app.jpg").crossFade().into(iv_welcome);
    //    iv_welcome.setVisibility(View.VISIBLE);
    //    ObjectAnimator.ofFloat(iv_welcome, "alpha", 0.0F, 1.0F).setDuration(500).start();
    //  }
    //});
    Observable.interval(100, TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).compose(this.<Long>bindUntilEvent(FragmentEvent.DESTROY)).subscribe(new Action1<Long>() {
      //Observable.timer(1, TimeUnit.SECONDS).observeOn(AndroidSchedulers.mainThread()).compose(this.<Long>bindUntilEvent(FragmentEvent.PAUSE)).subscribe(new Action1<Long>() {
      @Override public void call(Long aLong) {
        XgoLog.d("--------------");
      }
    });
  }
}
