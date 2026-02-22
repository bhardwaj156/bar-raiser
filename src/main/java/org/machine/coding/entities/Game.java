package org.machine.coding.entities;

import lombok.Getter;
import org.machine.coding.exceptions.GameException;
import org.machine.coding.services.FireStrategy;
import org.machine.coding.services.RandomFireStrategy;
import org.machine.coding.services.ViewService;

import java.util.*;

@Getter
public class Game implements ViewService {

    private final Board board;
    private final List<Player> players;
    private final Map<Player, List<Ship>> playerShips;
    private final boolean initialized;
    private final FireStrategy fireStrategy;
    private final Set<Point> firedPoints;

    public Game(Board board) {
        this.board = board;
        this.players = new ArrayList<>();
        this.playerShips = new HashMap<>();
        this.initialized = true;
        this.firedPoints = new HashSet<>();
        this.fireStrategy = new RandomFireStrategy();
    }

    @Override
    public void view() {
        for (int i = 0; i <= board.getWidth(); i++) {
            for (int j = 0; j <= board.getHeight(); j++) {
                System.out.print(getPointName(i, j) + '\t');
            }
            System.out.println();
        }
    }

    private String getPointName(int x, int y) {
        Point p = new Point(x, y);
        for (Player player : players) {
            List<Ship> ships = playerShips.get(player);
            if (ships != null) {
                for (Ship ship : ships) {
                    if (p.liesBetweenPoints(ship.getTopLeft(), ship.getBottomRight())) {
                        return player.getName() + "-" + ship.getId();
                    }
                }
            }
        }
        return ".....";
    }

    public void addPlayer(Player player) {
        if (players.contains(player)) {
            throw new GameException(player.getName() + " already exists");
        }
        this.players.add(player);
    }
}
