package bubbleshooter.model.collision;

import bubbleshooter.model.component.CollisionComponent;
import bubbleshooter.model.component.ComponentType;
import bubbleshooter.model.gamemodality.AbstractGameMode;
import bubbleshooter.model.gameobject.Bubble;
import bubbleshooter.utility.Settings;
import javafx.geometry.Point2D;
import javafx.scene.shape.Shape;

/**
 * The class used to check {@link Collision} between {@link Bubble} and also with Boundaries. 
 * It's a field of the {@link AbstractGameMode}.
 */
public class CollisionController {

    /**
     * The current level of the game. 
     * With it you can access to all components of the level such as {@link BubbleGridManager} and {@link BubbleGridHelper}.
     */
   private final AbstractGameMode level;

   /**
    * @param level The current level selected by the player.
    */
    public CollisionController(final AbstractGameMode level) {
        this.level = level;
    }

    /**
     * Method called in the update method of the {@link AbstractGameMode} every loop's cycle of the engine.
     * It checks if a {@link Bubble} has collided with another {@link Bubble} or with the Boundaries.
     */
    public final void checkCollisions() {
        this.checkGridCollision();
        this.checkBounceCollision();
    }

    /**
     * Method to check if a {@link Bubble} has collided with the grid of bubbles in the game.
     * In case of a {@link Collision} it calls a {@link GridCollisionHandler}.
     */
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

    /**
     * Method to check if a {@link Bubble} has collided with the Boundaries of the game.
     * In case of a {@link Collision} it calls a {@link BoundsCollisionHandler}.
     */
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

    /**
     * Method which uses the {@link CollisionComponent} of the {@link Bubble} and check for a {@link Collision}.
     * @param bubbleAt
     * @param bubbleTo
     * @return true if two {@link Bubble} have collided.
     */
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
