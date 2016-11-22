package com.naiqiao.mall;

import android.os.Bundle;
import android.util.Log;

import com.naiqiao.mall.fragment.IndexBottomFragment;
import com.naiqiao.mall.fragment.IndexContentFragment;

import base.BaseActivity;
import base.TitleBarFragment;
import butterknife.ButterKnife;
import rx.Observable;
import rx.Subscriber;
import rx.functions.Func1;

public class MainActivity extends BaseActivity {
    public static final String LOG_TAG = "LOG_TAG";
    Observable<String> observable;
    Subscriber<String> subscriber;
    private Observable<User> zhang;
    String app_name;
    private MyFragmentRefresh myFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        getSupportFragmentManager().beginTransaction().replace(R.id.fg_bottom,new IndexBottomFragment()).commit();
        getSupportFragmentManager().beginTransaction().replace(R.id.fg_content,new TitleBarFragment()).commit();
    }


    /**
     * rxjava
     * Observable (可观察者，即被观察者)、 Observer (观察者)、 subscribe (订阅)、事件。
     * Observable 和 Observer 通过 subscribe() 方法实现订阅关系，从而 Observable 可以在需要的时候发出事件来通知 Observer。
     */
    private void initRxjava() {

        subscriber = new Subscriber<String>() {
            @Override
            public void onStart() {
                super.onStart();
            }


            @Override
            public void onCompleted() {
                Log.d(LOG_TAG, "执行结束");
            }

            @Override
            public void onError(Throwable e) {
                Log.d(LOG_TAG, e.toString());
            }

            @Override
            public void onNext(String s) {
                Log.d(LOG_TAG, s);
            }
        };

        observable = Observable.create(new Observable.OnSubscribe<String>() {

            @Override
            public void call(Subscriber<? super String> subscriber) {
                subscriber.onNext("你好1");
                subscriber.onNext("你好2");
                subscriber.onNext("你好3");
                subscriber.onCompleted();
            }
        }).map(new Func1<String, String>() {
            @Override
            public String call(String s) {
                return s + s;
            }
        });
//        .subscribeOn(Schedulers.io())// 指定 subscribe() 发生在 IO 线程
//        .observeOn(AndroidSchedulers.mainThread());//指定 Subscriber 的回调发生在主线程
//        String[] words = {"你好1", "你好2", "你好3"};
//        observable = Observable.from(words);//只会在绑定的时候注册一次
//        observable = Observable.just("你好1", "你好2", "你好3");//只会在绑定的时候注册一次


    }


}
