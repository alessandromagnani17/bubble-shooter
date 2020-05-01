package bubbleshooter.view.scene.controller;

import bubbleshooter.controller.Controller;
import bubbleshooter.view.View;
import bubbleshooter.view.scene.FXMLPath;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

public class GameOverController extends AbstractController {
	
	@FXML private TextArea textArea = new TextArea();
	@FXML private Label scoreLabel = new Label();
	
	@Override
	public final void init(final Controller controller, final View view) {
		super.init(controller, view);
		this.scoreLabel.setText(String.valueOf(this.getController().getScore()));
	}
	
	@Override
	public FXMLPath getNextScene() {
		return FXMLPath.HIGHSCORE;
	}

	@Override
	protected FXMLPath getPreviousScene() {
		return FXMLPath.GAME;
	}
	
	public void addToHighscore() {
		if(!this.textArea.getText().isEmpty()) {
			this.getController().saveScore(this.textArea.getText());
			this.nextScene();
		}
	}

}
