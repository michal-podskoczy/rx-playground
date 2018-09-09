package com.podskoczy.rx.pool;


import lombok.Getter;

@Getter
public abstract class PhysicalBody {

    private double weight;

    protected PhysicalBody(double weight) {
        this.weight = weight;
    }

}
