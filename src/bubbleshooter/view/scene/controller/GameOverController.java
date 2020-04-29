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
	@FXML private Button addButton;
	private HighscoreStoreImpl highscoreStore = new HighscoreStoreImpl();
	
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
			// Da creare e aggiungere l'highscore
			// HighscoreStructure store = new HighscoreStructure(this.textArea.getText(), , LevelTypes.SURVIVALMODE)
			// this.highscoreStore.addScore(LevelTypes.SURVIVALMODE, store);
			HighscoreStructure store = new HighscoreStructure(this.textArea.getText(), 2500, LevelTypes.BASICMODE);
			this.highscoreStore.addScore(store);
			
			this.nextScene();
		}
	}

}
