package com.podskoczy.rx.pool.attributes;

import lombok.Value;

@Value
public class Coordinates {

    private double x;
    private double y;

    public static Coordinates of(double x, double y) {
        return new Coordinates(x, y);
    }

}
