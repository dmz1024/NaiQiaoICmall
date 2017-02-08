package com.naiqiao.mall.bean;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by dengmingzhi on 2016/12/7.
 */

public class ShopBean implements Parcelable {
    public String rec_id;
    public String goods_id;
    public String goods_name;
    public int goods_number;
    public String market_price;
    public String goods_price;
    public String goods_attr;
    public String goods_thumb;
    public int count;
    public ShopBean(){

    }
    protected ShopBean(Parcel in) {
        rec_id = in.readString();
        goods_id = in.readString();
        goods_name = in.readString();
        goods_number = in.readInt();
        market_price = in.readString();
        goods_price = in.readString();
        goods_attr = in.readString();
        goods_thumb = in.readString();
        count = in.readInt();
    }

    public static final Creator<ShopBean> CREATOR = new Creator<ShopBean>() {
        @Override
        public ShopBean createFromParcel(Parcel in) {
            return new ShopBean(in);
        }

        @Override
        public ShopBean[] newArray(int size) {
            return new ShopBean[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(rec_id);
        parcel.writeString(goods_id);
        parcel.writeString(goods_name);
        parcel.writeInt(goods_number);
        parcel.writeString(market_price);
        parcel.writeString(goods_price);
        parcel.writeString(goods_attr);
        parcel.writeString(goods_thumb);
        parcel.writeInt(count);
    }
}
