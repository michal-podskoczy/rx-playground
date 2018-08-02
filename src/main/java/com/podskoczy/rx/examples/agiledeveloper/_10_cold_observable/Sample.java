package com.podskoczy.rx.examples.agiledeveloper._10_cold_observable;

import io.reactivex.Flowable;

import java.util.concurrent.TimeUnit;

public class Sample {
    public static void main(String[] args) throws InterruptedException {
        Flowable<Long> interval =
                Flowable.interval(1, TimeUnit.SECONDS);

        interval.subscribe(data -> printMessage("s1:" + data));

        Thread.sleep(5000);

        interval.subscribe(data -> printMessage("s2:" + data));

        Thread.sleep(10000);
    }

    private static void printMessage(String message) {
        System.out.println(message);
    }
}
