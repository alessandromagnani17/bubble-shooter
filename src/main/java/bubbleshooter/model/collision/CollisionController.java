package bubbleshooter.model.collision;

import bubbleshooter.model.component.CollisionComponent;
import bubbleshooter.model.component.ComponentType;
import bubbleshooter.model.gamemodality.AbstractGameMode;
import bubbleshooter.model.gamemodality.GameInfoManager;
import bubbleshooter.model.gameobject.Bubble;
import bubbleshooter.model.gameobject.BubbleGridManager;
import bubbleshooter.model.gameobject.GameObjectManager;
import bubbleshooter.utility.GameCostants;
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
            	System.out.println("here");
                Collision collision = new Collision(shootingBubble, basicbubble);
                CollisionHandler handler = new GridCollisionHandler(collision, this.level);
                handler.handle();
            }
        }
    }

    private void checkBounceCollision() {
        final Bubble shootingBubble = this.level.getGameObjectManager().getShootingBubble();
        final Point2D pos = shootingBubble.getPosition();
        if ((pos.getX() + shootingBubble.getRadius()) >= GameCostants.GUIWIDTH.getValue()
            || (pos.getX() - shootingBubble.getRadius()) <= 0
            || (pos.getY() + shootingBubble.getRadius()) <= 0) {
                final CollisionHandler handler = new BoundsCollisionHandler(shootingBubble, this.level);
                handler.handle();
        }
    }

    private boolean hasCollided(final Bubble bubbleAt, final Bubble bubbleTo) {
        if (bubbleAt.getComponent(ComponentType.COLLISIONCOMPONENT).isPresent() 
         && bubbleTo.getComponent(ComponentType.COLLISIONCOMPONENT).isPresent()) {
             CollisionComponent first = (CollisionComponent) bubbleAt.getComponent(ComponentType.COLLISIONCOMPONENT).get();
             CollisionComponent second = (CollisionComponent) bubbleTo.getComponent(ComponentType.COLLISIONCOMPONENT).get();
             return Shape.intersect(first.getCollisionShape(), second.getCollisionShape()).getBoundsInLocal().getWidth() != -1;
        } else {
            return false;
        }
    }

}
