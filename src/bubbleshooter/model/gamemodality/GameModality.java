package bubbleshooter.model.gamemodality;

import java.util.List;
import bubbleshooter.model.gameobject.GameObjectManager;
import bubbleshooter.model.gameobject.Bubble;
import bubbleshooter.model.gameobject.BubbleGridManager;

public interface GameModality {

    void start();
   
    void update(double elapsed);

    void setGameStatus(GameStatus status);
    
    void loadShootingBubble();
    
    void setGameOver();

    List<Bubble> getCurrentBubbles();

    GameStatus getGameStatus();

    GameObjectManager getGameObjectManager();
 
    BubbleGridManager getGridManager();

    LevelTypes getLevelType();
}
