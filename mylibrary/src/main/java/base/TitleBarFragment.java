package base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import view.DefaultTitleBarView;

/**
 * Created by dengmingzhi on 2016/11/22.
 */

public class TitleBarFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        DefaultTitleBarView defaultTitleBarView = new DefaultTitleBarView(getContext());
        return defaultTitleBarView;
    }
}
