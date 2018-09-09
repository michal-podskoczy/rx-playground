package com.podskoczy.rx.examples.agiledeveloper._02_rxjava_flowable;

import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.FlowableEmitter;

public class Sample {
    public static void main(String[] args) {
        Flowable.<Integer>create(emitter -> emit(emitter), BackpressureStrategy.BUFFER)
                .map(data -> data * 1.0)
                .filter(data -> data > 4)
                .subscribe(System.out::println);

        /*Flowable.<Integer>create(emitter -> emit(emitter), BackpressureStrategy.BUFFER)
                .map(data -> data * 1.0)
                .filter(data -> data > 4)
                .subscribe(new FlowableSubscriber<Double>() {
                    @Override
                    public void onSubscribe(Subscription s) {
                        System.out.println("On subscribe");
                    }

                    @Override
                    public void onNext(Double aDouble) {
                        System.out.println(aDouble);
                    }

                    @Override
                    public void onError(Throwable throwable) {
                        System.out.println("Error");
                    }

                    @Override
                    public void onComplete() {
                        System.out.println("Complete");
                    }
                });*/
    }

    private static void emit(FlowableEmitter<Integer> emitter) throws InterruptedException {


        int count = 0;

        while (count < 20) {
            emitter.onNext(count++);
            Thread.sleep(500);
        }
    }
}
