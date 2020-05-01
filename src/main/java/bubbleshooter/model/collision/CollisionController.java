package bubbleshooter.model.collision;

import bubbleshooter.model.component.CollisionComponent;
import bubbleshooter.model.component.ComponentType;
import bubbleshooter.model.gamemodality.AbstractGameMode;
import bubbleshooter.model.gameobject.Bubble;
import bubbleshooter.utility.Settings;
import javafx.geometry.Point2D;
import javafx.scene.shape.Shape;

public class CollisionController {

   private final AbstractGameMode level;

    public CollisionController(final AbstractGameMode level) {
        this.level = level;
    }

    public final void checkCollisions() {
        this.checkGridCollision();
        this.checkBounceCollision();
    }

    private void checkGridCollision() {
        final Bubble shootingBubble = this.level.getGameObjectManager().getShootingBubble();
        for (final Bubble basicbubble : this.level.getGridManager().getBubbleGrid()) {
            if (this.hasCollided(shootingBubble, basicbubble)) {
                final Collision collision = new Collision(shootingBubble, basicbubble);
                final CollisionHandler handler = new GridCollisionHandler(collision, this.level);
                handler.handle();
            }
        }
    }

    private void checkBounceCollision() {
        final Bubble shootingBubble = this.level.getGameObjectManager().getShootingBubble();
        final Point2D pos = shootingBubble.getPosition();
        if ((pos.getX() + Bubble.getRadius()) >= Settings.getGuiWidth()
            || (pos.getX() - Bubble.getRadius()) <= 0
            || (pos.getY() + Bubble.getRadius()) <= 0) {
                final CollisionHandler handler = new BoundsCollisionHandler(shootingBubble, this.level);
                handler.handle();
        }
    }

    public final boolean hasCollided(final Bubble bubbleAt, final Bubble bubbleTo) {
        if (bubbleAt.getComponent(ComponentType.COLLISIONCOMPONENT).isPresent() 
         && bubbleTo.getComponent(ComponentType.COLLISIONCOMPONENT).isPresent()) {
             final CollisionComponent first = (CollisionComponent) bubbleAt.getComponent(ComponentType.COLLISIONCOMPONENT).get();
             final CollisionComponent second = (CollisionComponent) bubbleTo.getComponent(ComponentType.COLLISIONCOMPONENT).get();
             return Shape.intersect(first.getCollisionShape(), second.getCollisionShape()).getBoundsInLocal().getWidth() != -1;
        } else {
            return false;
        }
    }

}
