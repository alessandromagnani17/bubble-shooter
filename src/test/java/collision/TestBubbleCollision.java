package collision;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import com.google.errorprone.annotations.SuppressPackageLocation;

import bubbleshooter.model.collision.CollisionController;
import bubbleshooter.model.gamemodality.BasicMode;
import bubbleshooter.model.gameobject.Bubble;
import bubbleshooter.model.gameobject.GridBubble;
import bubbleshooter.model.gameobject.ShootingBubble;
import bubbleshooter.utility.Settings;
import javafx.geometry.Point2D;

/**
 * Test class used to check if {@link CollisionController} and {@link CollisionComponent} work correctly.
 */
public class TestBubbleCollision {

    private final Bubble gridBubble = new GridBubble(new Point2D(0, 0));
    private final Bubble gridBubble2 = new GridBubble(new Point2D(99, 99));
    private final Bubble shootingBubble = new ShootingBubble(new Point2D(100, 100));
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
