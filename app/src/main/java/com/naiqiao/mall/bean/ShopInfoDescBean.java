package com.naiqiao.mall.bean;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

import base.bean.BaseBean;

/**
 * Created by dengmingzhi on 2016/12/29.
 */

public class ShopInfoDescBean extends BaseBean<ShopInfoDescBean.Data> {
    public static class Data {
        public int is_login;
        public int collect;
        public GoodsInfoBean goods_info;
        public ArrayList<GoodsRankBean> goods_rank;
        public ArrayList<UserRankPricesBean> user_rank_prices;
        public ArrayList<RecommendBean> recommend;
        public ArrayList<String> gallery_arr;
        public ArrayList<SpeBean> spe;
        public ArrayList<TbBean> tb;
        public String h5_url;

        public static class UserRankPricesBean {
            public String price;
            public String rank_name;
        }

        public static class GoodsInfoBean {
            public String goods_id;
            public String goods_name;
            public String goods_brief;
            public String volume_price_list;
            public String promote_price;
        }

        public static class GoodsRankBean {
            /**
             * num : 6
             * city : 宁德
             */
            public String num;
            public String city;
        }

        public static class RecommendBean {

            public String promote_price;
            public String goods_id;
            public String name;
            public String brief;
            public String brand_name;
            public String market_price;
            public String shop_price;
            public String thumb;
        }

        public static class SpeBean {

            public int attr_id;
            public String name;
            public String cat_id;
            public String cat_name;
            public ArrayList<ValuesBean> values;

            public static class ValuesBean {

                public String goods_attr_id;
                public String attr_value;
                public String attr_id;
                public String goods_id;
                public int sign;
            }
        }

        public static class TbBean {
            public String name;
            public String value;
            public String goods_brand;
        }


    }
}
