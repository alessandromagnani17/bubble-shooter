package bubbleshooter.view.states;

import bubbleshooter.controller.Controller;
import bubbleshooter.view.scene.controller.GameController;

public abstract class GameState {
	private final GameController gameScene;
	private final Controller controller;

	public GameState(final GameController gameScene, final Controller controller) {
		this.gameScene = gameScene;
		this.controller = controller;
	}

	public abstract void enter();

	public abstract void exit();

	protected GameController getGameScene() {
		return this.gameScene;
	}

	protected Controller getController() {
		return this.controller;
	}
}
