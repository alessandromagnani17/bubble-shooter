package bubbleshooter.view.scene.controller;

import bubbleshooter.view.scene.FXMLPath;

public class GameOverController extends AbstractController {

	@Override
	public FXMLPath getNextScene() {
		return FXMLPath.HIGHSCORE;
	}

	@Override
	protected FXMLPath getPreviousScene() {
		return FXMLPath.GAME;
	}

}
