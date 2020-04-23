package bubbleshooter.model;

import java.util.List;
import bubbleshooter.model.gamemodality.GameStatus;
import bubbleshooter.model.gameobject.Bubble;
import bubbleshooter.model.gameobject.GameObjectManager;


public interface Model {

    void startBasicGame();

    void startSurvivalGame();

    List<Bubble> getBubbles();

    void update(double elapsed);

    GameStatus getGameStatus();

    GameObjectManager getGameObjectManager();
}
