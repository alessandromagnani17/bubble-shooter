package bubbleshooter.model.gamemodality;

import java.util.List;

import bubbleshooter.model.collision.CollisionController;
import bubbleshooter.model.gameobject.GameObject;
import bubbleshooter.model.gameobject.GameObjectManager;

public interface GameModality {

    void startLevel();
    
    void update(double elapsed);
    
    void setGameStatus(GameStatus status);
    
    void setGameOver();
    
    List<GameObject> getCurrentGameObjects();
    
    CollisionController getCollisionController();
    
    GameStatus getGameStatus();

    GameObjectManager getGameObjectManager();
    
}
