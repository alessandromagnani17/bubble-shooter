package bubbleshooter.model.gamemodality;

import java.util.List;

import bubbleshooter.model.gameobject.GameObject;
import bubbleshooter.model.gameobject.GameObjectManager;
import bubbleshooter.controller.collision.CollisionController;
import bubbleshooter.model.gameobject.BubbleGridManager;

public interface GameModality {

    void start();
   
    void update(double elapsed);

    void setGameStatus(GameStatus status);
    
    void loadShootingBubble();
    
    void setGameOver();

    List<GameObject> getCurrentGameObjects();

    GameStatus getGameStatus();

    GameObjectManager getGameObjectManager();
 
    BubbleGridManager getGridManager();

    LevelTypes getLevelType();
}
