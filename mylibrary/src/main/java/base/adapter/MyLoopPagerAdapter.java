package base.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.jude.rollviewpager.RollPagerView;
import com.jude.rollviewpager.adapter.LoopPagerAdapter;

import java.util.ArrayList;

/**
 * Created by dengmingzhi on 2016/12/19.
 */

public class MyLoopPagerAdapter extends LoopPagerAdapter {
    private ArrayList<String> urls;

    public MyLoopPagerAdapter(RollPagerView viewPager, ArrayList<String> urls) {
        super(viewPager);
        this.urls = urls;
    }

    @Override
    public View getView(ViewGroup container, int position) {
        ImageView view = new ImageView(container.getContext());
        view.setScaleType(ImageView.ScaleType.FIT_XY);
        view.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        Glide.with(container.getContext()).load(urls.get(position)).into(view);
        return view;
    }

    @Override
    public int getRealCount() {
        return urls.size();
    }
}
