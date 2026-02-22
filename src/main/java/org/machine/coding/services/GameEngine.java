package org.machine.coding.services;

import lombok.AllArgsConstructor;
import org.machine.coding.entities.Game;
import org.machine.coding.entities.Player;
import org.machine.coding.entities.Point;
import org.machine.coding.entities.Ship;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
public class GameEngine {
    private Game game;

    public void startGame() {
        while (true) {
            for (Player player : game.getPlayers()) {
                turn(player);
                if(hasPlayerWon(player))
                    return;
            }
        }
    }

    private boolean hasPlayerWon(Player player) {
        for (Player opponent : game.getPlayers()) {
            if(!opponent.equals(player) && !getPlayerShips(opponent).isEmpty()) {
                return false;
            }
        }
        System.out.println(player.getName() + " won");
        return true;
    }

    private void turn(Player player) {
        for (Player opponent : game.getPlayers()) {
            if (!opponent.equals(player)) {
                List<Ship> ships = getPlayerShips(opponent);
                Ship destroyedShip = null;
                Point firePoint = game.getFireStrategy().fireBetweenExcept(opponent.getTopLeft(), opponent.getBottomRight(), game.getFiredPoints());
                game.getFiredPoints().add(firePoint);
                for (Ship ship : ships) {
                    if (firePoint.liesBetweenPoints(ship.getTopLeft(), ship.getBottomRight())) {
                        destroyedShip =  ship;
                        break;
                    }
                }
                if (destroyedShip != null) {
                    System.out.println(player.getName() + " destroyed player " + opponent.getName() + "'s ship " + destroyedShip.getId());
                    ships.remove(destroyedShip);
                }
            }
        }
    }

    private List<Ship> getPlayerShips(Player player) {
        List<Ship> ships = game.getPlayerShips().get(player);
        if (ships == null) {
            ships = new ArrayList<>();
        }
        return ships;
    }
}
