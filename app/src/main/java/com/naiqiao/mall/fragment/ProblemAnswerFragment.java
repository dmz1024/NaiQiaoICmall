package com.naiqiao.mall.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.naiqiao.mall.R;
import com.naiqiao.mall.adapter.HotProblemAdapter;
import com.naiqiao.mall.bean.HotProblemBean;
import com.naiqiao.mall.bean.ProblemAnswerBean;
import com.naiqiao.mall.constant.ApiConstant;

import java.util.ArrayList;
import java.util.Map;

import base.bean.SingleBaseBean;
import base.fragment.SingleNetWorkBaseFragment;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import util.Util;
import view.DefaultTitleBarView;

/**
 * Created by dengmingzhi on 2017/1/4.
 */

public class ProblemAnswerFragment extends SingleNetWorkBaseFragment<ProblemAnswerBean> {
    @BindView(R.id.tv_title)
    TextView tv_title;
    @BindView(R.id.tv_content)
    TextView tv_content;
    @BindView(R.id.rv_content)
    RecyclerView rv_content;

    public static ProblemAnswerFragment getInstance(String id) {
        ProblemAnswerFragment fragment = new ProblemAnswerFragment();
        Bundle bundle = new Bundle();
        bundle.putString("id", id);
        fragment.setArguments(bundle);
        return fragment;
    }

    private String id;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = getArguments();
        if (bundle != null) {
            id = bundle.getString("id");
        }
    }

    @Override
    protected String url() {
        return ApiConstant.HELP;
    }

    @Override
    protected Map<String, String> map() {
        map.put("act", "index_question");
        map.put("article_id", id);
        return super.map();
    }

    @Override
    protected Class<ProblemAnswerBean> getTClass() {
        return ProblemAnswerBean.class;
    }

    @Override
    protected void writeData(boolean isWrite, ProblemAnswerBean bean) {
        super.writeData(isWrite, bean);
        tv_title.setText(bean.data.info.title);
        tv_content.setText(Html.fromHtml(bean.data.info.content));
        initHot(bean.data.list);
    }

    @Override
    protected View getHaveDataView() {
        View view = View.inflate(getContext(), R.layout.fragment_problem_answer, null);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    protected void initTitleView() {
        ((DefaultTitleBarView) getTitleBar()).setTitleContent("帮助中心");
    }

    private void initHot(ArrayList<HotProblemBean.Data> data) {
        HotProblemAdapter hotAdapter = new HotProblemAdapter(getContext(), data, true);
        LinearLayoutManager mManager = new LinearLayoutManager(getContext()) {
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        };
        rv_content.setLayoutManager(mManager);
        rv_content.setAdapter(hotAdapter);
    }

    @OnClick(R.id.bt_submit)
    void submit() {
        Util.qq(getContext(),"1395386348");
    }

    @Override
    protected boolean isCanRefresh() {
        return false;
    }
}
