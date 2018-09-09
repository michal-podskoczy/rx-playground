package com.podskoczy.rx.pool.attributes;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@AllArgsConstructor(staticName = "of")
@ToString
@EqualsAndHashCode
public class Vector {
    private final double x;
    private final double y;

    public Vector add(Vector anotherVector) {
        return Vector.of(this.x + anotherVector.x, this.y + anotherVector.y);
    }

}
