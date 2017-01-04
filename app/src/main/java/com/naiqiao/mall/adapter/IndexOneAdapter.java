package com.naiqiao.mall.adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.jude.rollviewpager.RollPagerView;
import com.jude.rollviewpager.hintview.ColorPointHintView;
import com.naiqiao.mall.R;
import com.naiqiao.mall.bean.AddressBean;
import com.naiqiao.mall.bean.IndexOneBean;
import com.naiqiao.mall.bean.IndexOneNavigationBean;

import java.util.ArrayList;

import api.TestConstant;
import base.adapter.BaseAdapter;
import base.adapter.BaseViewHolder;
import base.adapter.MyLoopPagerAdapter;
import butterknife.BindView;


/**
 * Created by dengmingzhi on 2016/11/21.
 */

public class IndexOneAdapter extends BaseAdapter<IndexOneBean.Data> {

    public IndexOneAdapter(Context ctx, ArrayList<IndexOneBean.Data> list) {
        super(ctx, list);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolderTitleMore(View.inflate(ctx, R.layout.item_index_one_title_more, null));
    }



    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        IndexOneBean.Data data = list.get(position);
        ViewHolderTitleMore mHolder = (ViewHolderTitleMore) holder;
        mHolder.tv_title.setText(data.name);
        mHolder.tv_other_name.setText(data.othername);

        if (data.color.length() == 7) {
            int color=Color.parseColor(data.color);
            mHolder.rl_root.setBackgroundColor(Color.parseColor("#50" + data.color.substring(1)));
            mHolder.tv_other_name.setTextColor(color);
            mHolder.tv_go.setTextColor(color);
            mHolder.view_title.setBackgroundColor(color);
            mHolder.view_line.setBackgroundColor(color);
        }

        IndexOneShopAdapter goodsAdapter = new IndexOneShopAdapter(ctx, data.goods);
        LinearLayoutManager manager = new LinearLayoutManager(ctx);
        manager.setOrientation(LinearLayoutManager.HORIZONTAL);
        mHolder.rv_content.setLayoutManager(manager);
        mHolder.rv_content.setAdapter(goodsAdapter);




//        switch (data.type) {
//            case 0:
//                ViewHolderRvp HolderRvp = ((ViewHolderRvp) holder);
//                ArrayList<String> urls = new ArrayList<>();
//                for (int i = 0; i < 4; i++) {
//                    urls.add(TestConstant.IMAGE);
//                }
//                if (urls.size() > 1) {
//                    HolderRvp.rollPagerView.setPlayDelay(4000);
//                    HolderRvp.rollPagerView.setHintView(new ColorPointHintView(ctx, R.color.colorf73f5f, Color.WHITE));
//                } else {
//                    HolderRvp.rollPagerView.setPlayDelay(0);
//                    HolderRvp.rollPagerView.setHintView(null);
//                }
//
//                HolderRvp.rollPagerView.setAdapter(new MyLoopPagerAdapter(HolderRvp.rollPagerView, urls));
//                break;
//            case 1:
//                ViewHolderNavigation holderNav = ((ViewHolderNavigation) holder);
//                ArrayList<IndexOneNavigationBean> naviBeans = new ArrayList<>();
//                for (int i = 0; i < 8; i++) {
//                    naviBeans.add(new IndexOneNavigationBean());
//                }
//
//                GridLayoutManager manager = new GridLayoutManager(ctx, 4);
//                IndexOneNavigationAdapter mAdapter = new IndexOneNavigationAdapter(ctx, naviBeans);
//                holderNav.rv_content.setLayoutManager(manager);
//                holderNav.rv_content.setAdapter(mAdapter);
//                break;
//            case 2:
//                ViewHolderNavigation holderDeseno = ((ViewHolderNavigation) holder);
//                ArrayList<AddressBean.Data> views = new ArrayList<>();
//                for (int i = 0; i < 4; i++) {
//                    views.add(new AddressBean.Data());
//                }
//                LinearLayoutManager managerDeseno = new LinearLayoutManager(ctx);
//                managerDeseno.setOrientation(LinearLayoutManager.HORIZONTAL);
//                IndexOneDesenoAdapter adapterDeseno = new IndexOneDesenoAdapter(ctx, views);
//                holderDeseno.rv_content.setLayoutManager(managerDeseno);
//                holderDeseno.rv_content.setAdapter(adapterDeseno);
//                break;
//            case 3:
//                ViewHolderLikeMore holderLikeMore = ((ViewHolderLikeMore) holder);
//                LinearLayoutManager managerLikeMore = new LinearLayoutManager(ctx);
//                managerLikeMore.setOrientation(LinearLayoutManager.HORIZONTAL);
//                ArrayList<AddressBean.Data> addresss = new ArrayList<>();
//                for (int i = 0; i < 9; i++) {
//                    addresss.add(new AddressBean.Data());
//                }
//                IndexOneShopAdapter adapterLikeMore = new IndexOneShopAdapter(ctx, addresss);
//                holderLikeMore.rv_content.setLayoutManager(managerLikeMore);
//                holderLikeMore.rv_content.setAdapter(adapterLikeMore);
//                break;
//            case 4:
//                ViewHolderImageTime holderImageTime = ((ViewHolderImageTime) holder);
//                Glide.with(ctx).load(TestConstant.IMAGE).into(holderImageTime.iv_img);
//
//                LinearLayoutManager managerImageTime = new LinearLayoutManager(ctx);
//                managerImageTime.setOrientation(LinearLayoutManager.HORIZONTAL);
//                ArrayList<AddressBean.Data> addressss = new ArrayList<>();
//                for (int i = 0; i < 9; i++) {
//                    addressss.add(new AddressBean.Data());
//                }
//                IndexOneShopAdapter adapterImageTime = new IndexOneShopAdapter(ctx, addressss);
//                holderImageTime.rv_content.setLayoutManager(managerImageTime);
//                holderImageTime.rv_content.setAdapter(adapterImageTime);
//                break;
//            case 5:
//                ViewHolderImage holderImage = ((ViewHolderImage) holder);
//                Glide.with(ctx).load(TestConstant.IMAGE).into(holderImage.iv_img);
//                break;
//            case 6:
//
//                break;
//
//        }

    }


    public class ViewHolderRvp extends BaseViewHolder {
        public RollPagerView rollPagerView;

        public ViewHolderRvp(View itemView) {
            super(itemView);
            rollPagerView = (RollPagerView) itemView.findViewById(R.id.rpv_content);
        }
    }

    public class ViewHolderNavigation extends BaseViewHolder {
        public RecyclerView rv_content;

        public ViewHolderNavigation(View itemView) {
            super(itemView);
            rv_content = (RecyclerView) itemView;

        }
    }

    public class ViewHolderVp extends BaseViewHolder {
        public ViewPager vp_content;

        public ViewHolderVp(View itemView) {
            super(itemView);
            vp_content = (ViewPager) itemView.findViewById(R.id.vp_content);
        }
    }

    public class ViewHolderLikeMore extends BaseViewHolder {
        public RecyclerView rv_content;

        public ViewHolderLikeMore(View itemView) {
            super(itemView);
            rv_content = (RecyclerView) itemView.findViewById(R.id.rv_content);
        }
    }

    public class ViewHolderImageTime extends BaseViewHolder {
        public ImageView iv_img;
        public RecyclerView rv_content;

        public ViewHolderImageTime(View itemView) {
            super(itemView);
            iv_img = (ImageView) itemView.findViewById(R.id.iv_img);
            rv_content = (RecyclerView) itemView.findViewById(R.id.rv_content);
        }
    }

    public class ViewHolderImage extends BaseViewHolder {
        public ImageView iv_img;

        public ViewHolderImage(View itemView) {
            super(itemView);
            iv_img = (ImageView) itemView.findViewById(R.id.iv_img);
        }
    }

    public class ViewHolderTitleMore extends BaseViewHolder {
        @BindView(R.id.rl_root)
        RelativeLayout rl_root;
        @BindView(R.id.view_title)
        View view_title;
        @BindView(R.id.tv_title)
        TextView tv_title;
        @BindView(R.id.view_line)
        View view_line;
        @BindView(R.id.tv_other_name)
        TextView tv_other_name;
        @BindView(R.id.tv_go)
        TextView tv_go;
        @BindView(R.id.tv_more)
        TextView tv_more;
        @BindView(R.id.rv_content)
        RecyclerView rv_content;

        public ViewHolderTitleMore(View itemView) {
            super(itemView);

        }
    }

}
