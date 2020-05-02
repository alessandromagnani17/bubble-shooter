package bubbleshooter.view.scene.controller;

import bubbleshooter.controller.Controller;
import bubbleshooter.view.View;
import bubbleshooter.view.scene.FXMLPath;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class PauseController extends AbstractController {
	
	@FXML private Label titleLabel = new Label();
	@FXML private Button resumeButton = new Button();
	@FXML private Button restartButton = new Button();
	@FXML private Button quitButton = new Button();
	
	@Override
	public final void init(final Controller controller, final View view) {
		super.init(controller, view);
		
		
	}
	
	public void resume() {
		this.getView().loadScene(FXMLPath.GAME);
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
