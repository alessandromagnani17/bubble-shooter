package bubbleshooter.controller.input;

import java.util.List;

import bubbleshooter.model.bubble.Bubble;
import bubbleshooter.model.game.GameSwitcher;

public class SwitcherController {

    private static final double LIMITS_SWITCH = 3;
    private double numSwitch;
    private GameSwitcher gameSwitcher;
    private List<Bubble> bubbles;

    public SwitcherController(final List<Bubble> bubbles) {
        this.bubbles = bubbles;
        this.gameSwitcher = new GameSwitcher(this.bubbles);
        this.setInitialNumSwitch();
    }

    public final void switchControl() {
        if (!isSwitchEnd()) {
            this.increasesNumSwitch();
            this.gameSwitcher.switchBall();
        }
    }

    public final void setInitialNumSwitch() {
        this.numSwitch = 0;
    }

    public final void increasesNumSwitch() {
        this.numSwitch++;
    }

    public final boolean isSwitchEnd() {
        return this.numSwitch >= LIMITS_SWITCH;
    }

    public final void setBubbles(final List<Bubble> bubbles) {
        this.bubbles = bubbles;
        this.gameSwitcher = new GameSwitcher(this.bubbles);
    }
}
