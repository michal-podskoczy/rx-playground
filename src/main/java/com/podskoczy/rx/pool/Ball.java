package com.podskoczy.rx.pool;

import com.podskoczy.rx.pool.attributes.Vector;
import lombok.Getter;

@Getter
public class Ball extends PhysicalBody {

    public static final double DEFAULT_WEIGHT = 0.5;

    public static final double DEFAULT_RADIUS = 0.0285;

    private double radius;

    private Color color;

    private Vector speed;

    public static Ball pool(Color color) {
        return new Ball(DEFAULT_WEIGHT, DEFAULT_RADIUS, color);
    }

    protected Ball(double weight, double radius, Color color) {
        super(weight);
        this.radius = radius;
        this.color = color;
    }

}
