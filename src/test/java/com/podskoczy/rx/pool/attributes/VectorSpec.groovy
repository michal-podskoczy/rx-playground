package com.podskoczy.rx.pool.attributes

import spock.lang.Specification

class VectorSpec extends Specification {

    def "two vectors can be added"() {
        given:
        Vector v1 = Vector.of(10, 5)
        Vector v2 = Vector.of(-5, 10)

        when:
        Vector resultVector = v1.add(v2)

        then:
        resultVector == Vector.of(5, 15)
    }


}
