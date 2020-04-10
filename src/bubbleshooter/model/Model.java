package bubbleshooter.model;

import java.util.List;

import bubbleshooter.model.gamemodality.GameModality;
import bubbleshooter.model.gamemodality.GameStatus;
import bubbleshooter.model.gameobject.GameObject;


public interface Model {

    void startBasicGame();

    void startSurvivalGame();

    List<GameObject> getGameObjects();

    void update(double elapsed);

    GameStatus getGameStatus();

    GameModality getGameModality();

}
