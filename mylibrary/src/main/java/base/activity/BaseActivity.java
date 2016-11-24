package base.activity;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

/**
 * Created by dengmingzhi on 2016/11/22.
 */

public class BaseActivity extends AppCompatActivity {
    protected void setShowBar(View view) {
        RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) view.getLayoutParams();
        params.height = getStatusBarHeight();
        view.setLayoutParams(params);
    }

    /**
     * 获取状态栏高度
     *
     * @return
     */
    public int getStatusBarHeight() {
        int result = 0;
        int resourceId = getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0) {
            result = getResources().getDimensionPixelSize(resourceId);
        }
        return result;
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        if (ev.getAction() == MotionEvent.ACTION_DOWN) {
            View v = getCurrentFocus();
            if (isShouldHideInput(v, ev)) {

                InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                if (imm != null) {
                    imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
                }
            }
            return super.dispatchTouchEvent(ev);
        }
        // 必不可少，否则所有的组件都不会有TouchEvent了
        if (getWindow().superDispatchTouchEvent(ev)) {
            return true;
        }
        return onTouchEvent(ev);
    }


    public  boolean isShouldHideInput(View v, MotionEvent event) {
        if (v != null && (v instanceof EditText)) {
            int[] leftTop = { 0, 0 };
            //获取输入框当前的location位置
            v.getLocationInWindow(leftTop);
            int left = leftTop[0];
            int top = leftTop[1];
            int bottom = top + v.getHeight();
            int right = left + v.getWidth();
            if (event.getX() > left && event.getX() < right
                    && event.getY() > top && event.getY() < bottom) {
                // 点击的是输入框区域，保留点击EditText的事件
                return false;
            } else {
                return true;
            }
        }
        return false;
    }


    /**
     * rxjava
     * Observable (可观察者，即被观察者)、 Observer (观察者)、 subscribe (订阅)、事件。
     * Observable 和 Observer 通过 subscribe() 方法实现订阅关系，从而 Observable 可以在需要的时候发出事件来通知 Observer。
     */
//    private void initRxjava() {

//        subscriber = new Subscriber<String>() {
//            @Override
//            public void onStart() {
//                super.onStart();
//            }
//
//
//            @Override
//            public void onCompleted() {
//                Log.d(LOG_TAG, "执行结束");
//            }
//
//            @Override
//            public void onError(Throwable e) {
//                Log.d(LOG_TAG, e.toString());
//            }
//
//            @Override
//            public void onNext(String s) {
//                Log.d(LOG_TAG, s);
//            }
//        };
//
//        observable = Observable.create(new Observable.OnSubscribe<String>() {
//
//            @Override
//            public void call(Subscriber<? super String> subscriber) {
//                subscriber.onNext("你好1");
//                subscriber.onNext("你好2");
//                subscriber.onNext("你好3");
//                subscriber.onCompleted();
//            }
//        }).map(new Func1<String, String>() {
//            @Override
//            public String call(String s) {
//                return s + s;
//            }
//        });
//        .subscribeOn(Schedulers.io())// 指定 subscribe() 发生在 IO 线程
//        .observeOn(AndroidSchedulers.mainThread());//指定 Subscriber 的回调发生在主线程
//        String[] words = {"你好1", "你好2", "你好3"};
//        observable = Observable.from(words);//只会在绑定的时候注册一次
//        observable = Observable.just("你好1", "你好2", "你好3");//只会在绑定的时候注册一次


//    }
}
