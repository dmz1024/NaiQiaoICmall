package com.naiqiao.mall.fragment;

import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.naiqiao.mall.R;
import com.naiqiao.mall.bean.AddressBean;
import com.naiqiao.mall.bean.rxbus.AddressRxBus;
import com.naiqiao.mall.controller.AddressController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import base.fragment.NotNetWorkBaseFragment;
import butterknife.BindView;
import butterknife.BindViews;
import butterknife.OnClick;
import util.DrawableUtil;
import view.DefaultTitleBarView;

/**
 * Created by dengmingzhi on 2016/12/23.
 */

public class AddressEditFragment extends NotNetWorkBaseFragment {
    private AddressBean.Data data;
    @BindViews({R.id.et_name, R.id.et_tel, R.id.et_address})
    List<EditText> ets;
    @BindViews({R.id.tv_address, R.id.tv_default})
    List<TextView> tvs;
    private String province = "2";
    private String city = "52";
    private String distric = "500";

    @Override
    protected void initData() {

    }


    @Override
    protected void initView() {
        if (data != null) {
            ets.get(0).setText(data.consignee);
            ets.get(1).setText(data.mobile);
            ets.get(2).setText(data.address);
            tvs.get(0).setText(data.province_name + "-" + data.city_name + "-" + data.district_name);
            province = data.province;
            city = data.city;
            distric = data.district;
            isDefault = data.def == 1;
        }

        tvs.get(1).setVisibility(isDefault ? View.GONE : View.VISIBLE);

    }

    private void changeDef() {
        tvs.get(1).setCompoundDrawables(null, null, DrawableUtil.setBounds(getResources().getDrawable(isDefault ? R.mipmap.icon_checked : R.mipmap.icon_check)), null);

    }

    private int defPosition;
    private int position;

    public void setData(AddressBean.Data data, int defPosition, int position) {
        this.data = data;
        this.defPosition = defPosition;
        this.position = position;
    }

    @Override
    protected int getRId() {
        return R.layout.fragment_address_edit;
    }

    @Override
    protected void initTitleView() {
        ((DefaultTitleBarView) getTitleBar()).setTitleContent(data == null ? "新建地址" : "编辑地址");
    }

    @OnClick(R.id.bt_submit)
    void submit() {
        Map<String, String> map = new HashMap<>();
        map.put("consignee", ets.get(0).getText().toString());
        map.put("mobile", ets.get(1).getText().toString());
        map.put("address", ets.get(2).getText().toString());
        map.put("province1", province);
        map.put("city1", city);
        map.put("district1", distric);
        map.put("default", isDefault ? "1" : "0");
        if (data != null) {
            map.put("address_id", data.address_id);
        }
        AddressController.getInstance().addOrUpdate(map);
    }

    private boolean isDefault;

    @OnClick({R.id.tv_address, R.id.tv_default})
    void tvsOnClick(View view) {
        if (view == tvs.get(0)) {

        } else {
            if (data == null) {
                isDefault = !isDefault;
                changeDef();
            } else {

                AddressController.getInstance().setDef(new AddressRxBus(data.address_id, "def", defPosition, position, true));
            }
        }
    }
}
