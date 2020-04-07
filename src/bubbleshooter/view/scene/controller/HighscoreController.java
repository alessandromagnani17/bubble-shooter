package bubbleshooter.view.scene.controller;

import java.net.URL;
import java.util.ResourceBundle;

import bubbleshooter.model.highscore.HighscoreStructure;
import bubbleshooter.model.highscore.Score;
import bubbleshooter.view.scene.FXMLPath;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class HighscoreController extends AbstractController implements Initializable {
    
    @FXML private TableView<HighscoreStructure> tableView;
    @FXML private TableColumn<HighscoreStructure, String> nameBaseColumn; 
    @FXML private TableColumn<HighscoreStructure, Long> scoreBaseColumn;
    
    @FXML private TableView<HighscoreStructure> tableSurvivalView;
    @FXML private TableColumn<HighscoreStructure, String> nameSurvivalColumn; 
    @FXML private TableColumn<HighscoreStructure, Long> scoreSurvivalColumn;
    
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
        this.nameBaseColumn.setCellValueFactory(new PropertyValueFactory<HighscoreStructure, String>("Name"));
        this.scoreBaseColumn.setCellValueFactory(new PropertyValueFactory<HighscoreStructure, Long>("Score"));
        
        this.nameSurvivalColumn.setCellValueFactory(new PropertyValueFactory<HighscoreStructure, String>("Name"));
        this.scoreSurvivalColumn.setCellValueFactory(new PropertyValueFactory<HighscoreStructure, Long>("Name"));
        
        
        
        //nameBaseColumn.setCellValueFactory(new PropertyValueFactory<>("Name"));
        
        /*nameBaseColumn.setCellValueFactory(new PropertyValueFactory<Score, String>("Name"));
        scoreBaseColumn.setCellValueFactory(new PropertyValueFactory<Score, Integer>("Score"));
        
        nameSurvivalColumn.setCellValueFactory(new PropertyValueFactory<Score, String>("Name"));
        scoreSurvivalColumn.setCellValueFactory(new PropertyValueFactory<Score, Integer>("Time"));
        */
        tableView.setItems(getScores());
    }


    private ObservableList<HighscoreStructure> getScores() {
        
        ObservableList<HighscoreStructure> scoreList = FXCollections.observableArrayList();
        
        scoreList.add(new HighscoreStructure("Zimon", 500));
        
        return scoreList;
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
