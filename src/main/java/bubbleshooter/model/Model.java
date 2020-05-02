package bubbleshooter.model;

import java.util.List;
import bubbleshooter.model.gamemodality.AbstractGameMode;
import bubbleshooter.model.gamemodality.GameStatus;
import bubbleshooter.model.gameobject.Bubble;
import bubbleshooter.model.gameobject.GameObjectManager;

/**
 *Interface which represent the Logic of the Game in order to respect the MVC design pattern.
 */
public interface Model {

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
     * Method used to update the {@link AbstractGameMode}.
     * @param elapsed
     */
    void update(double elapsed);

    /**
     * @return the current level of the Game.
     */
    AbstractGameMode getLevel();

    /**
     * @return the current status of the Game.
     */
    GameStatus getGameStatus();

    /**
     * @return the {@link GameObjectManager} of the Game.
     */
    GameObjectManager getGameObjectManager();
}
