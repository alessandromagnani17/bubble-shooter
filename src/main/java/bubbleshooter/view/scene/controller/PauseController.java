package bubbleshooter.view.scene.controller;

import bubbleshooter.controller.Controller;
import bubbleshooter.utility.Settings;
import bubbleshooter.view.View;
import bubbleshooter.view.scene.FXMLPath;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;

public class PauseController extends AbstractController {
	
	@FXML private Label titleLabel = new Label();
	@FXML private Button resumeButton = new Button();
	@FXML private Button restartButton = new Button();
	@FXML private Button quitButton = new Button();
	
	private static final double TITLE_DISTANCE = Settings.getGuiHeigth() / 10;
	private static final double TITLE_HEIGTH = Settings.getGuiHeigth() / 8;
	private static final double TITLE_WIDTH = Settings.getGuiWidth();
	private static final double TITLE_FONT_SIZE = TITLE_HEIGTH / 1.5;
	private static final double BUTTON_DISTANCE = Settings.getGuiHeigth() / 50;
	private static final double BUTTON_WIDTH = Settings.getGuiWidth() / 2;
	private static final double BUTTON_HEIGTH = Settings.getGuiHeigth() / 10;
	private static final double BUTTON_X = Settings.getGuiWidth() / 2 - BUTTON_WIDTH / 2;
	private static final double BUTTON_FONT_SIZE = BUTTON_HEIGTH / 2.5;
	
	@Override
	public final void init(final Controller controller, final View view) {
		super.init(controller, view);

		this.titleLabel.setText("Pause");
		this.titleLabel.setFont(Font.font(TITLE_FONT_SIZE));
		this.titleLabel.setAlignment(Pos.BOTTOM_CENTER);
		this.titleLabel.setPrefSize(TITLE_WIDTH, TITLE_HEIGTH);

		this.resumeButton.setText("Resume");
		this.resumeButton.setTextAlignment(TextAlignment.CENTER);
		this.resumeButton.setLayoutX(BUTTON_X);
		this.resumeButton.setLayoutY(TITLE_HEIGTH + TITLE_DISTANCE);
		this.resumeButton.setPrefSize(BUTTON_WIDTH, BUTTON_HEIGTH);
		this.resumeButton.setFont(Font.font(BUTTON_FONT_SIZE));

		this.restartButton.setText("Restart");
		this.restartButton.setTextAlignment(TextAlignment.CENTER);
		this.restartButton.setLayoutX(BUTTON_X);
		this.restartButton.setLayoutY(this.resumeButton.getLayoutY() + BUTTON_HEIGTH + BUTTON_DISTANCE);
		this.restartButton.setPrefSize(BUTTON_WIDTH, BUTTON_HEIGTH);
		this.restartButton.setFont(Font.font(BUTTON_FONT_SIZE));

		this.quitButton.setText("Quit");
		this.quitButton.setTextAlignment(TextAlignment.CENTER);
		this.quitButton.setLayoutX(BUTTON_X);
		this.quitButton.setLayoutY(this.restartButton.getLayoutY() + BUTTON_HEIGTH + BUTTON_DISTANCE);
		this.quitButton.setPrefSize(BUTTON_WIDTH, BUTTON_HEIGTH);
		this.quitButton.setFont(Font.font(BUTTON_FONT_SIZE));

	}
	
	public final void resume() {
		this.getController().getGameEngine().resumeLoop();
		this.getView().loadScene(FXMLPath.GAME);
	}
	
	public final void restart() {
        this.getController().startGame(this.getController().getCurrentLevel());
        this.nextScene();
	}
	
	public final void quit() {
		System.exit(0);
	}

	@Override
	public final FXMLPath getNextScene() {
		return FXMLPath.GAME; 
	}

	@Override
	protected final FXMLPath getPreviousScene() {
		return FXMLPath.GAME; 
	}

}
