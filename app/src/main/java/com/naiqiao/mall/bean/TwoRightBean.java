package com.naiqiao.mall.bean;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

import base.bean.ListBaseBean;

/**
 * Created by dengmingzhi on 2016/11/24.
 */

public class TwoRightBean extends ListBaseBean<ArrayList<TwoRightBean.Data>> {

    public static class Data {
        public int type;
        public String title;
        public String othername;
        public ArrayList<Data1Bean> data1;
        public ArrayList<Data2Bean> data2;
        public ArrayList<Data3Bean> data3;
        public boolean isCreat;

        public static class Data1Bean {
            public String ad_image;
        }

        public static class Data2Bean {
            public String brand_id;
            public String brand_name;
            public String brand_logo;

        }

        public static class Data3Bean implements Parcelable {
            public String id;
            public String name;
            public String othername;
            public String cat_image;

            protected Data3Bean(Parcel in) {
                id = in.readString();
                name = in.readString();
                othername = in.readString();
                cat_image = in.readString();
            }

            public static final Creator<Data3Bean> CREATOR = new Creator<Data3Bean>() {
                @Override
                public Data3Bean createFromParcel(Parcel in) {
                    return new Data3Bean(in);
                }

                @Override
                public Data3Bean[] newArray(int size) {
                    return new Data3Bean[size];
                }
            };

            @Override
            public int describeContents() {
                return 0;
            }

            @Override
            public void writeToParcel(Parcel dest, int flags) {
                dest.writeString(id);
                dest.writeString(name);
                dest.writeString(othername);
                dest.writeString(cat_image);
            }
        }
    }
}
