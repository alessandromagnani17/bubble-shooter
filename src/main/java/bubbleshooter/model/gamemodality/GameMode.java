package bubbleshooter.model.gamemodality;

import java.util.List;
import bubbleshooter.model.collision.CollisionController;
import bubbleshooter.model.gameobject.Bubble;
import bubbleshooter.model.gameobject.BubbleFactory;
import bubbleshooter.model.gameobject.BubbleGridHelper;
import bubbleshooter.model.gameobject.BubbleGridManager;
import bubbleshooter.model.gameobject.GameObjectManager;

public interface GameMode {

    void update(double elapsed);

	void start();
	
	void loadShootingBubble();

	void loadSwitchBubble();

	GameObjectManager getGameObjectManager();

	void setGameOver();

	void setCurrentLevelTypes(LevelTypes level);

	void setGameStatus(GameStatus status);

	GameStatus getGameStatus();

	BubbleGridManager getGridManager();

	BubbleGridHelper getGridHelper();

	CollisionController getCollisionController();

	List<Bubble> getCurrentBubbles();

	GameInfoManager getGameInfoManager();

	LevelTypes getCurrentLevelTypes();

	BubbleFactory getBubbleFactory();
	
	void reloadShootingBubble(); 
	
	void reloadSwitchBubble();

}
