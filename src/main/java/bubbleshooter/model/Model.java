package bubbleshooter.model;

import java.util.List;

import bubbleshooter.model.bubble.Bubble;
import bubbleshooter.model.bubble.BubblesManager;
import bubbleshooter.model.game.GameStatus;
import bubbleshooter.model.game.gameMode.AbstractGameMode;
import bubbleshooter.model.game.gameMode.GameMode;

/**
 *Interface which represent the Logic of the Game in order to respect the MVC design pattern.
 */
public interface Model {


	static final int WIDTH = 705;
	static final int HEIGTH = 700;
	
    /**
     * Method called in the {@link Controller} class to start a {@link BasicMode}.
     */
    void startBasicGame();

    /**
     * Method called in the {@link Controller} class to start a {@link SurvivalMode}.
     */
    void startSurvivalGame();

    /**
     * Method called in the {@link Controller} class.
     * @return the list of the currents {@link Bubble} in the game.
     */
    List<Bubble> getBubbles();

    /**
     * Method used to update the {@link GameMode}.
     * @param elapsed
     */
    void update(double elapsed);

    /**
     * @return the current level of the Game.
     */
    GameMode getLevel();

    /**
     * @return the current status of the Game.
     */
    GameStatus getGameStatus();

    /**
     * @return the {@link BubblesManager} of the Game.
     */
    BubblesManager getGameObjectManager();
}
