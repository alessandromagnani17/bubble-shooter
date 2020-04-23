package bubbleshooter.controller.collision;

import bubbleshooter.model.gameobject.Bubble;
import bubbleshooter.utility.GameCostants;
import javafx.geometry.Point2D;

public class CollisionController {

    private final GameModality level;

    public CollisionController(final GameModality level) {
        this.level = level;
    }

    public final void checkCollisions() {
        this.checkGameCollisions();
        this.checkGameOver();
    }

    private void checkGameCollisions() {
        this.checkBounceCollision();
        this.checkGridCollision();
    }

    private void checkGridCollision() {
        final Bubble shootingBubble = this.level.getGameObjectManager().getShootingBubble();
        for (final Bubble basicbubble : this.level.getGridManager().getBubbleGrid()) {
            if (this.hasCollided(shootingBubble, basicbubble)) {
                CollisionHandler handler = new GridCollisionHandler(shootingBubble, basicbubble, this.level.getGridManager());
                handler.handle();
            }
        }
    }

    private void checkBounceCollision() {
        final Bubble shootingBubble = this.level.getGameObjectManager().getShootingBubble();
        final Point2D pos = shootingBubble.getPosition();
        if ((pos.getX() + GameCostants.BUBBLE_WIDTH.getValue() / 2) >= (GameCostants.GUIWIDTH.getValue())
           || (pos.getX() <= (GameCostants.BUBBLE_WIDTH.getValue() / 2)
            || pos.getY() <= GameCostants.BUBBLE_WIDTH.getValue() / 2)) {
            final CollisionHandler handler = new BoundsCollisionHandler(shootingBubble, this.level.getGridManager());
            handler.handle();
        }
    }


    private void checkGameOver() {
       } 

    private boolean hasCollided(final Bubble bubbleAt, final Bubble bubbleTo) {
        return this.level.getGridManager().getDistanceBetweenBubbles(bubbleAt, bubbleTo) <= GameCostants.COLLISIONDISTANCE.getValue();
    }

}
