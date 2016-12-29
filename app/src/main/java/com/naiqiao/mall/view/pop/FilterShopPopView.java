package com.naiqiao.mall.view.pop;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.naiqiao.mall.R;
import com.naiqiao.mall.bean.FilterBean;
import com.naiqiao.mall.constant.ApiConstant;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import api.ApiRequest;
import api.CallServer;
import base.adapter.BaseAdapter;
import base.adapter.BaseViewHolder;
import base.other.PopBaseView;
import interfaces.OnSingleRequestListener;
import util.MyToast;

/**
 * Created by dengmingzhi on 2016/12/1.
 */

public class FilterShopPopView extends PopBaseView {
    private ArrayList<FilterBean.Data> datas;
    private int currentPosition;
    private int type;
    private String id;

    public FilterShopPopView(Context ctx) {
        super(ctx);
    }

    public FilterShopPopView(Context ctx, String id, int type, int currentPosition, ArrayList<FilterBean.Data> datas) {
        this(ctx);
        this.currentPosition = currentPosition;
        this.datas = datas;
        this.type = type;
        this.id = id;
    }


    @Override
    protected int getAnimation() {
        return 0;
    }

    private RecyclerView rv_content;
    private TextView tv_load;

    @Override
    protected View getView() {
        View view = View.inflate(ctx, R.layout.pop_filter_shop, null);
        tv_load = (TextView) view.findViewById(R.id.tv_load);
        view.findViewById(R.id.tv_clear).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mAdapter != null) {
                    clear();
                }
            }
        });

        view.findViewById(R.id.tv_ok).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mAdapter != null) {
                    dismiss();
                    ok(currentPosition);
                }
            }
        });

        rv_content = (RecyclerView) view.findViewById(R.id.rv_content);
        if (datas != null && datas.size() > 0) {
            rv_content.setLayoutManager(new GridLayoutManager(ctx, 3));
            rv_content.setAdapter(mAdapter = new FilterShopPopAdapter(ctx, datas));
        } else {
            getData();
        }
        return view;
    }


    /**
     * 获取分类列表
     */
    private void getData() {
        tv_load.setText("加载中...");
        tv_load.setVisibility(View.VISIBLE);
        new ApiRequest<FilterBean>() {
            @Override
            protected Map<String, String> getMap() {
                Map<String, String> map = new HashMap<>();
                map.put("act", type == 0 ? "get_cat_brand" : "get_brand_cat");
                map.put(type == 0 ? "cat_id" : "brand_id", id);
                return map;
            }

            @Override
            protected Context getContext() {
                return ctx;
            }

            @Override
            protected String getUrl() {
                return ApiConstant.CATEGORY;
            }

            @Override
            protected Class<FilterBean> getClx() {
                return FilterBean.class;
            }
        }.setOnRequestListeren(new OnSingleRequestListener<FilterBean>() {

            @Override
            public void succes(boolean isWrite, FilterBean bean) {
                if (bean.result == 0) {
                    if (bean.data.size() > 0) {
                        tv_load.setVisibility(View.GONE);
                        rv_content.setLayoutManager(new GridLayoutManager(ctx, 3));
                        rv_content.setAdapter(mAdapter = new FilterShopPopAdapter(ctx, datas));
                    } else {
                        tv_load.setVisibility(View.VISIBLE);
                        tv_load.setText("暂无" + (type == 0 ? "品牌" : "分类") + "列表");

                    }
                    setData(bean.data);
                } else {
                    MyToast.showToast("获取" + (type == 0 ? "品牌" : "分类") + "列表失败!");
                }

            }

            @Override
            public void error(boolean isWrite, FilterBean bean, String msg) {
                MyToast.showToast("获取" + (type == 0 ? "品牌" : "分类") + "列表失败!");
            }
        }).post();
    }


    @Override
    public void dismiss() {
        CallServer.getInstance().cancelBySign(FilterBean.class);
        super.dismiss();
    }

    protected void ok(int position) {

    }

    protected void setData(ArrayList<FilterBean.Data> datas) {

    }

    private FilterShopPopAdapter mAdapter;

    protected void clear() {

        currentPosition = -1;
        mAdapter.notifyDataSetChanged();

    }


    class FilterShopPopAdapter extends BaseAdapter<FilterBean.Data> {


        public FilterShopPopAdapter(Context ctx, ArrayList<FilterBean.Data> list) {
            super(ctx, list);
        }

        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new ViewHolder(View.inflate(ctx, R.layout.pop_filter_shop_item, null));
        }

        @Override
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
            ViewHolder mHolder = (ViewHolder) holder;
            mHolder.tv_content.setText(list.get(position).brand_name);
            if (position == currentPosition) {
                mHolder.tv_content.setTextColor(Color.parseColor("#f54262"));
                mHolder.iv_img.setVisibility(View.VISIBLE);
            } else {
                mHolder.tv_content.setTextColor(Color.parseColor("#666666"));
                mHolder.iv_img.setVisibility(View.GONE);
            }

        }


        class ViewHolder extends BaseViewHolder {
            public TextView tv_content;
            public ImageView iv_img;

            public ViewHolder(View itemView) {
                super(itemView);
                tv_content = (TextView) itemView.findViewById(R.id.tv_content);
                iv_img = (ImageView) itemView.findViewById(R.id.iv_img);
                itemView.setOnClickListener(this);
            }

            @Override
            protected void onClick(int layoutPosition) {
                if (layoutPosition != currentPosition) {
                    currentPosition = layoutPosition;
                    notifyDataSetChanged();
                }
            }
        }
    }
}
