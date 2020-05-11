package bubbleshooter.view.scene.controller;

import bubbleshooter.controller.Controller;
import bubbleshooter.model.game.level.LevelType;
import bubbleshooter.model.highscore.HighscoreStructure;
import bubbleshooter.utility.Settings;
import bubbleshooter.view.View;
import bubbleshooter.view.scene.FXMLPath;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Font;

/**
 * The Controller related to the highscore.fxml GUI.
 *
 */
public class HighscoreController extends AbstractController {

    @FXML private Label titleLabel = new Label();
    @FXML private Label basicModeLabel = new Label();
    @FXML private Label survivalModeLabel = new Label();
    @FXML private Button backMenuButton = new Button();
    @FXML private TableView<HighscoreStructure> tableBaseView;
    @FXML private TableColumn<HighscoreStructure, String> nameBaseColumn;
    @FXML private TableColumn<HighscoreStructure, Integer> scoreBaseColumn;
    @FXML private TableView<HighscoreStructure> tableSurvivalView;
    @FXML private TableColumn<HighscoreStructure, String> nameSurvivalColumn;
    @FXML private TableColumn<HighscoreStructure, Integer> scoreSurvivalColumn;

    private static final double TITLE_DISTANCE = Settings.getGuiHeigth() / 40;
    private static final double TITLE_HEIGTH = Settings.getGuiHeigth() / 8;
    private static final double TITLE_WIDTH = Settings.getGuiWidth();
    private static final double TITLE_FONT_SIZE = TITLE_HEIGTH / 1.5;
    private static final double TABLE_HEIGTH = Settings.getGuiHeigth() / 1.9;
    private static final double TABLE_WIDTH = Settings.getGuiWidth() / 2.2;
    private static final double DETACHMENT = Settings.getGuiWidth() - 2 * TABLE_WIDTH;
    private static final double LABEL_HEIGTH = Settings.getGuiHeigth() / 10;
    private static final double LABEL_WIDTH = TABLE_WIDTH;
    private static final double LABEL_FONT_SIZE = LABEL_HEIGTH / 3;
    private static final double BUTTON_WIDTH = TABLE_WIDTH - TABLE_WIDTH / 4;
    private static final double BUTTON_HEIGTH = Settings.getGuiHeigth() / 10;
    private static final double BUTTON_FONT_SIZE = BUTTON_HEIGTH / 2.5;

    @Override
    public final void init(final Controller controller, final View view) {
        super.init(controller, view);

        this.titleLabel.setText("Highscores");
        this.titleLabel.setFont(Font.font(TITLE_FONT_SIZE));
        this.titleLabel.setAlignment(Pos.BOTTOM_CENTER);
        this.titleLabel.setPrefSize(TITLE_WIDTH, TITLE_HEIGTH);

        this.basicModeLabel.setText("Basic Mode Highscores");
        this.basicModeLabel.setFont(Font.font(LABEL_FONT_SIZE));
        this.basicModeLabel.setLayoutX(DETACHMENT / 4);
        this.basicModeLabel.setLayoutY(TITLE_HEIGTH + TITLE_DISTANCE);
        this.basicModeLabel.setPrefSize(LABEL_WIDTH, LABEL_HEIGTH);

        this.survivalModeLabel.setText("Survival Mode Highscores");
        this.survivalModeLabel.setFont(Font.font(LABEL_FONT_SIZE));
        this.survivalModeLabel.setLayoutX(TABLE_WIDTH + DETACHMENT / 4 + DETACHMENT / 2);
        this.survivalModeLabel.setLayoutY(TITLE_HEIGTH + TITLE_DISTANCE);
        this.survivalModeLabel.setPrefSize(LABEL_WIDTH, LABEL_HEIGTH);

        this.tableBaseView.setLayoutX(DETACHMENT / 4);
        this.tableBaseView.setLayoutY(this.basicModeLabel.getLayoutY() + LABEL_HEIGTH - DETACHMENT / 4);
        this.tableBaseView.setPrefSize(TABLE_WIDTH, TABLE_HEIGTH);
        this.tableSurvivalView.setLayoutX(TABLE_WIDTH + DETACHMENT / 4 + DETACHMENT / 2);
        this.tableSurvivalView.setLayoutY(this.survivalModeLabel.getLayoutY() + LABEL_HEIGTH - DETACHMENT / 4);
        this.tableSurvivalView.setPrefSize(TABLE_WIDTH, TABLE_HEIGTH);

        this.nameBaseColumn.setCellValueFactory(new PropertyValueFactory<HighscoreStructure, String>("Name"));
        this.nameBaseColumn.setText("Player");
        this.nameBaseColumn.setPrefWidth(TABLE_WIDTH / 2);
        this.scoreBaseColumn.setCellValueFactory(new PropertyValueFactory<HighscoreStructure, Integer>("Score"));
        this.scoreBaseColumn.setText("Score");
        this.scoreBaseColumn.setPrefWidth(TABLE_WIDTH / 2);

        this.nameSurvivalColumn.setCellValueFactory(new PropertyValueFactory<HighscoreStructure, String>("Name"));
        this.nameSurvivalColumn.setText("Player");
        this.nameSurvivalColumn.setPrefWidth(TABLE_WIDTH / 2);
        this.scoreSurvivalColumn.setCellValueFactory(new PropertyValueFactory<HighscoreStructure, Integer>("Score"));
        this.scoreSurvivalColumn.setText("Time");
        this.scoreSurvivalColumn.setPrefWidth(TABLE_WIDTH / 2);

        this.backMenuButton.setText("Back to menu");
        this.backMenuButton.setFont(Font.font(BUTTON_FONT_SIZE));
        this.backMenuButton.setLayoutX(this.tableSurvivalView.getLayoutX() + TABLE_WIDTH / 4);
        this.backMenuButton.setLayoutY(this.tableSurvivalView.getLayoutY() + TABLE_HEIGTH + DETACHMENT / 2);
        this.backMenuButton.setPrefSize(BUTTON_WIDTH, BUTTON_HEIGTH);

        this.tableBaseView.setItems(getScores(LevelType.BASICMODE));
        this.tableSurvivalView.setItems(getScores(LevelType.SURVIVALMODE));

        this.tableBaseView.setMouseTransparent(true);
        this.tableSurvivalView.setMouseTransparent(true);

    }

    /**
     * Private method that calls the {@link Controller} for have a list of scores.
     * 
     * @param gameMode the game modality.
     * @return the list of scores.
     */
    private ObservableList<HighscoreStructure> getScores(final LevelType gameMode) {
        return this.getController().getHighscoreStore().getHighscoresForModality(gameMode);
    }

    /**
     * The handler for the click event generated by the 'backMenuButton' button.
     */
    @FXML
    public final void backToMenu() {
        this.getView().loadScene(FXMLPath.MAIN);
    }

    @Override
    public final FXMLPath getNextScene() {
        return FXMLPath.MAIN;
    }

    @Override
    protected final FXMLPath getPreviousScene() {
        return FXMLPath.MAIN;
    }

}
