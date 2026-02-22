package org.machine.coding.services;

import org.machine.coding.entities.Point;

import java.util.Set;

public interface FireStrategy {
    public Point fireBetweenExcept(Point topLeft, Point bottomRight, Set<Point> firedPoints);
}
