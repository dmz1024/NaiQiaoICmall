package base;

import com.yolanda.nohttp.error.NetworkError;
import com.yolanda.nohttp.error.ServerError;
import com.yolanda.nohttp.error.TimeoutError;

/**
 * Created by dengmingzhi on 16/10/11.
 */

public abstract class SingleNetWorkBaseFragment<D extends BaseBean> extends NetworkBaseFragment<D> {

    @Override
    protected ShowCurrentViewENUM getDefaultView() {
        return ShowCurrentViewENUM.VIEW_IS_LOADING;
    }

    
}
