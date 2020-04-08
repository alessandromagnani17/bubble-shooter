package bubbleshooter.model.collision;

import java.util.List;
import bubbleshooter.model.gameobject.GameObject;
import bubbleshooter.model.gameobject.GameObjectsTypes;

public class CollisionControllerImpl implements CollisionController {

    
    //SERVIRA' UN COLLISION HANDLER PER GESTIRE TUTTE LE COLLISIONI
    
    @Override
    public void checkAllCollisions(final List<GameObject> gameObjects) {
        GameObject movingBubble = this.getElem(gameObjects, GameObjectsTypes.MOVINGBUBBLE);
        GameObject bubbleGrid = this.getElem(gameObjects, GameObjectsTypes.GRID);
        GameObject cannon = this.getElem(gameObjects, GameObjectsTypes.CANNON);
        GameObject wall = this.getElem(gameObjects, GameObjectsTypes.WALL);
        //this.hasCollided(movingBubble, wall) ? cambiaSegnoXbubble : continue;
        //this.hasCollided(movingBubble, bubbleGrid) ? gestisci scoppio/link : continue;
        //this.hasCollided(bubblegrid, cannon) ? GAMEOVER : continue;
    }

    private GameObject getElem(final List<GameObject> gameObjects, final GameObjectsTypes type) {
        return gameObjects.stream()
                .filter(a -> a.getType().equals(GameObjectsTypes.MOVINGBUBBLE))
                .iterator().next();
    }

   /* private boolean hasCollided(final GameObject a, final GameObject b) {
        return a.getCollisionBox().intersects(b.getCollisionBox());
    }
*/

}
