package collision;

import static org.junit.jupiter.api.Assertions.assertFalse;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import bubbleshooter.controller.Controller;
import bubbleshooter.controller.ControllerImpl;
import bubbleshooter.model.Model;
import bubbleshooter.model.ModelImpl;
import bubbleshooter.model.collision.Collision;
import bubbleshooter.model.collision.CollisionController;
import bubbleshooter.model.collision.CollisionHandler;
import bubbleshooter.model.collision.GridCollisionHandler;
import bubbleshooter.model.component.CollisionComponent;
import bubbleshooter.model.component.ComponentType;
import bubbleshooter.model.gamemodality.BasicMode;
import bubbleshooter.model.gamemodality.GameMode;
import bubbleshooter.model.gamemodality.LevelTypes;
import bubbleshooter.model.gameobject.Bubble;
import bubbleshooter.model.gameobject.BubbleColor;
import bubbleshooter.model.gameobject.GridBubble;
import bubbleshooter.model.gameobject.ShootingBubble;
import bubbleshooter.view.View;
import bubbleshooter.view.scene.FXMLPath;
import javafx.geometry.Point2D;

/**
 * Test class used to check if {@link CollisionController} and {@link CollisionComponent} work correctly.
 */
public class TestBubbleCollision {

    private final Model model = new ModelImpl();
    private final View view = new TestView();
    private final Controller controller = new ControllerImpl(model, view);
    private final  CollisionController collisionController = this.model.getLevel().getCollisionController();

    @Test
    public final void testComponent() {
        final Bubble bubble = new GridBubble(new Point2D(0, 0), BubbleColor.BLUE);
        assertTrue(bubble.getComponent(ComponentType.COLLISIONCOMPONENT).isPresent());
        final CollisionComponent component = (CollisionComponent) bubble.getComponent(ComponentType.COLLISIONCOMPONENT).get();
        assertTrue(component.getContainer().equals(bubble));
       }

//    @Test
//    public final void testCollisionController() {
//    	this.controller.startGame(LevelTypes.BASICMODE);
//        final Bubble shootingBubble = this.model.getGameObjectManager().getShootingBubble();
//        final Bubble gridBubble = this.model.getGameObjectManager().getBubbleGrid().stream().findFirst().get();
//        assertFalse(this.collisionController.hasCollided(gridBubble, shootingBubble));
//        shootingBubble.setPosition(gridBubble.getPosition());
//        assertTrue(this.collisionController.hasCollided(gridBubble, shootingBubble));
//    }

//    @Test
//    public final void testCollisionHandler() {
//        final Bubble gridBubble = new GridBubble(new Point2D(1, 1), BubbleColor.BLUE);
//        final Bubble shootingBubble = new ShootingBubble(new Point2D(0, 0), BubbleColor.BLUE);
//        final Collision collision = new Collision(gridBubble, shootingBubble);
//        final CollisionHandler handler = new GridCollisionHandler(collision, new BasicMode());
//    }

    /**
     * Anonymous class used only to Test the GameEngine and avoid all the initializations.
     */
    class TestView implements View {

        @Override
        public void launch(final Controller controller) {
        }

        @Override
        public void loadScene(final FXMLPath scene) {
        }

        @Override
        public void showGameOver() {
        }

        @Override
        public void update() {
        }

        @Override
        public void render() {
        }
    }
}
