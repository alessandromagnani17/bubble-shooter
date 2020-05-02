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
	@FXML private Label destroyedBubbleLabel = new Label();
	@FXML private Label gameTimeLabel = new Label();
	@FXML private TextArea textArea = new TextArea();
	@FXML private Button buttonAdd = new Button();
	
	private static final double TITLE_DISTANCE = Settings.getGuiHeigth()/10;
	private static final double TITLE_HEIGTH = Settings.getGuiHeigth()/8;
	private static final double TITLE_WIDTH = Settings.getGuiWidth();
	private static final double TITLE_FONT_SIZE = TITLE_HEIGTH/1.5;
	private static final double LABEL_HEIGTH = Settings.getGuiHeigth()/10;
	private static final double LABEL_WIDTH = Settings.getGuiWidth();
	private static final double LABEL_X = Settings.getGuiWidth()/2 - LABEL_WIDTH/4;
	private static final double LABEL_DISTANCE = Settings.getGuiHeigth()/10;
	private static final double LABEL_FONT_SIZE = LABEL_HEIGTH/2;
	private static final double TEXT_AREA_HEIGTH = LABEL_HEIGTH;
	private static final double TEXT_AREA_WIDTH = Settings.getGuiWidth()/2;
	private static final double BUTTON_WIDTH = Settings.getGuiWidth()/2;
	private static final double BUTTON_HEIGTH = Settings.getGuiHeigth()/10;
	private static final double BUTTON_FONT_SIZE = BUTTON_HEIGTH/2.5;
	
	
	@Override
	public final void init(final Controller controller, final View view) {
		super.init(controller, view);
		this.getController().getGameEngine().stopLoop();
		this.gameOverLabel.setText("Game Over");
		this.gameOverLabel.setFont(Font.font(TITLE_FONT_SIZE));
		this.gameOverLabel.setAlignment(Pos.BOTTOM_CENTER);
		this.gameOverLabel.setPrefSize(TITLE_WIDTH, TITLE_HEIGTH);
		
		this.scoreLabel.setText("Your score: " + String.valueOf(this.getController().getScore()));
		this.scoreLabel.setFont(Font.font(LABEL_FONT_SIZE));
		this.scoreLabel.setLayoutX(LABEL_X);
		this.scoreLabel.setLayoutY(TITLE_HEIGTH + TITLE_DISTANCE);
		this.scoreLabel.setPrefSize(LABEL_WIDTH, LABEL_HEIGTH);
		
		this.destroyedBubbleLabel.setText("Destroyed bubbles: " + String.valueOf(this.getController().getDestroyedBubbles()));
		this.destroyedBubbleLabel.setFont(Font.font(LABEL_FONT_SIZE));
		this.destroyedBubbleLabel.setLayoutX(LABEL_X);
		this.destroyedBubbleLabel.setLayoutY(this.scoreLabel.getLayoutY() + LABEL_DISTANCE);
		this.destroyedBubbleLabel.setPrefSize(LABEL_WIDTH, LABEL_HEIGTH);
		
		this.gameTimeLabel.setText("Your game time: " + String.valueOf(this.getController().getGameTime()));
		this.gameTimeLabel.setFont(Font.font(LABEL_FONT_SIZE));
		this.gameTimeLabel.setLayoutX(LABEL_X);
		this.gameTimeLabel.setLayoutY(this.destroyedBubbleLabel.getLayoutY() + LABEL_DISTANCE);
		this.gameTimeLabel.setPrefSize(LABEL_WIDTH, LABEL_HEIGTH);
		
		this.textArea.setPromptText("Enter your name...");
		this.textArea.setFont(Font.font(LABEL_FONT_SIZE));
		this.textArea.setLayoutX(LABEL_X);
		this.textArea.setLayoutY(this.gameTimeLabel.getLayoutY() + LABEL_DISTANCE);
		this.textArea.setPrefSize(TEXT_AREA_WIDTH, TEXT_AREA_HEIGTH);
		
		this.buttonAdd.setText("Add to highscores");
		this.buttonAdd.setFont(Font.font(BUTTON_FONT_SIZE));
		this.buttonAdd.setLayoutX(LABEL_X);
		this.buttonAdd.setLayoutY(this.textArea.getLayoutY() + BUTTON_HEIGTH + LABEL_DISTANCE);
		this.buttonAdd.setPrefSize(BUTTON_WIDTH, BUTTON_HEIGTH);
		
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
