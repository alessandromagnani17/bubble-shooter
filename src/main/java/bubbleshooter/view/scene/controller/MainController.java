package bubbleshooter.view.scene.controller;

import java.util.Set;
import java.util.TreeSet;

import bubbleshooter.controller.Controller;
import bubbleshooter.model.gamemodality.LevelTypes;
import bubbleshooter.utility.Settings;
import bubbleshooter.view.View;
import bubbleshooter.view.scene.FXMLPath;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.text.Font;
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
	private static final double TITLE_DISTANCE = Settings.getGuiHeigth()/10;
	private static final double TITLE_HEIGTH = Settings.getGuiHeigth()/8;
	private static final double TITLE_WIDTH = Settings.getGuiWidth();
	private static final double TITLE_FONT_SIZE = TITLE_HEIGTH/1.5;
	private static final double BUTTON_DISTANCE = Settings.getGuiHeigth()/50;
	private static final double BUTTON_WIDTH = Settings.getGuiWidth()/2;
	private static final double BUTTON_HEIGTH = Settings.getGuiHeigth()/10;
	private static final double BUTTON_X = Settings.getGuiWidth()/2 - BUTTON_WIDTH/2;
	private static final double BUTTON_FONT_SIZE = BUTTON_HEIGTH/2.5;
	
	@Override
	public final void init(final Controller controller, final View view) {
		super.init(controller, view);
		
		this.titleLabel.setText("Bubble Shooter");
		this.titleLabel.setFont(Font.font(TITLE_FONT_SIZE));
		System.out.println("Label size --> " + TITLE_HEIGTH);
		this.titleLabel.setAlignment(Pos.BOTTOM_CENTER);
		this.titleLabel.setPrefSize(TITLE_WIDTH, TITLE_HEIGTH);
		
		this.basicModeButton.setLayoutX(BUTTON_X);
		this.basicModeButton.setLayoutY(TITLE_HEIGTH + TITLE_DISTANCE);
		this.basicModeButton.setPrefSize(BUTTON_WIDTH, BUTTON_HEIGTH);
		this.basicModeButton.setFont(Font.font(BUTTON_FONT_SIZE));
		
		this.survivalModeButton.setLayoutX(BUTTON_X);
		this.survivalModeButton.setLayoutY(this.basicModeButton.getLayoutY() + BUTTON_HEIGTH + BUTTON_DISTANCE);
		this.survivalModeButton.setPrefSize(BUTTON_WIDTH, BUTTON_HEIGTH);
		this.survivalModeButton.setFont(Font.font(BUTTON_FONT_SIZE));
		
		this.highscoresButton.setLayoutX(BUTTON_X);
		this.highscoresButton.setLayoutY(this.survivalModeButton.getLayoutY() + BUTTON_HEIGTH + BUTTON_DISTANCE);
		this.highscoresButton.setPrefSize(BUTTON_WIDTH, BUTTON_HEIGTH);
		this.highscoresButton.setFont(Font.font(BUTTON_FONT_SIZE));
		
		this.quitButton.setLayoutX(BUTTON_X);
		this.quitButton.setLayoutY(this.highscoresButton.getLayoutY() + BUTTON_HEIGTH + BUTTON_DISTANCE);
		this.quitButton.setPrefSize(BUTTON_WIDTH, BUTTON_HEIGTH);
		this.quitButton.setFont(Font.font(BUTTON_FONT_SIZE));
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
