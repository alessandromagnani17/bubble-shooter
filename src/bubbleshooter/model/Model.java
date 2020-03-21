package bubbleshooter.model;

import java.util.List;

import bubbleshooter.model.gamemodality.GameStatus;
import bubbleshooter.model.gameobject.GameObject;


public interface Model {

    void startGame();
    
    List<GameObject> getGameObjects();

    void update(double elapsed);

    GameStatus getGameStatus();

    
}
