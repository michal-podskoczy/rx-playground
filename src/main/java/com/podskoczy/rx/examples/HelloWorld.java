package com.podskoczy.rx.examples;

import io.reactivex.*;
import io.reactivex.observers.DisposableSingleObserver;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;

import static java.lang.Thread.sleep;

public class HelloWorld {

    public static void main(String[] args) throws InterruptedException {

        Flowable.just("Hello flowable.")
                .delay(500, TimeUnit.MILLISECONDS)
                .subscribe(HelloWorld::print);

        Observable.just("Hello observable", "Another observable")
                .delay(1000, TimeUnit.MILLISECONDS)
                .subscribe(HelloWorld::print);

        Single.just("Single")
                .delay(1500, TimeUnit.MILLISECONDS)
                .subscribeWith(new DisposableSingleObserver<String>() {
                    @Override
                    public void onSuccess(String s) {
                        HelloWorld.print(s);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }
                });

        // Completable
        // Maybe

        sleep(5000);
    }

    static void print(String payload) {
        LocalTime now = LocalTime.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ISO_TIME;
        System.out.println(dateTimeFormatter.format(now) + ": " + payload);
    }

}
