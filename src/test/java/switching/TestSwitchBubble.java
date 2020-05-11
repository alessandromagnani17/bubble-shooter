package switching;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.LinkedList;
import java.util.List;

import org.junit.jupiter.api.Test;


import bubbleshooter.controller.input.SwitcherController;
import bubbleshooter.model.bubble.Bubble;
import bubbleshooter.model.bubble.BubbleColor;
import bubbleshooter.model.bubble.ShootingBubble;
import bubbleshooter.model.bubble.SwitchBubble;
import bubbleshooter.model.game.mode.BasicLevel;
import bubbleshooter.model.game.mode.Level;
import bubbleshooter.model.game.mode.SurvivalLevel;
import javafx.geometry.Point2D;

/**
 * Class used to Test the {@link ShootingComponent} and the {@link ShootingBubble}.
 *
 */
public class TestSwitchBubble {

    private static final double LIMITS = 3;

    private Bubble testSwitchBubble = new SwitchBubble(new Point2D(0, 0), BubbleColor.GREEN);
    private Bubble testShootingBubble = new ShootingBubble(new Point2D(0, 0), BubbleColor.BLUE);
    private List<Bubble> bubblesManager = new LinkedList<Bubble>();
    private SwitcherController switcherController = new SwitcherController(bubblesManager);
    private Level basicLevel = new BasicLevel();
    private Level survivalLevel = new SurvivalLevel();


    /**
     * Method to test if the {@link ShootingBubble} at the switch takes on the color of the {@link SwitchBubble}.
     */
    @Test
    public final void testSwitch() {
        this.bubblesManager.add(this.testShootingBubble);
        this.bubblesManager.add(this.testSwitchBubble);
        this.switcherController.setBubbles(bubblesManager);
        this.switcherController.switchControl();

        System.out.println(this.testSwitchBubble.getColor());

        assertTrue(this.testSwitchBubble.getColor().equals(BubbleColor.BLUE));
        assertTrue(this.testShootingBubble.getColor().equals(BubbleColor.GREEN));
    }

    /**
     * Method to test if the {@link ShootingBubble} doesn't take on the 
     * {@link SwitchBubble}'s color when the Switch Limit is exceeded.
     */
    @Test
    public final void testLimitsExceeded() {
        this.bubblesManager.add(this.testShootingBubble);
        this.bubblesManager.add(this.testSwitchBubble);
        this.switcherController.setBubbles(bubblesManager);
        this.switcherController.setNumSwitch(LIMITS);
        this.switcherController.switchControl();

        assertFalse(this.testSwitchBubble.getColor().equals(BubbleColor.BLUE));
        assertFalse(this.testShootingBubble.getColor().equals(BubbleColor.GREEN));
    }

    /**
     * Method to test if the {@link ShootingBubble} takes on the color 
     * of the {@link SwitchBubble} after Shooting in {@link BasicMode}.
     */
    @Test
    public final void testBasicSwitchAfterShot() {
        this.bubblesManager.add(testShootingBubble);
        this.bubblesManager.add(testSwitchBubble);
        this.basicLevel.getBubblesManager().addBubble(bubblesManager);
        this.basicLevel.loadShootingBubble();

        assertTrue(this.basicLevel.getBubblesManager().getShootingBubble().get().getColor().equals(BubbleColor.GREEN));
    }

    /**
     * Method to test if the {@link ShootingBubble} takes on the color 
     * of the {@link SwitchBubble} after Shooting in {@link SurvivalMode}.
     */
    @Test
    public final void testSurvivalSwitchAfterShot() {
        this.bubblesManager.add(testShootingBubble);
        this.bubblesManager.add(testSwitchBubble);
        this.survivalLevel.getBubblesManager().addBubble(bubblesManager);
        this.survivalLevel.loadShootingBubble();

        assertTrue(this.survivalLevel.getBubblesManager().getShootingBubble().get().getColor().equals(BubbleColor.GREEN));
    }
}
