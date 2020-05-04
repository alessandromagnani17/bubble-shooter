package bubbleshooter.model.gameobject;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import bubbleshooter.utility.Settings;
import javafx.geometry.Point2D;

/**
 * Class that hold and manages all the {@link Bubble} in the game.
 *
 */
public class GameObjectManager {

    private final List<Bubble> bubbles;

    public GameObjectManager() {
        this.bubbles = new LinkedList<>();
    } 

    /**
     * Method to update the {@link ShootingBubble} and to remove the destroyed {@link Bubble}.
     * @param elapsed
     */
    public final void update(final double elapsed) {
        this.getShootingBubble().update(elapsed);
        this.bubbles.removeAll(this.bubbles.stream().filter(a -> a.isDestroyed()).collect(Collectors.toList()));
    }

    /**
     * @return all the{@link Bubble} currently in the game.
     */
    public final List<Bubble> getAllBubbles() {
        return this.bubbles;
    }

    /**
     * @param bubbles The {@link Bubble} to add at the list.
     */
    public final void addBubble(final List<Bubble> bubbles) {
        this.bubbles.addAll(bubbles);
    }

    /**
     * @param bubble The {@link Bubble} to remove from the list.
     */
    public final void removeGameObject(final Bubble bubble) {
        this.bubbles.remove(bubble);
    }

    /**
     * @return The {@link ShootingBubble} of the game.
     */
    public final Bubble getShootingBubble() {
        return this.bubbles.stream().filter(a -> a.getType().equals(BubbleType.SHOOTING_BUBBLE)).findFirst().get();
    }

    /**
     * @return The {@link SwitchBubble} of the game.
     */
    public final Bubble getSwitchBubble() {
        return this.bubbles.stream().filter(a -> a.getType().equals(BubbleType.SWITCH_BUBBLE)).findFirst().get();
    }

    /**
     * Method to reload the {@link ShootingBubble} after a {@link Collision}.
     */
    public final void reloadShootingBubble() {
        this.getShootingBubble().setPosition(new Point2D(Settings.getGuiWidth() / 2, Settings.getGuiHeigth() - Bubble.getWidth()));
        this.getShootingBubble().setDirection(this.getShootingBubble().getPosition());
        this.getShootingBubble().setColor(getSwitchBubble().getColor());
    }

    /**
     * Method to reload the {@link SwitchBubble} after a {@link Collision}.
     */
    public final void reloadSwitchBubble() {
        this.getSwitchBubble().setPosition(new Point2D(Settings.getGuiWidth() / 1.1, Settings.getGuiHeigth() - Bubble.getWidth()));
        final Random rand = new Random();
        this.getSwitchBubble().setColor(this.getRemainingColors().get(rand.nextInt(this.getRemainingColors().size() - 1)));
    }

    /**
     * @return The {@link Bubble} that are in the game's grid.
     */
    public final List<Bubble> getBubbleGrid() {
        return this.bubbles.stream().filter(a -> a.getType().equals(BubbleType.GRID_BUBBLE)).collect(Collectors.toList());
    }

    /**
     * @return The currents {@link BubbleColor} in the game.
     * Useful to not generate some other colors in the end of the game.
     */
    public final List<BubbleColor> getRemainingColors() {
        return this.getBubbleGrid().stream()
                                   .filter(b -> b.getType().equals(BubbleType.GRID_BUBBLE))
                                   .map(b -> b.getColor()).distinct().collect(Collectors.toList());
    }
}

