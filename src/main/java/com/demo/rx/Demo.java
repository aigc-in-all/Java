package com.demo.rx;

import rx.Observable;
import rx.Observable.OnSubscribe;
import rx.functions.Func1;
import rx.Subscriber;

public class Demo {

    public static void main(String[] args) {
        Observable<String> myObservable = Observable.create(new OnSubscribe<String>() {

            @Override
            public void call(Subscriber<? super String> sub) {
                sub.onNext("Hello, world!");
                sub.onCompleted();
            }
        });
        
        Subscriber<String> mySubscriber = new Subscriber<String>() {

            @Override
            public void onCompleted() {
                
            }

            @Override
            public void onError(Throwable e) {
                
            }

            @Override
            public void onNext(String t) {
                System.out.println(t);
            }
        };
        
//        myObservable.subscribe(mySubscriber);
        myObservable.map(new Func1<String, String>() {

            @Override
            public String call(String t) {
                return t + " -Dan";
            }
        }).subscribe(mySubscriber);
    }
}
