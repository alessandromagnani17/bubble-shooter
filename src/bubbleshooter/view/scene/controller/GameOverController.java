package bubbleshooter.view.scene.controller;

import java.net.URL;
import java.util.ResourceBundle;

import bubbleshooter.view.scene.FXMLPath;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;

public class GameOverController extends AbstractController implements Initializable {
	
	@FXML private TextArea textArea;

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
		}
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
	}

}
