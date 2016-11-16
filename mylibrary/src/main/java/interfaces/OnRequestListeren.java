package interfaces;

/**
 * Created by dengmingzhi on 2016/11/15.
 */

public interface OnRequestListeren<T> {
    void succes(T bean);

    void error(String msg);
}
