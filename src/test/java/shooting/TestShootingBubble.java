package shooting;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import bubbleshooter.model.bubble.Bubble;
import bubbleshooter.model.bubble.BubbleColor;
import bubbleshooter.model.bubble.ShootingBubble;
import bubbleshooter.model.component.ComponentType;
import bubbleshooter.model.component.ShootingComponent;

import javafx.geometry.Point2D;

/**
 * Class used to Test the {@link ShootingComponent} and the {@link ShootingBubble}.
 *
 */
public class TestShootingBubble {

    private Bubble testShootingBubble = new ShootingBubble(new Point2D(0, 0), BubbleColor.BLUE);

    /**
     * Method to test if the {@link ShootingBubble} contains the {@link ShootingComponent}.
     */
    @Test
    public final void testShootingComponent() {
        assertTrue(this.testShootingBubble.getComponent(ComponentType.SHOOTINGCOMPONENT).isPresent());
        final ShootingComponent component = (ShootingComponent) this.testShootingBubble.getComponent(ComponentType.SHOOTINGCOMPONENT).get();
        assertTrue(component.getContainer().equals(this.testShootingBubble));
    }

    /**
     * Method to test if the {@link ShootingBubble} can change its direction.
     */
    @Test
    public final void testDirection() {
        final Point2D startingDirection = this.testShootingBubble.getDirection().get();
        this.testShootingBubble.setDirection(new Point2D(100, 100));
        assertFalse(startingDirection.equals(this.testShootingBubble.getDirection().get()));
    }

    /**
     * Method to test if the {@link ShootingBubble} can really move in the game and be shot.
     */
    @Test
    public final void testShoot() {
        final ShootingComponent component = (ShootingComponent) this.testShootingBubble.getComponent(ComponentType.SHOOTINGCOMPONENT).get();
        final Point2D startingPos = this.testShootingBubble.getPosition();
        this.testShootingBubble.setDirection(new Point2D(1000, 1000));
        component.update(1);
        component.update(1);
        final Point2D finalPos = this.testShootingBubble.getPosition();
        assertFalse(startingPos.equals(finalPos));
    }

    /**
     * Method to test and check if the {@link ShootingBubble} change its position if the direction isn't set.
     */
    @Test
    public final void testStartingDirection() {
        assertTrue(this.testShootingBubble.getPosition().equals(this.testShootingBubble.getDirection().get()));
        final ShootingComponent component = (ShootingComponent) this.testShootingBubble.getComponent(ComponentType.SHOOTINGCOMPONENT).get();
        component.update(1);
        assertTrue(this.testShootingBubble.getPosition().equals(this.testShootingBubble.getDirection().get()));
    }
}
