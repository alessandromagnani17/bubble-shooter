package collision;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import bubbleshooter.model.bubble.Bubble;
import bubbleshooter.model.bubble.GridBubble;
import bubbleshooter.model.bubble.ShootingBubble;
import bubbleshooter.model.bubble.BubbleColor;
import bubbleshooter.model.collision.CollisionController;
import bubbleshooter.model.component.CollisionComponent;
import bubbleshooter.model.component.ComponentType;
import bubbleshooter.model.game.gameMode.BasicMode;
import javafx.geometry.Point2D;

/**
 * Test class used to check if {@link CollisionController} and {@link CollisionComponent} work correctly.
 */
public class TestBubbleCollision {

    private final  CollisionController collisionController = new CollisionController(new BasicMode());

    @Test
    public final void testComponent() {
        final Bubble gridBubble = new GridBubble(new Point2D(0, 0), BubbleColor.BLUE);
        assertTrue(gridBubble.getComponent(ComponentType.COLLISIONCOMPONENT).isPresent());
        final Bubble shootingBubble = new ShootingBubble(new Point2D(0, 0), BubbleColor.BLUE);
        assertTrue(shootingBubble.getComponent(ComponentType.COLLISIONCOMPONENT).isPresent());
        final CollisionComponent gridCollComponent = (CollisionComponent) gridBubble.getComponent(ComponentType.COLLISIONCOMPONENT).get();
        assertTrue(gridCollComponent.getContainer().equals(gridBubble));
        final CollisionComponent shootCollComponent = (CollisionComponent) shootingBubble.getComponent(ComponentType.COLLISIONCOMPONENT).get();
        assertTrue(shootCollComponent.getContainer().equals(shootingBubble));
     }

    @Test
    public final void testCollisionController() {
        final Bubble gridBubble = new GridBubble(new Point2D(100, 100), BubbleColor.BLUE);
        final Bubble shootingBubble = new ShootingBubble(new Point2D(0, 0), BubbleColor.BLUE);
        assertFalse(this.collisionController.hasCollided(gridBubble, shootingBubble));
        shootingBubble.setPosition(gridBubble.getPosition());
        assertTrue(this.collisionController.hasCollided(gridBubble, shootingBubble));
    }
}
