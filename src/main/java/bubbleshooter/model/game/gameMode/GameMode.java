package bubbleshooter.model.game.gameMode;

import java.util.List;

import bubbleshooter.model.bubble.Bubble;
import bubbleshooter.model.bubble.BubbleFactory;
import bubbleshooter.model.bubble.BubblesManager;
import bubbleshooter.model.bubble.bubbleGrid.BubbleGridHelper;
import bubbleshooter.model.bubble.bubbleGrid.BubbleGridManager;
import bubbleshooter.model.collision.CollisionController;
import bubbleshooter.model.game.GameInfoManager;
import bubbleshooter.model.game.GameStatus;
import bubbleshooter.model.game.GameType;

public interface GameMode {

	void start();

	void update(final double elapsed);

	void loadShootingBubble();

	void loadSwitchBubble();

	BubblesManager getGameObjectManager();

	void setGameOver();

	void setCurrentLevelTypes(final GameType level);

	void setGameStatus(final GameStatus status);

	GameStatus getGameStatus();

	BubbleGridManager getGridManager();

	BubbleGridHelper getGridHelper();

	CollisionController getCollisionController();

	List<Bubble> getCurrentBubbles();

	GameInfoManager getGameInfoManager();

	GameType getCurrentLevelTypes();

	BubbleFactory getBubbleFactory();

	public int getNumRows();

	public int getBubblesPerRow();
}
