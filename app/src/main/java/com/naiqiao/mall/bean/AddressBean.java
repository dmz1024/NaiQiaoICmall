package com.naiqiao.mall.bean;

import java.util.ArrayList;

import base.bean.ListBaseBean;

/**
 * Created by dengmingzhi on 2016/12/8.
 */

public class AddressBean extends ListBaseBean<ArrayList<AddressBean.Data>> {
    public static class Data {
        public String address_id;
        public String consignee;
        public String mobile;
        public String province;
        public String city;
        public String district;
        public String address;
        public String province_name;
        public String group_address;
        public String city_name;
        public String district_name;
        public int def;
    }
}
