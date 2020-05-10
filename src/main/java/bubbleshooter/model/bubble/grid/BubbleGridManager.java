package bubbleshooter.model.bubble.grid;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Stream;
import bubbleshooter.model.bubble.Bubble;
import bubbleshooter.model.bubble.BubbleColor;
import bubbleshooter.model.game.mode.Level;
import javafx.geometry.Point2D;

/**
 * Class used to add, remove bubble from bubble grid and create new row of
 * bubbles.
 *
 */
public class BubbleGridManager {

    private int createdRows;
    private boolean offsetRow;
    private Level gameMode;

    public BubbleGridManager(final Level gameMode) {
        this.gameMode = gameMode;
        this.offsetRow = false;
        this.createdRows = 0;
    }

    /**
     * Creates new Row on the top of the grid.
     * 
     * @return a row of bubbles.
     */
    public final List<Bubble> createNewRow() {
        final List<Bubble> newRow = new LinkedList<>();
        final double offset = this.offsetRow ? Bubble.WIDTH : Bubble.RADIUS;
        this.moveDownBubbles();
        Stream.iterate(0, x -> x += 1).limit(gameMode.getBubblesPerRow())
              .forEach(x -> newRow.add(this.gameMode.getBubbleFactory().createGridBubble(
                new Point2D(x * Bubble.WIDTH + offset, Bubble.RADIUS), BubbleColor.getRandomColor())));
        this.createdRows++;
        this.offsetRow = !offsetRow;
        return newRow;
    }

    /**
     * Moves all the balls one row down to create a new one.
     */
    private void moveDownBubbles() {
        this.getBubbleGrid().stream().forEach(
                b -> b.setPosition(new Point2D(b.getPosition().getX(), b.getPosition().getY() + Bubble.WIDTH)));
    }

    /**
     * Gets all bubbles in the grid.
     * @return a {@link List} of all {@link GridBubble}s.
     */
    public final List<Bubble> getBubbleGrid() {
        return this.gameMode.getBubblesManager().getBubbleGrid();
    }

    /**
     * Gets the number of all created row in the game.
     * @return the created rows
     */
    public final int getCreatedRows() {
        return this.createdRows;
    }

    /**
     * Tells the {@link BubblesManager} to remove the specified bubble.
     * @param bubble the bubble to be removed.
     */
    public final void removeBubble(final Bubble bubble) {
        this.gameMode.getBubblesManager().removeGameObject(bubble);
    }

    /**
     * Creates a new bubble and tells the {@link BubblesManager} to add it to the game.
     * @param bubble the {@link Bubble} to add.
     * @param position the position of new bubble.
     * @return the created {@link Bubble}.
     */
    public final Bubble addToGrid(final Bubble bubble, final Point2D position) {
        final Bubble bubbleToAdd = this.gameMode.getBubbleFactory().createGridBubble(position, bubble.getColor());
        this.gameMode.getBubblesManager().addBubble(Collections.singletonList(bubbleToAdd));
        this.gameMode.loadShootingBubble();
        this.gameMode.loadSwitchBubble();
        return bubbleToAdd;
    }

    /**
     * Return true if the next row is an offset row, false otherwise. 
     * @return offsetRow. 
     */
    public final boolean isOffsetRow() {
        return this.offsetRow;
    }
}
