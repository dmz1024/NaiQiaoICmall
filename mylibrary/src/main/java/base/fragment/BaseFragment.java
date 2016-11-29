package base.fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import base.other.TitleBarBaseView;
import util.Util;
import view.DefaultTitleBarView;

/**
 * Created by dengmingzhi on 2016/11/22.
 */

public abstract class BaseFragment extends Fragment implements View.OnTouchListener {
    private View titleBarView;
    private FrameLayout rootView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = new FrameLayout(getContext());
        rootView.setOnTouchListener(this);
        rootView.setBackgroundColor(Color.parseColor(getBackColor()));
        ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        rootView.setLayoutParams(params);
        titleBarView = getTitleBarView();
        if (titleBarView != null) {
            rootView.addView(titleBarView);
            initTitleView();
        }
        rootAddContentView(rootView);
        return rootView;
    }

    final public View getTitleBar() {
        return titleBarView;
    }

    protected String getBackColor() {
        return "#f5f5f5";
    }

    protected abstract void rootAddContentView(FrameLayout rootView);

    protected void initTitleView() {

    }

    protected View getTitleBarView() {
        return new DefaultTitleBarView(getContext());
    }

    protected int getTop() {
        return titleBarView == null ? 0 : Util.dp2Px(top());
    }

    protected float top() {
        return 45;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        rootView = null;
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        return true;
    }
}
