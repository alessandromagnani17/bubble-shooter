package bubbleshooter.model.collision;


import bubbleshooter.model.gamemodality.GameModality;
import bubbleshooter.model.gameobject.GameObject;
import bubbleshooter.model.gameobject.GameObjectManager;
import bubbleshooter.model.gameobject.GameObjectsTypes;



public class CollisionControllerImpl implements CollisionController {

    private GameModality level;
    private GameObjectManager gameObjectManager;
    private CollisionManager collisionManager;

    public CollisionControllerImpl(final GameModality level, final GameObjectManager gameObjectManager) {
        this.level = level;
        this.gameObjectManager = gameObjectManager;
    }

    @Override
    public void checkCollisions() {
        GameObject movingBubble = this.gameObjectManager.getGameObjectFromList(GameObjectsTypes.MOVINGBUBBLE);
        GameObject bubbleGrid =  this.gameObjectManager.getGameObjectFromList(GameObjectsTypes.GRID);
        GameObject wall = this.gameObjectManager.getGameObjectFromList(GameObjectsTypes.WALL);
        if (this.hasCollided(movingBubble, wall)) {
            this.collisionManager.resolveCollsion(new Collision(movingBubble, wall, CollisionType.bubbleToWall));
        }

        if (this.hasCollided(movingBubble, bubbleGrid)) {
            this.collisionManager.resolveCollsion(new Collision(movingBubble, bubbleGrid, CollisionType.bubbleToGrid));
        }

        if (this.hasCollided(bubbleGrid, wall)) {
            this.collisionManager.resolveCollsion(new Collision(bubbleGrid, wall, CollisionType.gridToCannon));
        }
    }

    public final CollisionManager getCollisionManager() {
        return this.collisionManager;
    }
    
    private boolean hasCollided(final GameObject a, final GameObject b) {
        return a.getCollisionBox().intersects(b.getCollisionBox());
    }

}
