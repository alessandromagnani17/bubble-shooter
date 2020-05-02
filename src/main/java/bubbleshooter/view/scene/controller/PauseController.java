package bubbleshooter.view.scene.controller;

import bubbleshooter.view.scene.FXMLPath;

public class PauseController extends AbstractController {

	@Override
	public FXMLPath getNextScene() {
		return FXMLPath.GAME; 
	}

	@Override
	protected FXMLPath getPreviousScene() {
		return FXMLPath.GAME; 
	}

}
