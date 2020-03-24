package bubbleshooter.model.gamemodality;

import java.util.List;
import bubbleshooter.model.collision.CollisionController;
import bubbleshooter.model.gameobject.GameObject;
import bubbleshooter.model.gameobject.GameObjectManager;

public interface GameModality {

    void start();
    
    void update(double elapsed);
    
    void setGameStatus(GameStatus status);
    
    GameStatus getGameStatus();
    
    void setGameOver();
    
    CollisionController getCollisionController();
    
    GameObjectManager getGameObjectManager(); 


    
    
}
