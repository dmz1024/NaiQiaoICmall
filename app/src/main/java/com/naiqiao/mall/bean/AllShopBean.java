package com.naiqiao.mall.bean;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

import base.bean.ListBaseBean;

/**
 * Created by dengmingzhi on 2016/12/14.
 * 全部商品
 */

public class AllShopBean extends ListBaseBean<ArrayList<AllShopBean.Data>> {
    public static class Data implements Parcelable {
        public String id;
        public String goods_id;
        public String goods_name;
        public String goods_price;
        public String goods_thumb;
        public String warn;
        public String sale;
        public int goods_number;
        public String goods_attr;
        public int currenTcount;
        public int isChoose = 0;

        protected Data(Parcel in) {
            id = in.readString();
            goods_id = in.readString();
            goods_name = in.readString();
            goods_price = in.readString();
            goods_thumb = in.readString();
            warn = in.readString();
            sale = in.readString();
            goods_attr = in.readString();
            goods_number = in.readInt();
            currenTcount = in.readInt();
            isChoose = in.readInt();
        }

        public static final Creator<Data> CREATOR = new Creator<Data>() {
            @Override
            public Data createFromParcel(Parcel in) {
                return new Data(in);
            }

            @Override
            public AllShopBean.Data[] newArray(int size) {
                return new AllShopBean.Data[size];
            }
        };

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(id);
            parcel.writeString(goods_id);
            parcel.writeString(goods_name);
            parcel.writeString(goods_price);
            parcel.writeString(goods_thumb);
            parcel.writeString(warn);
            parcel.writeString(sale);
            parcel.writeString(goods_attr);
            parcel.writeInt(goods_number);
            parcel.writeInt(currenTcount);
            parcel.writeInt(isChoose);
        }
    }
}
