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

import base.bean.rxbus.AddFragmentBean;
import base.fragment.AreaFragment;
import base.fragment.NotNetWorkBaseFragment;
import butterknife.BindView;
import butterknife.BindViews;
import butterknife.OnClick;
import rx.Observable;
import rx.functions.Action1;
import util.DrawableUtil;
import util.RxBus;
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
    private String province;
    private String city;
    private String distric;

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
            initAreaRxBus();
            RxBus.get().post("addFragment", new AddFragmentBean(new AreaFragment()));
        } else {
            if (data == null) {
                isDefault = !isDefault;
                changeDef();
            } else {

                AddressController.getInstance().setDef(new AddressRxBus(data.address_id, "def", defPosition, position, true));
            }
        }
    }

    private Observable<String> areaData;

    private void initAreaRxBus() {
        if (areaData == null) {
            areaData = RxBus.get().register("area_data", String.class);
            areaData.subscribe(new Action1<String>() {
                @Override
                public void call(String s) {
                    String[] areas = s.split(",");
                    if (areas != null && areas.length > 0) {
                        String[] area = areas[0].split("-");
                        province = area[1];
                        tvs.get(0).setText(area[0]);
                        if (areas.length > 1) {
                            area = areas[1].split("-");
                            city = area[1];
                            tvs.get(0).setText(tvs.get(0).getText().toString() + "-" + area[0]);
                            if (areas.length > 2) {
                                area = areas[2].split("-");
                                distric = area[1];
                                tvs.get(0).setText(tvs.get(0).getText().toString() + "-" + area[0]);
                            }
                        }

                    }
                }
            });
        }

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        RxBus.get().unregister("area_data",areaData);
    }
}
