package org.machine.coding.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Objects;

@AllArgsConstructor
@Getter
public class Player {
    private final String name;
    private Point topLeft;
    private Point bottomRight;

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return name == player.name;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }
}
