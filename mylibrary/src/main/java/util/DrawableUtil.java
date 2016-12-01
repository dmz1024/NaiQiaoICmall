package util;

import android.graphics.drawable.Drawable;

/**
 * Created by dengmingzhi on 2016/12/1.
 */

public class DrawableUtil {
    public static Drawable setBounds(Drawable drawable){
        drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
        return drawable;
    }
}
