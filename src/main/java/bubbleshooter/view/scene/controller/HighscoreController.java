package bubbleshooter.view.scene.controller;

import bubbleshooter.controller.Controller;
import bubbleshooter.model.gamemodality.LevelTypes;
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

public class HighscoreController extends AbstractController {

	@FXML private Label titleLabel = new Label();
	@FXML private Label basicModeLabel = new Label();
	@FXML private Label survivalModeLabel = new Label();
	@FXML private Button addButton = new Button();
	@FXML private TableView<HighscoreStructure> tableBaseView;
	@FXML private TableColumn<HighscoreStructure, String> nameBaseColumn;
	@FXML private TableColumn<HighscoreStructure, Integer> scoreBaseColumn;
	@FXML private TableView<HighscoreStructure> tableSurvivalView;
	@FXML private TableColumn<HighscoreStructure, String> nameSurvivalColumn;
	@FXML private TableColumn<HighscoreStructure, Integer> scoreSurvivalColumn;
	
	private static final double TITLE_DISTANCE = Settings.getGuiHeigth()/10;
	private static final double TITLE_HEIGTH = Settings.getGuiHeigth()/8;
	private static final double TITLE_WIDTH = Settings.getGuiWidth();
	private static final double TITLE_FONT_SIZE = TITLE_HEIGTH/1.5;
	private static final double TABLE_HEIGTH = Settings.getGuiHeigth()/2;
	private static final double TABLE_WIDTH = Settings.getGuiWidth()/2.2;

	@Override
	public final void init(final Controller controller, final View view) {
		super.init(controller, view);
		
		this.titleLabel.setText("Highscores");
		this.titleLabel.setFont(Font.font(TITLE_FONT_SIZE));
		this.titleLabel.setAlignment(Pos.BOTTOM_CENTER);
		this.titleLabel.setPrefSize(TITLE_WIDTH, TITLE_HEIGTH);
		
		this.tableBaseView.setPrefSize(TABLE_WIDTH, TABLE_HEIGTH);
		this.tableSurvivalView.setPrefSize(TABLE_WIDTH, TABLE_HEIGTH);

		this.nameBaseColumn.setCellValueFactory(new PropertyValueFactory<HighscoreStructure, String>("Name"));
		this.nameBaseColumn.setPrefWidth(TABLE_WIDTH/2);
		this.scoreBaseColumn.setCellValueFactory(new PropertyValueFactory<HighscoreStructure, Integer>("Score"));
		this.scoreBaseColumn.setPrefWidth(TABLE_WIDTH/2);
		
		this.nameSurvivalColumn.setCellValueFactory(new PropertyValueFactory<HighscoreStructure, String>("Name"));
		this.nameSurvivalColumn.setPrefWidth(TABLE_WIDTH/2);
		this.scoreSurvivalColumn.setCellValueFactory(new PropertyValueFactory<HighscoreStructure, Integer>("Score"));
		this.scoreSurvivalColumn.setPrefWidth(TABLE_WIDTH/2);

		this.tableBaseView.setItems(getScores(LevelTypes.BASICMODE));
		this.tableSurvivalView.setItems(getScores(LevelTypes.SURVIVALMODE));

		// Rende le due tabelle non modificabili alla pressione del mouse
		this.tableBaseView.setMouseTransparent(true);
		this.tableSurvivalView.setMouseTransparent(true);

	}

	private ObservableList<HighscoreStructure> getScores(LevelTypes gameMode) {
		return this.getController().getHighscoreList(gameMode);
	}

	public void backToMenu() {
		this.getView().loadScene(FXMLPath.MAIN);
	}

	@Override
	public FXMLPath getNextScene() {
		return FXMLPath.MAIN;
	}

	@Override
	protected FXMLPath getPreviousScene() {
		return FXMLPath.MAIN;
	}

}
