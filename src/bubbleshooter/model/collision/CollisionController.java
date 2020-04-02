package bubbleshooter.model.collision;

import java.util.List;
import java.util.stream.Collectors;
import bubbleshooter.model.gamemodality.GameModality;
import bubbleshooter.model.gameobject.GameObject;
import bubbleshooter.model.gameobject.GameObjectManager;
import bubbleshooter.model.gameobject.GameObjectsTypes;
import bubbleshooter.model.gameobject.bubble.ShootingBubble;
import javafx.scene.shape.Shape;

public class CollisionController {

    private GameModality level;
    private GameObjectManager gameObjectManager;

    public CollisionController(final GameModality level, final GameObjectManager gameObjectManager) {
        this.level = level;
        this.gameObjectManager = gameObjectManager;
    }

    public final void checkCollisions() {
        this.checkGameCollisions();
        this.checkGameOver();
    }

    private void checkGameCollisions() {
        GameObject shootingBubble = this.gameObjectManager.getShootingBubble().get();
        for (GameObject gObj : this.getHittables()) {
            if (this.hasCollided(gObj, shootingBubble)) {
                gObj.accept((ShootingBubble) shootingBubble, gameObjectManager);
            }
        }
    }

    private void checkGameOver() {

    }

    private boolean hasCollided(final GameObject a, final GameObject b) {
        Shape intersection = Shape.intersect(a.getShape(), b.getShape());
        return intersection.getBoundsInLocal().getWidth() != -1;
    }

    private List<GameObject> getHittables() {
        return this.gameObjectManager.getGameObjects()
                                     .stream()
                                     .filter(a -> a.getType().equals(GameObjectsTypes.BASICBUBBLE)
                                     || a.getType().equals(GameObjectsTypes.LEFTWALL) 
                                     || a.getType().equals(GameObjectsTypes.RIGHTWALL))
                                     .collect(Collectors.toList());
    }

}
