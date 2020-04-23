package bubbleshooter.model.collision;

import bubbleshooter.model.gameobject.Bubble;
import bubbleshooter.model.gameobject.BubbleGridManager;
import bubbleshooter.model.gameobject.GameObjectManager;
import bubbleshooter.utility.GameCostants;
import javafx.geometry.Point2D;

public class CollisionController {

    private final GameObjectManager gameObjectManager;
    private final BubbleGridManager gridManager;

    public CollisionController(final GameObjectManager manager, final BubbleGridManager gridManager) {
        this.gameObjectManager = manager;
        this.gridManager = gridManager;
    }

    public final void checkCollisions() {
        this.checkGameCollisions();
    }

    private void checkGameCollisions() {
        this.checkBounceCollision();
        this.checkGridCollision();
    }

    private void checkGridCollision() {
        final Bubble shootingBubble = this.gameObjectManager.getShootingBubble();
        for (final Bubble basicbubble : this.gridManager.getBubbleGrid()) {
            if (this.hasCollided(shootingBubble, basicbubble)) {
                Collision collision = new Collision(shootingBubble, basicbubble);
                CollisionHandler handler = new GridCollisionHandler(collision, this.gridManager);
                handler.handle();
            }
        }
    }

    private void checkBounceCollision() {
        final Bubble shootingBubble = this.gameObjectManager.getShootingBubble();
        final Point2D pos = shootingBubble.getPosition();
        if ((pos.getX() + GameCostants.BUBBLE_WIDTH.getValue() / 2) >= (GameCostants.GUIWIDTH.getValue())
           || (pos.getX() <= (GameCostants.BUBBLE_WIDTH.getValue() / 2)
            || pos.getY() <= GameCostants.BUBBLE_WIDTH.getValue() / 2)) {
            final CollisionHandler handler = new BoundsCollisionHandler(shootingBubble, this.gridManager);
            handler.handle();
        }
    }

    private boolean hasCollided(final Bubble bubbleAt, final Bubble bubbleTo) {
        return this.gridManager.getDistanceBetweenBubbles(bubbleAt, bubbleTo) <= GameCostants.COLLISIONDISTANCE.getValue();
    }

}
