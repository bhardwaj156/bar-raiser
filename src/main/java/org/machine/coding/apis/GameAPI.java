package org.machine.coding.apis;

import org.machine.coding.entities.Point;
import org.machine.coding.services.BattleShipService;

public class GameAPI {

    private final BattleShipService battleShipService;

    public GameAPI() {
        this.battleShipService = new BattleShipService();
    }

    public void init(int N) {
        battleShipService.init(N, N);
    }

    public void addShip(String id, int size, int xA, int yA, int xB, int yB) {
        battleShipService.addShip(id, size, new Point(xA, yA), new Point(xB, yB));
    }

    public void start() {
        battleShipService.start();
    }

    public void viewBattleField(){
        battleShipService.viewBattleField();
    }
}
