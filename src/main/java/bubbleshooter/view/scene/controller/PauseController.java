package bubbleshooter.view.scene.controller;

import bubbleshooter.controller.Controller;
import bubbleshooter.view.View;
import bubbleshooter.view.scene.FXMLPath;

public class PauseController extends AbstractController {
	
	@Override
	public final void init(final Controller controller, final View view) {
		super.init(controller, view);
		
		
	}

	@Override
	public FXMLPath getNextScene() {
		return FXMLPath.GAME; 
	}

	@Override
	protected FXMLPath getPreviousScene() {
		return FXMLPath.GAME; 
	}

}
