package shop.haoshi.client.fragment.index;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.View;

import java.util.ArrayList;

import base.fragment.NotNetWorkBaseFragment;
import butterknife.BindView;
import rx.Observable;
import rx.functions.Action1;
import shop.haoshi.client.R;
import util.RxBus;
import view.NoScrollViewPager;

/**
 * Created by dengmingzhi on 2016/11/22.
 */

public class IndexOneContentFragment extends NotNetWorkBaseFragment {
    @BindView(R.id.vp_content)
    NoScrollViewPager vp_content;
    ArrayList<Fragment> fragments;
    Observable<Integer> indexOneTabChange;

    @Override
    protected int getRId() {
        return R.layout.no_scroll_view_pager;
    }

    @Override
    protected View getTitleBarView() {
        return null;
    }

    @Override
    protected void initData() {
        fragments = new ArrayList<>();
        fragments.add(new Fragment());
        fragments.add(new Fragment());
        fragments.add(new Fragment());
        fragments.add(new Fragment());
        vp_content.setOffscreenPageLimit(fragments.size());
        vp_content.setAdapter(new FragmentPagerAdapter(getChildFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return fragments.get(position);
            }

            @Override
            public int getCount() {
                return fragments.size();
            }
        });

        changePager();
    }


    private void changePager() {
        indexOneTabChange = RxBus.get().register("indexOneTabChange", Integer.class);
        indexOneTabChange.subscribe(new Action1<Integer>() {
            @Override
            public void call(Integer integer) {
                vp_content.setCurrentItem(integer, false);
            }
        });
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        RxBus.get().unregister("indexOneTabChange", indexOneTabChange);
    }


    public int currentPosition() {
        return vp_content.getCurrentItem();
    }

    @Override
    protected String getBackColor() {
        return "#ffffff";
    }
}
