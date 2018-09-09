package com.podskoczy.rx.pool;

import com.podskoczy.rx.pool.attributes.Coordinates;
import io.reactivex.Flowable;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import static com.podskoczy.rx.pool.Color.Black;
import static com.podskoczy.rx.pool.Color.White;

public class Time {

    // [0, 0] - [2.5, 1.5]

    Map<Ball, Coordinates> ballsOnTable = new HashMap<>();

    public static void main(String[] args) {
        Flowable.interval(10, TimeUnit.MILLISECONDS)
                .subscribe();
    }

    public void step() {
        Ball whiteBall = Ball.pool(White);
        Ball blackBall = Ball.pool(Black);

        ballsOnTable.put(whiteBall, Coordinates.of(0.5, 0.5));


    }

}
