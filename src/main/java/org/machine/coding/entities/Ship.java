package org.machine.coding.entities;

import lombok.Getter;

import java.util.Objects;

@Getter
public class Ship {
    private final String id;
    private final Point position;
    private final int size;
    private final Point topLeft;
    private final Point bottomRight;

    public Ship(String id, int size, Point position) {
        this.id = id;
        this.position = position;
        this.size = size;
        int half = size/2;
        this.topLeft = new Point(position.getX() - half, position.getY() - half);
        this.bottomRight = new Point(position.getX() + half, position.getY() + half);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Ship ship = (Ship) o;
        return Objects.equals(id, ship.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
