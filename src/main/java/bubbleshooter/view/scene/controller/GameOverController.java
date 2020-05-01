package bubbleshooter.view.scene.controller;

import bubbleshooter.model.gamemodality.LevelTypes;
import bubbleshooter.model.highscore.HighscoreStoreImpl;
import bubbleshooter.model.highscore.HighscoreStructure;
import bubbleshooter.view.scene.FXMLPath;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

public class GameOverController extends AbstractController {
	
	@FXML private TextArea textArea = new TextArea();
	
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
