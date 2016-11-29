package com.naiqiao.mall.fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;

import com.naiqiao.mall.R;
import com.naiqiao.mall.adapter.IndexSearchHistoryAdapter;
import com.naiqiao.mall.bean.IndexSearchHistory;
import com.naiqiao.mall.view.IndexSearchTitleBarView;

import java.util.ArrayList;
import java.util.List;

import base.fragment.NotNetWorkBaseFragment;
import base.other.ItemDecoration;
import butterknife.BindView;
import butterknife.BindViews;
import butterknife.OnClick;
import util.JsonUtil;
import util.SharedPreferenUtil;
import util.Util;

/**
 * Created by dengmingzhi on 2016/11/28.
 */

public class IndexSearchFragment extends NotNetWorkBaseFragment implements IndexSearchTitleBarView.OnIndexSearchTitleBarListener {
    @BindViews({R.id.tv_change, R.id.tv_cancel})
    List<TextView> tvs;
    @BindView(R.id.rv_history)
    RecyclerView rv_history;


    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {
        getChildFragmentManager().beginTransaction().add(R.id.fg_hot, new IndexSearchHotFragment()).commit();
        readHistory();
    }

    private void readHistory() {
        IndexSearchHistory indexSearchHistory = JsonUtil.json2Bean(new SharedPreferenUtil(getContext(), "indexHistory").getString("indexHistory"), IndexSearchHistory.class);
        if (indexSearchHistory == null) {
            datas = new ArrayList<>();
        } else {
            datas = indexSearchHistory.data;
        }

        showHistory(datas);
    }


    @Override
    protected int getRId() {
        return R.layout.fragment_index_search;
    }

    @OnClick(R.id.tv_change)
    void change() {

    }

    @Override
    public void content(String content) {
        addHistory(content);
    }

    @Override
    public void cancel() {
        onDestroy();
    }

    @OnClick(R.id.tv_cancel)
    void clear() {
        datas.clear();
        mAdapter.notifyDataSetChanged();
    }

    @Override
    protected void initTitleView() {
        ((IndexSearchTitleBarView) getTitleBar()).setOnIndexSearchTitleBarListener(this);

    }

    @Override
    protected View getTitleBarView() {
        return new IndexSearchTitleBarView(getContext());
    }

    private IndexSearchHistoryAdapter mAdapter;
    private ArrayList<IndexSearchHistory.Data> datas;

    private void showHistory(ArrayList<IndexSearchHistory.Data> datas) {
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        mAdapter = new IndexSearchHistoryAdapter(getContext(), datas);
        rv_history.addItemDecoration(new ItemDecoration(getContext(), LinearLayoutManager.VERTICAL, 1, "#e1e1e1"));
        rv_history.setAdapter(mAdapter);
        rv_history.setLayoutManager(layoutManager);
    }


    private void addHistory(String content) {
        boolean isHave = false;
        exit:
        for (int i = 0; i < datas.size(); i++) {
            if (TextUtils.equals(content, datas.get(i).content)) {
                isHave = true;
                break exit;
            }
        }
        if (!isHave) {
            datas.add(new IndexSearchHistory.Data(content));
            mAdapter.notifyDataSetChanged();
        }

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        new SharedPreferenUtil(getContext(), "indexHistory").setData("indexHistory", JsonUtil.javaBean2Json(new IndexSearchHistory(datas)));
    }
}
