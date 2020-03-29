package bubbleshooter.model.collision;


import java.util.List;
import java.util.stream.Collectors;

import bubbleshooter.model.gamemodality.GameModality;
import bubbleshooter.model.gameobject.Bubble;
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
        GameObject movingBubble = this.getGameObjectsFromList(this.gameObjectManager.getGameObjects(), GameObjectsTypes.MOVINGBUBBLE).get(0);
        List<GameObject> bubbleGrid =  this.getGameObjectsFromList(this.gameObjectManager.getGameObjects(), GameObjectsTypes.BASICBUBBLE);
        GameObject leftWall = this.getGameObjectsFromList(this.gameObjectManager.getGameObjects(), GameObjectsTypes.LEFTWALL).get(0);
        GameObject rightWall = this.getGameObjectsFromList(this.gameObjectManager.getGameObjects(), GameObjectsTypes.RIGHTWALL).get(0);
        GameObject cannon = this.getGameObjectsFromList(this.gameObjectManager.getGameObjects(), GameObjectsTypes.CANNON).get(0);

        if (this.hasCollided(movingBubble, leftWall)) {
            this.collisionManager.resolveCollsion(new Collision(movingBubble, leftWall, CollisionType.bubbleToLeftWall));
        }

        if (this.hasCollided(movingBubble, rightWall)) {
            this.collisionManager.resolveCollsion(new Collision(movingBubble, rightWall, CollisionType.bubbleToRightWall));
        }
        for (GameObject bubble :  bubbleGrid ) {
        if (this.hasCollided(movingBubble, bubble)) {
            this.collisionManager.resolveCollsion(new Collision(movingBubble, bubble, CollisionType.bubbleToGrid));
        }
        this.checkGameOver(bubbleGrid, cannon);
        }
    }

    public final CollisionManager getCollisionManager() {
        return this.collisionManager;
    }

    private boolean hasCollided(final GameObject a, final GameObject b) {
        Shape intersection = Shape.intersect(a.getShape(), b.getShape());
        return intersection.getBoundsInLocal().getWidth() != -1;
    }

    private List<GameObject> getGameObjectsFromList(final List<GameObject> gameObjects, final GameObjectsTypes type){
        return gameObjects.stream().filter(a -> a.getType().equals(type)).collect(Collectors.toList());
    }
    
    private boolean checkGameOver(final List<GameObject> bubbleGrid,final GameObject cannon) {
        return bubbleGrid.stream().anyMatch(a -> a.getPosition().getY() >= cannon.getPosition().getY());
    }
}
