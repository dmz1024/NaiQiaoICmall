package com.naiqiao.mall.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.naiqiao.mall.R;

import java.util.ArrayList;

import util.DrawableUtil;
import util.Util;

/**
 * Created by dengmingzhi on 2016/12/15.
 */

public class ViewProgress extends FrameLayout {
    private LinearLayout ll_title;
    private String title;
    private String color;
    private String colored;
    private String[] titles;
    private int drawableRid;
    private int drawableRided;
    private int min;
    private Drawable d;
    private Drawable ded;
    private int width;
    private int count;
    private ArrayList<View> views = new ArrayList<>();
    private ArrayList<TextView> textViews = new ArrayList<>();
    private int currentPosition;
    private float textSize;

    public ViewProgress(Context context) {
        this(context, null);
    }

    public ViewProgress(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context, attrs);
    }

    private void initView(Context context, AttributeSet attrs) {
        TypedArray typedArray = getContext().obtainStyledAttributes(attrs, R.styleable.ViewProgress);
        currentPosition = typedArray.getInt(R.styleable.ViewProgress_ViewProgressPosition, 0);
        title = typedArray.getString(R.styleable.ViewProgress_ViewProgressTextcontent);
        textSize = typedArray.getFloat(R.styleable.ViewProgress_ViewProgressTextsize, 12);
        color = typedArray.getString(R.styleable.ViewProgress_ViewProgressTextColor);
        colored = typedArray.getString(R.styleable.ViewProgress_ViewProgressTextColorEd);
        drawableRid = typedArray.getResourceId(R.styleable.ViewProgress_ViewProgressDrawable, 0);
        drawableRided = typedArray.getResourceId(R.styleable.ViewProgress_ViewProgressDrawableEd, 0);
        typedArray.recycle();
        d = DrawableUtil.setBounds(getResources().getDrawable(drawableRid));
        ded = DrawableUtil.setBounds(getResources().getDrawable(drawableRided));
        min = d.getMinimumWidth();

        width = Util.getWidth();
        startView();
    }

    private void startView() {
        if (!TextUtils.isEmpty(title)) {
            titles = title.split(",");
            count = titles.length;
            setBackgroundColor(Color.parseColor("#ffffff"));
            creatLLView();
            creatTextView();
            creatView();
        }
    }


    public void setTitle(String title) {
        this.title = title;
        startView();
    }

    private void creatView() {
        int j = 2 * count - 2;
        int w = width / (2 * count) - min / 2;
        for (int i = 0; i < j; i++) {
            View viwe = new View(getContext());
            viwe.setBackgroundColor(Color.parseColor(i <= 2 * currentPosition ? colored : color));
            FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(w, 2);
            int left = (width * (i + 1) / (2 * count)) + (i % 2 == 0 ? min / 2 : 0);
            params.setMargins(left, 0, 0, 15 + min / 2);
            params.gravity = Gravity.BOTTOM;
            viwe.setLayoutParams(params);
            views.add(viwe);
            addView(viwe);
        }
    }


    public void setCurrentPosition(int currentPosition) {
        this.currentPosition = currentPosition;
        if (TextUtils.isEmpty(title)) {
            return;
        }
        removeAllViews();
        startView();
//        int drawCount = currentPosition + 1 == count ? 2 * currentPosition : currentPosition * 2 + 1;
//        for (int i = 2 * currentPosition - 1; i < drawCount; i++) {
//            views.get(i).setBackgroundColor(Color.parseColor(colored));
//        }
//        textViews.get(currentPosition).setTextColor(Color.parseColor(colored));
//        textViews.get(currentPosition).setCompoundDrawables(null, null, null, ded);
    }


    private void creatTextView() {
        for (int i = 0; i < count; i++) {
            TextView tv = new TextView(getContext());
            tv.setText(titles[i]);
            tv.setTextSize(textSize);
            tv.setGravity(Gravity.CENTER_HORIZONTAL);
            tv.setTextColor(Color.parseColor(i <= currentPosition ? colored : color));
            tv.setCompoundDrawables(null, null, null, i <= currentPosition ? ded : d);
            tv.setCompoundDrawablePadding(10);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(0, ViewGroup.LayoutParams.WRAP_CONTENT, 1);
            tv.setLayoutParams(params);
            textViews.add(tv);
            ll_title.addView(tv);

        }
    }

    private void creatLLView() {
        ll_title = new LinearLayout(getContext());
        ll_title.setWeightSum(titles.length);
        ll_title.setOrientation(LinearLayout.HORIZONTAL);
        ll_title.setPadding(0, 15, 0, 15);
        addView(ll_title);
    }
}
