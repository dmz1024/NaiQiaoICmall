package interfaces;

import android.webkit.WebView;
import android.widget.ScrollView;

/**
 * Created by dengmingzhi on 16/10/17.
 */

public interface ScrollChangeViewListener {
    void onScrollChanged(ScrollView scrollView, int x, int y, int oldx, int oldy);

}
