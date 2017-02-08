package com.naiqiao.mall.bean;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

/**
 * Created by dengmingzhi on 2017/2/7.
 */

public class AffirmGoPayBean implements Parcelable {
    public String address_id;
    public String address;
    public String postscript;
    public String surplus;
    public String inv_type;
    public String inv_content;
    public String inv_payee;
    public String fp_content;
    public int type;
    public int need_inv;
    public ArrayList<ShopBean> shops;
    public int count;
    public String price;

    public AffirmGoPayBean() {
    }

    public AffirmGoPayBean(Parcel in) {
        address_id = in.readString();
        address = in.readString();
        postscript = in.readString();
        surplus = in.readString();
        inv_type = in.readString();
        inv_content = in.readString();
        inv_payee = in.readString();
        fp_content = in.readString();
        type = in.readInt();
        need_inv = in.readInt();
        count = in.readInt();
        price = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(address_id);
        dest.writeString(address);
        dest.writeString(postscript);
        dest.writeString(surplus);
        dest.writeString(inv_type);
        dest.writeString(inv_content);
        dest.writeString(inv_payee);
        dest.writeString(fp_content);
        dest.writeInt(type);
        dest.writeInt(need_inv);
        dest.writeInt(count);
        dest.writeString(price);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<AffirmGoPayBean> CREATOR = new Creator<AffirmGoPayBean>() {
        @Override
        public AffirmGoPayBean createFromParcel(Parcel in) {
            return new AffirmGoPayBean(in);
        }

        @Override
        public AffirmGoPayBean[] newArray(int size) {
            return new AffirmGoPayBean[size];
        }
    };
}
