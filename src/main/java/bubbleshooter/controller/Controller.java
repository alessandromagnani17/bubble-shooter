package bubbleshooter.controller;

import java.util.List;
import bubbleshooter.controller.engine.GameLoop;
import bubbleshooter.model.gamemodality.LevelTypes;
import bubbleshooter.model.gameobject.Bubble;
import bubbleshooter.model.highscore.HighscoreStructure;
import javafx.collections.ObservableList;

/**
 * Interface Controller used to dialogue with {@link Model} and {@link View} in order to respect MVC design pattern.
 *
 */
public interface Controller {

     /**
     * The method called by the {@link View} to start the Game in the {@link Model}.
     * @param levelType
     */
    void startGame(LevelTypes levelType);

    /**
     * @return The List of the current Bubble in the Game.
     */
    List<Bubble> getBubbles();

    /**It's called by the {@link View} to stop the {@link GameLoop} of the Game.
     * @return The Engine of the Game.
     */
    GameLoop getGameEngine();

	void saveScore(String text);
 
    /*int getScore();

	ObservableList<HighscoreStructure> getHighscoreList(LevelTypes gameMode);

	void saveScore(String text);

	int getDestroyedBubbles();

	double getGameTime();

	int getWrongShoots();*/
	
	LevelTypes getCurrentLevel();

	ScoreManager getScoreManager();
}
