package org.machine.coding.services;

import org.machine.coding.entities.Point;

import java.util.Set;

public class RandomFireStrategy implements FireStrategy {

    @Override
    public Point fireBetweenExcept(Point topLeft, Point bottomRight, Set<Point> firedPoints) {
        int width = bottomRight.getX() - topLeft.getX();
        int height = bottomRight.getY() - topLeft.getY();
        int totalCells = width * height;
        int MAX_ATTEMPTS = 100;

        for (int i = 0; i < MAX_ATTEMPTS; i++) {
            int x = (int) (topLeft.getX() + (Math.random() * width));
            int y = (int) (topLeft.getY() + (Math.random() * height));
            Point p = new Point(x, y);
            if (firedPoints.contains(p)) {
                continue;
            }
            return p;
        }
        return null;
    }
}
