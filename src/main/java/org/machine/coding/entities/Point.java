package org.machine.coding.entities;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@AllArgsConstructor
@Getter
@EqualsAndHashCode
public class Point {

    private int x;
    private int y;

    public boolean liesBetweenPoints(Point p1, Point p2) {
        return x >= p1.x && x <= p2.x && y >= p1.y && y <= p2.y;
    }
}
