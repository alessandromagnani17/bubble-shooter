package bubbleshooter.controller;

import java.util.List;
import bubbleshooter.model.gamemodality.LevelTypes;
import bubbleshooter.model.gameobject.Bubble;
import bubbleshooter.model.gameobject.GridBubble;
import bubbleshooter.model.gameobject.ShootingBubble;
import bubbleshooter.model.highscore.HighscoreStructure;
import javafx.collections.ObservableList;

public interface Controller {

    void startGame(LevelTypes levelType);

    void pause();

    void resume();

    void setGameOver();

    List<Bubble> getBubbles();


	ObservableList<HighscoreStructure> getHighscoreList(LevelTypes gameMode);

    //INPUT MANAGER

    //MUSIC 
}
