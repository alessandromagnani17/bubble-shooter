package bubbleshooter.controller.input;

import java.util.List;

import bubbleshooter.model.gamemodality.GameSwitcher;
import bubbleshooter.model.gameobject.Bubble;

public class SwitcherController {

	private final static double LIMITS_SWITCH = 3;
	private double numSwitch;
    private GameSwitcher gameSwitcher;

    public SwitcherController(List<Bubble> bubbles) {
    	this.gameSwitcher = new GameSwitcher(bubbles);
    	this.setInitialNumSwitch();    
    }

    public final void switchControl() {
        if (!isSwitchEnd()) {
        	this.increasesNumSwitch();
        	this.gameSwitcher.switchBall();
        }
    }

	public void setInitialNumSwitch() {
		this.numSwitch = 0;
	}
	
	public void increasesNumSwitch() {
		this.numSwitch++;
	}
	
	public boolean isSwitchEnd() {
		return this.numSwitch >= LIMITS_SWITCH;
		
	}
}
