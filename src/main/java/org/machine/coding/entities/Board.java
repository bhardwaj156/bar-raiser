package org.machine.coding.entities;

import lombok.Getter;

@Getter
public class Board {
    private final int width;
    private final int height;

    private final Point topLeft;
    private final Point bottomRight;

    public Board(int width, int height) {
        this.width = width;
        this.height = height;
        this.topLeft = new Point(0, 0);
        this.bottomRight = new Point(width, height);
    }

    public boolean isPointInBoard(Point p) {
        return p.liesBetweenPoints(topLeft, bottomRight);
    }
}
