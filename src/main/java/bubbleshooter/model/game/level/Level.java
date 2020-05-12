package bubbleshooter.model.game.level;

import java.util.List;

import bubbleshooter.model.bubble.Bubble;
import bubbleshooter.model.bubble.BubbleFactory;
import bubbleshooter.model.bubble.BubblesManager;
import bubbleshooter.model.bubble.grid.BubbleGridHelper;
import bubbleshooter.model.bubble.grid.BubbleGridManager;
import bubbleshooter.model.collision.CollisionController;
import bubbleshooter.model.game.GameData;
import bubbleshooter.model.game.GameStatus;

/**
 * Represents the game. It's responsible to initialize all {@link Bubble}s and
 * create new row of bubbles.
 */

public interface Level {

	static int NUM_BUBBLES_PER_ROW = 19;

	static int NUM_ROWS = 8;

	/**
	 * Starts selected game and initialize all bubbles.
	 */
	void start();

	/**
	 * Updates the game.
	 * 
	 * @param elapsed.
	 */
	void update(double elapsed);

	/**
	 * Gets the {@link BubblesManager}.
	 * 
	 * @return {@link BubblesManager}.
	 */
	BubblesManager getBubblesManager();

	/**
	 * Loads the {@link ShootingBubble}.
	 */
	void loadShootingBubble();

	/**
	 * Loads the {@link SwitchBubble}.
	 */
	void loadSwitchBubble();

	/**
	 * Sets current {@link LevelType}.
	 * 
	 * @param the {@link LevelType}.
	 */
	void setCurrentGameType(LevelType gameType);

	/**
	 * Sets the {@link GameStatus}.
	 * 
	 * @param the {@link GameStatus}.
	 */
	void setGameStatus(GameStatus status);

	/**
	 * Gets the {@link GameStatus}.
	 * 
	 * @return the {@link GameStatus}.
	 */
	GameStatus getGameStatus();

	/**
	 * Gets the {@link BubblesManager}.
	 * 
	 * @return {@link BubblesManager}.
	 */
	BubbleGridManager getGridManager();

	/**
	 * Gets the {@link BubbleGridHelper}.
	 * 
	 * @return the {@link BubbleGridHelper}.
	 */
	BubbleGridHelper getGridHelper();

	/**
	 * Gets the {@link CollisionController}.
	 * 
	 * @return the {@link CollisionController}.
	 */
	CollisionController getCollisionController();

	/**
	 * Returns a list of current {@link Bubble}s.
	 * 
	 * @return a {@link List} of all {@link Bubble}s.
	 */
	List<Bubble> getCurrentBubbles();

	/**
	 * Gets the {@link GameData}.
	 * 
	 * @return the {@link GameData}.
	 */
	GameData getGameInfoManager();

	/**
	 * Gets the current {@link LevelType}.
	 * 
	 * @return the {@link LevelType}.
	 */
	LevelType getCurrentGameType();

	/**
	 * Gets the {@link BubbleFactory}.
	 * 
	 * @return the {@link BubbleFactory}.
	 */
	BubbleFactory getBubbleFactory();

}
