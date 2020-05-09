package bubbleshooter.view.states;

import bubbleshooter.controller.Controller;
import bubbleshooter.view.scene.controller.GameController;

public class InPauseState extends GameState {

    public InPauseState(final GameController gameScene, final Controller controller) {
        super(gameScene, controller);
    }

    @Override
    public final void enter() {
        this.getController().getGameEngine().pauseLoop();
    }

    @Override
    public final void exit() {
        this.getController().getGameEngine().resumeLoop();
    }
}
