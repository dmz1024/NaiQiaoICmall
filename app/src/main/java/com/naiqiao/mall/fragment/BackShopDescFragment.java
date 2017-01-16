package com.naiqiao.mall.fragment;

import android.view.View;
import android.widget.LinearLayout;

import com.naiqiao.mall.R;
import com.naiqiao.mall.bean.BackShopDescBean;

import java.util.Map;

import base.fragment.SingleNetWorkBaseFragment;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import view.DefaultTitleBarView;

/**
 * Created by dengmingzhi on 2016/12/14.
 */

public class BackShopDescFragment extends SingleNetWorkBaseFragment<BackShopDescBean> {
    @BindView(R.id.ll_shop)
    LinearLayout ll_shop;

    @Override
    protected String url() {
        return "http://www.ediancha.com/app.php";
    }

    @Override
    protected Map<String, String> map() {
        map.put("c", "chahui");
        map.put("a", "index");
        return super.map();
    }

    @Override
    protected Class<BackShopDescBean> getTClass() {
        return BackShopDescBean.class;
    }

    @Override
    protected View getHaveDataView() {
        View view = View.inflate(getContext(), R.layout.fragment_back_shop_desc, null);
        ButterKnife.bind(this, view);
        creatShop();
        return view;
    }

    private void creatShop() {
        for (int i = 0; i < 2; i++) {
            View view=View.inflate(getContext(), R.layout.item_only_back_money, null);
            if(i==1){
                view.findViewById(R.id.view_line).setVisibility(View.GONE);
            }
            ll_shop.addView(view);
        }
    }


    @Override
    protected void initTitleView() {
        ((DefaultTitleBarView) getTitleBar()).setTitleContent("退款/退货");
    }

    @Override
    protected boolean isCanRefresh() {
        return false;
    }


}
