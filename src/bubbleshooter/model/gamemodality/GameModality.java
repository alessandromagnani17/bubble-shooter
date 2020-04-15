package bubbleshooter.model.gamemodality;

import java.util.List;
import bubbleshooter.model.collision.CollisionController;
import bubbleshooter.model.gameobject.GameObject;
import bubbleshooter.model.gameobject.GameObjectManager;
import bubbleshooter.model.gameobject.BubbleGridManager;

public interface GameModality {

    void start();
   
    void update(double elapsed);

    void setGameStatus(GameStatus status);
    
    CollisionController getCollisionController();

    void setGameOver();

    List<GameObject> getCurrentGameObjects();

    GameStatus getGameStatus();

    GameObjectManager getGameObjectManager();
 
    BubbleGridManager getGridManager();

}
