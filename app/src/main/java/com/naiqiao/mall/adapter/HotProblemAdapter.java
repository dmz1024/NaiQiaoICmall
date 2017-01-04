package com.naiqiao.mall.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.naiqiao.mall.R;
import com.naiqiao.mall.bean.AllShopBean;
import com.naiqiao.mall.bean.HotProblemBean;
import com.naiqiao.mall.fragment.ProblemAnswerFragment;

import java.util.ArrayList;

import base.adapter.BaseAdapter;
import base.adapter.BaseViewHolder;
import base.bean.rxbus.AddFragmentBean;
import butterknife.BindView;
import util.RxBus;


/**
 * Created by dengmingzhi on 2016/11/21.
 */

public class HotProblemAdapter extends BaseAdapter<HotProblemBean.Data> {
    private boolean isMore;

    public HotProblemAdapter(Context ctx, ArrayList<HotProblemBean.Data> list) {
        super(ctx, list);
    }

    public HotProblemAdapter(Context ctx, ArrayList<HotProblemBean.Data> list,boolean isMore) {
        this(ctx, list);
        this.isMore=isMore;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(View.inflate(ctx, R.layout.item_hot_problem, null));
    }


    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ViewHolder mHolder = ((ViewHolder) holder);
        HotProblemBean.Data data = list.get(position);
        mHolder.tv_title.setText(data.title);
        mHolder.view.setVisibility(position == list.size() - 1 ? View.INVISIBLE : View.VISIBLE);
    }

    @Override
    public int getItemCount() {
        if (isMore) {
            return list.size();
        }
        return list.size() > 3 ? 3 : list.size();
    }

    public void showMore(boolean isMore) {
        this.isMore = isMore;
        notifyDataSetChanged();
    }

    public class ViewHolder extends BaseViewHolder {
        @BindView(R.id.tv_title)
        TextView tv_title;
        @BindView(R.id.view)
        View view;

        public ViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
        }

        @Override
        protected void onClick(int layoutPosition) {
            RxBus.get().post("addFragment", new AddFragmentBean(ProblemAnswerFragment.getInstance(list.get(layoutPosition).article_id)));
        }
    }

}
