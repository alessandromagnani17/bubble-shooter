package bubbleshooter.controller;

import java.util.List;
import bubbleshooter.controller.engine.GameLoop;
import bubbleshooter.model.gamemodality.LevelTypes;
import bubbleshooter.model.gameobject.Bubble;
<<<<<<< HEAD
import bubbleshooter.model.highscore.HighscoreStructure;
import bubbleshooter.model.highscore.ScoreManager;
import javafx.collections.ObservableList;
=======
import bubbleshooter.model.highscore.ScoreManager;
>>>>>>> 1e0fa6b6f5515d5aadc77df844f49441c3fc53fe

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
<<<<<<< HEAD

	void saveScore(String text);
 
    /*int getScore();

	ObservableList<HighscoreStructure> getHighscoreList(LevelTypes gameMode);
=======
<<<<<<< HEAD
>>>>>>> develop

	void saveScore(String text);
 
    /*int getScore();
=======
>>>>>>> 1e0fa6b6f5515d5aadc77df844f49441c3fc53fe

    /**
     * Method used for save the scores in the highscores.
     * 
     * @param text the name of the player.
     */
    void saveScore(String text);

    /**
     * Method used to have the current game modality.
     * 
     * @return the current game modality.
     */
    LevelTypes getCurrentLevel();

<<<<<<< HEAD
	int getWrongShoots();*/
	
	LevelTypes getCurrentLevel();

<<<<<<< HEAD
	int getWrongShoots();*/
	
	LevelTypes getCurrentLevel();

	ScoreManager getScoreManager();
=======
	ScoreManager getScoreManager();
=======
    /**
     * Method called by {@link GameOverController} and {@link HighscoreController}
     * for have informations about the scores.
     * 
     * @return the ScoreManager.
     */
    ScoreManager getScoreManager();
>>>>>>> 1e0fa6b6f5515d5aadc77df844f49441c3fc53fe
>>>>>>> develop
}
