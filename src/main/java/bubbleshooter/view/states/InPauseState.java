package bubbleshooter.view.states;

import bubbleshooter.controller.Controller;
import bubbleshooter.view.scene.controller.GameController;

public class InPauseState extends GameState {

	public InPauseState(GameController gameScene, Controller controller) {
		super(gameScene, controller);
	}

	@Override
	public void enter() {
		this.getController().getGameEngine().pauseLoop();

	}

	@Override
	public void exit() {
		this.getController().getGameEngine().resumeLoop();

	}

}
