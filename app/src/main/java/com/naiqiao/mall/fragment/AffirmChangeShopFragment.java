package com.naiqiao.mall.fragment;

import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.naiqiao.mall.R;

import java.util.Map;

import base.fragment.NotNetWorkBaseFragment;
import butterknife.BindView;
import util.SharedPreferenUtil;
import view.Color2Text;

/**
 * Created by dengmingzhi on 2016/12/14.
 */

public class AffirmChangeShopFragment extends NotNetWorkBaseFragment {
    @BindView(R.id.tv_huan)
    TextView tv_huan;
    @BindView(R.id.tv_huan_price)
    TextView tv_huan_price;
    @BindView(R.id.tv_jin)
    TextView tv_jin;
    @BindView(R.id.tv_jin_price)
    TextView tv_jin_price;
    @BindView(R.id.tv_sub_price)
    Color2Text tv_sub_price;

    @Override
    protected void initData() {
        Map<String, String> map = new SharedPreferenUtil(getContext(), "changeGoods").getData(new String[]{"one", "one_price", "two", "two_price", "one_count", "two_count"});
        String one = map.get("one");
        String two = map.get("two");
        String one_count = map.get("one_count");
        String two_count = map.get("two_count");
        double one_price = Double.parseDouble(map.get("one_price"));
        double two_price = Double.parseDouble(map.get("two_price"));

        tv_huan.setText("虚拟仓商品\n\n" + one_count + "件");
        tv_jin.setText("新进商品\n\n" + two_count + "件");
        tv_huan_price.setText("总价值￥" + one_price);
        tv_jin_price.setText("总价值￥" + two_price);

        Log.d("结果", one_price + "---");
        tv_sub_price.setTextNotChange((two_price - one_price) + "元");

    }

    @Override
    protected int getRId() {
        return R.layout.fragment_affirm_change_shop;
    }

    @Override
    protected View getTitleBarView() {
        return null;
    }


    @Override
    protected boolean isOnlyInitOne() {
        return false;
    }

    @Override
    protected boolean isCanFirstInitData() {
        return false;
    }
}
