package bubbleshooter.model.collision;


import bubbleshooter.model.gamemodality.GameModality;
import bubbleshooter.model.gameobject.GameObject;
import bubbleshooter.model.gameobject.GameObjectManager;
import bubbleshooter.model.gameobject.GameObjectsTypes;
import javafx.scene.shape.Shape;

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
        GameObject leftWall = this.gameObjectManager.getGameObjectFromList(GameObjectsTypes.LEFTWALL);
        GameObject rightWall = this.gameObjectManager.getGameObjectFromList(GameObjectsTypes.RIGHTWALL);
        GameObject cannon = this.gameObjectManager.getGameObjectFromList(GameObjectsTypes.CANNON);

        if (this.hasCollided(movingBubble, leftWall)) {
            this.collisionManager.resolveCollsion(new Collision(movingBubble, leftWall, CollisionType.bubbleToLeftWall));
        }

        if (this.hasCollided(movingBubble, rightWall)) {
            this.collisionManager.resolveCollsion(new Collision(movingBubble, rightWall, CollisionType.bubbleToRightWall));
        }
        
        if (this.hasCollided(movingBubble, bubbleGrid)) {
            this.collisionManager.resolveCollsion(new Collision(movingBubble, bubbleGrid, CollisionType.bubbleToGrid));
        }

        if (this.hasCollided(bubbleGrid, cannon)) {
            this.collisionManager.resolveCollsion(new Collision(bubbleGrid, cannon, CollisionType.gridToCannon));
        }
    }

    public final CollisionManager getCollisionManager() {
        return this.collisionManager;
    }
    
    private boolean hasCollided(final GameObject a, final GameObject b) {
        Shape intersection = Shape.intersect(a.getShape(), b.getShape());
        return intersection.getBoundsInLocal().getWidth() != -1;
    }

}
