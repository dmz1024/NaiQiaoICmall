package base.fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import util.Util;
import view.DefaultTitleBarView;

/**
 * Created by dengmingzhi on 2016/11/22.
 */

public abstract class BaseFragment extends Fragment {
    private View titleBarView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        FrameLayout rootView = new FrameLayout(getContext());
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
        return "#ffffff";
    }

    protected abstract void rootAddContentView(FrameLayout rootView);

    protected void initTitleView() {

    }

    protected View getTitleBarView() {
        return new DefaultTitleBarView(getContext());
    }

    protected int getTop() {
        return titleBarView == null ? 0 : Util.dp2Px(45);
    }
}
