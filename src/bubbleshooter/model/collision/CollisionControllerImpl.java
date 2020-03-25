package bubbleshooter.model.collision;

import java.util.List;

import org.locationtech.jts.math.Vector2D;

import bubbleshooter.model.gamemodality.GameModality;
import bubbleshooter.model.gameobject.GameObject;
import bubbleshooter.model.gameobject.GameObjectsTypes;

public class CollisionControllerImpl implements CollisionController {
    
    private GameModality level;
    
    public CollisionControllerImpl(final GameModality level) {
        this.level = level;
    }
    
    @Override
    public void checkAllCollisions(final List<GameObject> gameObjects) {
        GameObject movingBubble = this.getElem(gameObjects, GameObjectsTypes.MOVINGBUBBLE);
        GameObject bubbleGrid = this.getElem(gameObjects, GameObjectsTypes.GRID);
        GameObject cannon = this.getElem(gameObjects, GameObjectsTypes.CANNON);
        GameObject wall = this.getElem(gameObjects, GameObjectsTypes.WALL);
        if (this.hasCollided(movingBubble, wall)){
           movingBubble.setPosition(new Vector2D(movingBubble.getPosition().getX()*-1,movingBubble.getPosition().getY()));
        }
        if (this.hasCollided(movingBubble, bubbleGrid)) {
            //SCOPPIO O ATTACCO
        }
        if (this.hasCollided(bubbleGrid, cannon)){
            this.level.setGameOver();
        }
    }

    private GameObject getElem(final List<GameObject> gameObjects, final GameObjectsTypes type) {
        return gameObjects.stream()
                .filter(a -> a.getType().equals(GameObjectsTypes.MOVINGBUBBLE))
                .iterator().next();
    }

    private boolean hasCollided(final GameObject a, final GameObject b) {
        return a.getCollisionBox().intersects(b.getCollisionBox());
    }


}
