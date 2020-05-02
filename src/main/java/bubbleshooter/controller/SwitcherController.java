package bubbleshooter.controller;

import bubbleshooter.model.gamemodality.GameSwitcher;

public class SwitcherController {

    private GameSwitcher gameSwitcher;

    public SwitcherController() {
    }

    public final void switchControl() {
    	//this.gameSwitcher = new GameSwitcher();
        this.gameSwitcher.switchBall();
    }
}
