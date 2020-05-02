package bubbleshooter.view.scene.controller;

import bubbleshooter.controller.Controller;
import bubbleshooter.utility.Settings;
import bubbleshooter.view.View;
import bubbleshooter.view.scene.FXMLPath;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.text.Font;

public class GameOverController extends AbstractController {
	
	@FXML private Label gameOverLabel = new Label();
	@FXML private Label scoreLabel = new Label();
	@FXML private Label scoreLabelToWrite = new Label();
	@FXML private Label destroyedBubbleLabel = new Label();
	@FXML private Label destroyedBubbleLabelToWrite = new Label();
	@FXML private Label gameTimeLabel = new Label();
	@FXML private Label gameTimeLabelToWrite = new Label();
	@FXML private TextArea textArea = new TextArea();
	@FXML private Button buttonAdd = new Button();
	
	private static final double TITLE_DISTANCE = Settings.getGuiHeigth()/10;
	private static final double TITLE_HEIGTH = Settings.getGuiHeigth()/8;
	private static final double TITLE_WIDTH = Settings.getGuiWidth();
	private static final double TITLE_FONT_SIZE = TITLE_HEIGTH/1.5;
	
	
	@Override
	public final void init(final Controller controller, final View view) {
		super.init(controller, view);
		
		this.gameOverLabel.setText("Game Over");
		this.gameOverLabel.setFont(Font.font(TITLE_FONT_SIZE));
		this.gameOverLabel.setAlignment(Pos.BOTTOM_CENTER);
		this.gameOverLabel.setPrefSize(TITLE_WIDTH, TITLE_HEIGTH);
		
		
		
		/*this.scoreLabel.setText(String.valueOf(this.getController().getScore()));
		this.destroyedBubbleLabel.setText(String.valueOf(this.getController().getDestroyedBubbles()));
		this.gameTimeLabel.setText(String.valueOf(this.getController().getGameTime()));*/
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
