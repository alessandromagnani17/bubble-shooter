package bubbleshooter.controller;

import java.util.List;

import bubbleshooter.controller.engine.GameLoop;
import bubbleshooter.model.gamemodality.LevelTypes;
import bubbleshooter.model.gameobject.Bubble;
import bubbleshooter.model.highscore.HighscoreStructure;
import javafx.collections.ObservableList;

public interface Controller {

    void startGame(LevelTypes levelType);

    List<Bubble> getBubbles();

    GameLoop getGameEngine();
 
    int getScore();

	ObservableList<HighscoreStructure> getHighscoreList(LevelTypes gameMode);

	void saveScore(String text);

	int getDestroyedBubbles();

	double getGameTime();

	int getWrongShoots();

    //INPUT MANAGER

    //MUSIC 
}
