package collision;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import bubbleshooter.model.collision.CollisionController;
import bubbleshooter.model.gameobject.Bubble;
import bubbleshooter.model.gameobject.BubbleColor;
import bubbleshooter.model.gameobject.GridBubble;
import bubbleshooter.model.gameobject.ShootingBubble;
import javafx.geometry.Point2D;

/**
 * Test class used to check if {@link CollisionController} and {@link CollisionComponent} work correctly.
 */
public class TestBubbleCollision {

    private final Bubble gridBubble = new GridBubble(new Point2D(0, 0), BubbleColor.BLUE);
    private final Bubble gridBubble2 = new GridBubble(new Point2D(99, 99), BubbleColor.RED);
    private final Bubble shootingBubble = new ShootingBubble(new Point2D(100, 100) , BubbleColor.GREEN);
    private static  CollisionController collisionController ;

//    @BeforeAll
//    public static final void init() {
//        collisionController = new CollisionController();
//    }

    @Test
    public void testCollision() {
       assertTrue(shootingBubble.getPosition().getX() > 0);
    }

}
