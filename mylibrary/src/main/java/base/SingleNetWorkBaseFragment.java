package base;


/**
 * Created by dengmingzhi on 16/11/21.
 */

public abstract class SingleNetWorkBaseFragment<D extends BaseBean> extends NetworkBaseFragment<D> {

    @Override
    protected ShowCurrentViewENUM getDefaultView() {
        return ShowCurrentViewENUM.VIEW_IS_LOADING;
    }


    @Override
    protected void writeData(boolean isWrite, D bean) {
        if (!isWrite) {
            stopRefresh();
        }
    }
}
