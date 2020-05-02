package bubbleshooter.view.scene.controller;

import bubbleshooter.controller.Controller;
import bubbleshooter.model.gamemodality.LevelTypes;
import bubbleshooter.model.highscore.HighscoreStructure;
import bubbleshooter.view.View;
import bubbleshooter.view.scene.FXMLPath;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class HighscoreController extends AbstractController {

	@FXML
	private TableView<HighscoreStructure> tableBaseView;
	@FXML
	private TableColumn<HighscoreStructure, String> nameBaseColumn;
	@FXML
	private TableColumn<HighscoreStructure, Integer> scoreBaseColumn;
	@FXML
	private TableView<HighscoreStructure> tableSurvivalView;
	@FXML
	private TableColumn<HighscoreStructure, String> nameSurvivalColumn;
	@FXML
	private TableColumn<HighscoreStructure, Integer> scoreSurvivalColumn;

	@Override

	public final void init(final Controller controller, final View view) {
		super.init(controller, view);

		nameBaseColumn.setCellValueFactory(new PropertyValueFactory<HighscoreStructure, String>("Name"));
		scoreBaseColumn.setCellValueFactory(new PropertyValueFactory<HighscoreStructure, Integer>("Score"));

		nameSurvivalColumn.setCellValueFactory(new PropertyValueFactory<HighscoreStructure, String>("Name"));
		scoreSurvivalColumn.setCellValueFactory(new PropertyValueFactory<HighscoreStructure, Integer>("Score"));

		tableBaseView.setItems(getScores(LevelTypes.BASICMODE));
		tableSurvivalView.setItems(getScores(LevelTypes.SURVIVALMODE));

		// Rende le due tabelle non modificabili alla pressione del mouse
		tableBaseView.setMouseTransparent(true);
		tableSurvivalView.setMouseTransparent(true);

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
