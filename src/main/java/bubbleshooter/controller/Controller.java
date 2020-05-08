package bubbleshooter.controller;

import java.util.List;
import bubbleshooter.controller.engine.GameLoop;
import bubbleshooter.model.bubble.Bubble;
import bubbleshooter.model.game.GameType;
import bubbleshooter.model.highscore.ScoreManager;

/**
 * Interface Controller used to dialogue with {@link Model} and {@link View} in order to respect MVC design pattern.
 *
 */
public interface Controller {

     /**
     * The method called by the {@link View} to start the Game in the {@link Model}.
     * @param levelType
     */
    void startGame(GameType levelType);

    /**
     * @return The List of the current Bubble in the Game.
     */
    List<Bubble> getBubbles();

    /**It's called by the {@link View} to stop the {@link GameLoop} of the Game.
     * @return The Engine of the Game.
     */
    GameLoop getGameEngine();

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
    GameType getCurrentLevel();

    /**
     * Method called by {@link GameOverController} and {@link HighscoreController}
     * for have informations about the scores.
     * 
     * @return the ScoreManager.
     */
    ScoreManager getScoreManager();
}
