package org.machine.coding.services;

import lombok.AllArgsConstructor;
import org.machine.coding.entities.*;
import org.machine.coding.exceptions.GameException;

import java.util.ArrayList;

@AllArgsConstructor
public class BattleShipService {
    private Game game;
    private GameEngine gameEngine;

    public BattleShipService(){}

    public void init(int width, int height) {
        this.game = new Game(new Board(width, height));
        this.gameEngine = new GameEngine(game);
    }

    public void addShip(String id, int size, Point positionA, Point positionB) {
        Player a = new Player("A", new Point(0, 0), new Point(game.getBoard().getWidth(),  game.getBoard().getHeight()/2));
        addShipAndPlayer(id, size, positionA, a);

        Player b = new Player("B", new Point(0, game.getBoard().getHeight()/2), new Point(game.getBoard().getWidth(), game.getBoard().getHeight()));
        addShipAndPlayer(id, size, positionB, b);
    }

    private void addShipAndPlayer(String id, int size, Point positionA, Player a) {
        game.addPlayer(a);
        game.getPlayerShips().putIfAbsent(a, new ArrayList<>());
        Ship shipA = new Ship(id, size, positionA);
        game.getPlayerShips().get(a).add(shipA);

        if(!shipA.getTopLeft().liesBetweenPoints(game.getBoard().getTopLeft(), game.getBoard().getBottomRight())
        || !shipA.getBottomRight().liesBetweenPoints(game.getBoard().getTopLeft(), game.getBoard().getBottomRight())) {
            throw new GameException("Ship " + shipA.getId() + " going out of board");
        }
    }

    public void start() {
        gameEngine.startGame();
    }

    public void viewBattleField(){
        game.view();
    }
}
