package org.machine.coding;

import org.machine.coding.apis.GameAPI;

public class Main {
    public static void main(String[] args) {

        GameAPI gameAPI = new GameAPI();
        gameAPI.init(6);
        gameAPI.addShip("SH1", 2, 5, 1, 4, 4);
        gameAPI.viewBattleField();
        gameAPI.start();
    }
}