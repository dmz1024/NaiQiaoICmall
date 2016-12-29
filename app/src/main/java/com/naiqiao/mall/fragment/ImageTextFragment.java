package com.naiqiao.mall.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.naiqiao.mall.R;

/**
 * Created by dengmingzhi on 2016/12/29.
 */

public class ImageTextFragment extends Fragment {
    public static ImageTextFragment getInstance(String text) {
        ImageTextFragment fragment = new ImageTextFragment();
        Bundle bundle = new Bundle();
        bundle.putString("text", text);
        fragment.setArguments(bundle);
        return fragment;
    }

    private String text;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = getArguments();
        if (bundle != null) {
            text = bundle.getString("text");
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = View.inflate(container.getContext(), R.layout.fragment_iamge_text, null);
        TextView tv_content = (TextView) view.findViewById(R.id.tv_content);
        tv_content.setText(!TextUtils.isEmpty(text) ? text : "继续拖动查看图文详情");
        return view;
    }
}
