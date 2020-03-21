package bubbleshooter.model.gamemodality;

import java.util.List;

import bubbleshooter.model.collision.CollisionController;
import bubbleshooter.model.gameobject.GameObject;

public interface GameModality {

    void startLevel();
    
    void update(double elapsed);
    
    void setGameStatus(GameStatus status);
    
    List<GameObject> getCurrentGameObject();
    
    void setGameOver();
    
    CollisionController getCollisionController();
    
    
}
