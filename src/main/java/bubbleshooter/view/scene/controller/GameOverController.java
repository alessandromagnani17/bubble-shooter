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

/**
 * The Controller related to the gameover.fxml GUI.
 */
public class GameOverController extends AbstractController {

    @FXML private Label gameOverLabel;
    @FXML private Label scoreLabel;
    @FXML private Label destroyedBubbleLabel;
    @FXML private Label gameTimeLabel;
    @FXML private TextArea textArea;
    @FXML private Button buttonAdd;

    private static final double TITLE_DISTANCE = Settings.getGuiHeight() / 10;
    private static final double TITLE_HEIGHT = Settings.getGuiHeight() / 8;
    private static final double TITLE_WIDTH = Settings.getGuiWidth();
    private static final double TITLE_FONT_SIZE = TITLE_HEIGHT / 1.5;
    private static final double LABEL_HEIGHT = Settings.getGuiHeight() / 10;
    private static final double LABEL_WIDTH = Settings.getGuiWidth();
    private static final double LABEL_X = Settings.getGuiWidth() / 2 - LABEL_WIDTH / 4;
    private static final double LABEL_DISTANCE = Settings.getGuiHeight() / 10;
    private static final double LABEL_FONT_SIZE = LABEL_HEIGHT / 2;
    private static final double TEXT_AREA_HEIGHT = LABEL_HEIGHT;
    private static final double TEXT_AREA_WIDTH = Settings.getGuiWidth() / 2;
    private static final double BUTTON_WIDTH = Settings.getGuiWidth() / 2;
    private static final double BUTTON_HEIGHT = Settings.getGuiHeight() / 10;
    private static final double BUTTON_FONT_SIZE = BUTTON_HEIGHT / 2.5;

    @Override
    public final void init(final Controller controller, final View view) {
        int score, destroyedBubble;
        double gameTime;

        this.setController(controller);
        this.setView(view);

        this.getController().getGameEngine().stopLoop();

        this.gameOverLabel.setText("Game Over");
        this.gameOverLabel.setFont(Font.font(TITLE_FONT_SIZE));
        this.gameOverLabel.setAlignment(Pos.BOTTOM_CENTER);
        this.gameOverLabel.setPrefSize(TITLE_WIDTH, TITLE_HEIGHT);

        score = this.getController().getScoreManager().getScore();
        this.scoreLabel.setText("Your score: " + score);
        this.scoreLabel.setFont(Font.font(LABEL_FONT_SIZE));
        this.scoreLabel.setLayoutX(LABEL_X);
        this.scoreLabel.setLayoutY(TITLE_HEIGHT + TITLE_DISTANCE);
        this.scoreLabel.setPrefSize(LABEL_WIDTH, LABEL_HEIGHT);

        destroyedBubble = this.getController().getScoreManager().getDestroyedBubbles();
        this.destroyedBubbleLabel.setText("Destroyed bubbles: " + destroyedBubble);
        this.destroyedBubbleLabel.setFont(Font.font(LABEL_FONT_SIZE));
        this.destroyedBubbleLabel.setLayoutX(LABEL_X);
        this.destroyedBubbleLabel.setLayoutY(this.scoreLabel.getLayoutY() + LABEL_DISTANCE);
        this.destroyedBubbleLabel.setPrefSize(LABEL_WIDTH, LABEL_HEIGHT);

        gameTime = this.getController().getScoreManager().getGameTime() / 1000;
        this.gameTimeLabel.setText("Your game time: " + gameTime + "s");
        this.gameTimeLabel.setFont(Font.font(LABEL_FONT_SIZE));
        this.gameTimeLabel.setLayoutX(LABEL_X);
        this.gameTimeLabel.setLayoutY(this.destroyedBubbleLabel.getLayoutY() + LABEL_DISTANCE);
        this.gameTimeLabel.setPrefSize(LABEL_WIDTH, LABEL_HEIGHT);

        this.textArea.setPromptText("Enter your name...");
        this.textArea.setFont(Font.font(LABEL_FONT_SIZE));
        this.textArea.setLayoutX(LABEL_X);
        this.textArea.setLayoutY(this.gameTimeLabel.getLayoutY() + LABEL_DISTANCE);
        this.textArea.setPrefSize(TEXT_AREA_WIDTH, TEXT_AREA_HEIGHT);

        this.buttonAdd.setText("Add to highscores");
        this.buttonAdd.setFont(Font.font(BUTTON_FONT_SIZE));
        this.buttonAdd.setLayoutX(LABEL_X);
        this.buttonAdd.setLayoutY(this.textArea.getLayoutY() + BUTTON_HEIGHT + LABEL_DISTANCE);
        this.buttonAdd.setPrefSize(BUTTON_WIDTH, BUTTON_HEIGHT);

    }

    /**
     * The handler for the click event generated by the 'buttonAdd' button.
     */
    @FXML
    public final void addToHighscore() {
        if (!this.textArea.getText().isEmpty()) {
            this.getController().saveScore(this.textArea.getText());
            this.setNextScene(FXMLPath.HIGHSCORE);
            this.loadNextScene();
        }
    }
}
