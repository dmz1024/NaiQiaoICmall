package base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;

import util.Util;
import view.GmRefreshLayout;

/**
 * Created by dengmingzhi on 16/6/16.
 */
public abstract class BaseFragment extends Fragment implements GmRefreshLayout.OnRefreshListener, View.OnClickListener {
    protected boolean isRefresh;
    protected boolean isFirst = true;
    protected boolean isVisible;
    protected GmRefreshLayout gmRefreshLayout;
    protected FrameLayout root;
    /**
     * 标志位，标志视图已经初始化完成
     */
    boolean isPrepared;

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (getUserVisibleHint()) {
            isVisible = true;
            onVisible();
        } else {
            isVisible = false;
            onInvisible();
        }
    }


    /**
     * 可见
     */
    protected void onVisible() {

        if (isOnlyInitOne() && !isFirst) {
            return;
        }

        if (!isVisible) {
            return;
        }


        if (!isPrepared) {
            return;
        }

        if (isRefresh) {
            return;
        }

        if (isCanRefresh()) {
            gmRefreshLayout.startRefresh();
        } else {
            onRefresh();
        }

    }


    /**
     * 不可见
     */
    protected void onInvisible() {

    }

    public void startRefresh() {
        gmRefreshLayout.startRefresh();
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        gmRefreshLayout = new GmRefreshLayout(getContext());
        gmRefreshLayout.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        root = new FrameLayout(getContext());
        gmRefreshLayout.addView(root);
        root.setLayoutParams(getParams());
        View view = getShowView();
        root.addView(view);
        View header = getHeaderView();
        if (header != null) {
            gmRefreshLayout.setRefreshHeader(header);
        }
        gmRefreshLayout.setHeight(getHeaderHeight());

        isPrepared = true;
        setRefresh(isCanRefresh());
        if (isCanFirstInitData()) {
            if (isCanRefresh()) {
                gmRefreshLayout.startRefresh();
            } else {
                onRefresh();
            }
        }
        return gmRefreshLayout;
    }

    protected ViewGroup.LayoutParams getParams() {
        return new GmRefreshLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
    }

    protected int getHeaderHeight() {
        return Util.dp2Px(105);
    }

    /**
     * 设置是否可以下拉刷新
     *
     * @param isRefresh
     */
    public void setRefresh(boolean isRefresh) {
        gmRefreshLayout.setRefreshListener(isRefresh ? this : null);
        gmRefreshLayout.setEnabled(isRefresh);
    }

    /**
     * 设置在setUserVisibleHint可见的是否重复刷新数据
     *
     * @return
     */
    protected boolean isOnlyInitOne() {
        return true;
    }


    @Override
    public void onRefresh() {
        if (isRefresh) {
            return;
        } else {
            isRefresh = true;
        }
        isFirst = false;
        initData();
    }


    protected void stopRefresh() {
        isRefresh = false;
        gmRefreshLayout.refreshComplete();
    }


    /**
     * 是否在加载视图之后立马加载数据
     *
     * @return
     */
    protected boolean isCanFirstInitData() {
        return true;
    }


    /**
     * 是否设置下拉刷新
     *
     * @return
     */
    protected boolean isCanRefresh() {
        return true;
    }

    /**
     * 初始化数据
     */
    protected abstract void initData();


    /**
     * 获取视图
     *
     * @return
     */
    protected abstract View getShowView();

    /**
     * 获取刷新头视图
     *
     * @return
     */
    protected View getHeaderView() {
        return null;
    }

    @Override
    public void onClick(View v) {

    }
}
