package bubbleshooter.view.scene.controller;

import bubbleshooter.controller.Controller;
import bubbleshooter.model.gamemodality.LevelTypes;
import bubbleshooter.utility.Settings;
import bubbleshooter.view.View;
import bubbleshooter.view.scene.FXMLPath;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
/**
 * The Controller related to the main.fxml GUI.
 *
 */
public final class MainController extends AbstractController {
    
	@FXML private Button basicModeButton = new Button();
	@FXML private Button survivalModeButton = new Button();
	@FXML private Button highscoresButton = new Button();
	@FXML private Button quitButton = new Button();
	@FXML private Label titleLabel = new Label();
	private static final double BUTTON_DISTANCE = 10;
	private static final double TITLE_Y = 10;
	
	@Override
	public final void init(final Controller controller, final View view) {
		super.init(controller, view);
		
		this.titleLabel.setText("Bubble Shooter");
		this.titleLabel.setLayoutY(TITLE_Y);
		this.titleLabel.setLayoutX((Settings.getGuiWidth() - this.basicModeButton.getPrefWidth())/2);
		this.basicModeButton.setLayoutX((Settings.getGuiWidth() - this.basicModeButton.getPrefWidth())/2);
		this.basicModeButton.setLayoutY(this.titleLabel.getPrefHeight() + BUTTON_DISTANCE);
		this.survivalModeButton.setLayoutX((Settings.getGuiWidth() - this.basicModeButton.getPrefWidth())/2);
		this.survivalModeButton.setLayoutY(this.basicModeButton.getLayoutY() + this.basicModeButton.getPrefHeight() + BUTTON_DISTANCE);
		this.highscoresButton.setLayoutX((Settings.getGuiWidth() - this.basicModeButton.getPrefWidth())/2);
		this.highscoresButton.setLayoutY(this.survivalModeButton.getLayoutY() + this.survivalModeButton.getPrefHeight() + BUTTON_DISTANCE);
		this.quitButton.setLayoutX((Settings.getGuiWidth() - this.basicModeButton.getPrefWidth())/2);
		this.quitButton.setLayoutY(this.highscoresButton.getLayoutY() + this.highscoresButton.getPrefHeight() + BUTTON_DISTANCE);
	}

    public void basicMode() {
        this.getController().startGame(LevelTypes.BASICMODE);
        this.nextScene();
    }
    
    public void survivalMode() {
        this.getController().startGame(LevelTypes.SURVIVALMODE);
        this.nextScene();
    }
   
    public void highscores() {
        this.getView().loadScene(FXMLPath.HIGHSCORE);
    }
    
    public void quit() {
        System.exit(0);
}

    @Override
    public FXMLPath getNextScene() {
        return FXMLPath.GAME; 
    }

    @Override
    protected FXMLPath getPreviousScene() {
        return FXMLPath.MAIN; 
    }
}
