package com.podskoczy.rx.examples;

import io.reactivex.Flowable;
import io.reactivex.schedulers.Schedulers;

import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;

public class AnotherExample {

    public static void main(String[] args) throws InterruptedException {

        System.out.println(Thread.currentThread().getName());

        Flowable
                .interval(1,1, TimeUnit.SECONDS)
                .map(i -> i * 3)
                .flatMap(second -> giveMeStrings(second))
                .subscribe(System.out::println);

                //.subscribe(System.out::println);

        Thread.sleep(10000);
    }

    private static Flowable<String> giveMeStrings(Long i) {
        return Flowable
                .just(i)
                .subscribeOn(Schedulers.computation())
                .map(s -> {
                    Thread.sleep(3000);
                    System.out.println("Mapping on: ");
                    System.out.println(Thread.currentThread().getName());
                    return "string " + s;
                });
    }

    Consumer<String> consumer = s -> {
        System.out.println(Thread.currentThread().getName());
        System.out.println(s);
    };

}
