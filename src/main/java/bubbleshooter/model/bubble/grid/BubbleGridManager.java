package bubbleshooter.model.bubble.grid;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Stream;
import bubbleshooter.model.bubble.Bubble;
import bubbleshooter.model.bubble.BubbleColor;
import bubbleshooter.model.game.mode.GameMode;
import javafx.geometry.Point2D;

public class BubbleGridManager {

    private final int createdRows;
    private boolean offsetRow;
    private final GameMode gameMode;

    public BubbleGridManager(final GameMode gameMode) {
        this.gameMode = gameMode;
        this.createdRows = 0;
        this.offsetRow = false;
    }

    // crea una nuova riga in cima
	public final List<Bubble> createNewRow() {
		final List<Bubble> newRow = new LinkedList<>();
		final double offset = this.offsetRow ? Bubble.WIDTH : Bubble.RADIUS;

		this.dropBubble();
		Stream.iterate(0, x -> x += 1).limit(gameMode.getBubblesPerRow())
				.forEach(x -> newRow.add(this.gameMode.getBubbleFactory().createGridBubble(
						new Point2D(x * Bubble.WIDTH + offset, Bubble.RADIUS),
						BubbleColor.getRandomColor())));

		this.offsetRow = !offsetRow;
		return newRow;

	}

	// tira le palline una riga più in giù
	private void dropBubble() {
		this.getBubbleGrid().stream().forEach(
				b -> b.setPosition(new Point2D(b.getPosition().getX(), b.getPosition().getY() + Bubble.WIDTH)));
	}

	public final List<Bubble> getBubbleGrid() {
		return this.gameMode.getBubblesManager().getBubbleGrid();
	}

	public final int getCreatedRows() {
		return this.createdRows;
	}

	public final void removeBubble(final Bubble bubble) {
		this.gameMode.getBubblesManager().removeGameObject(bubble);
	}

	public final Bubble addToGrid(final Bubble bubble, final Point2D position) {
		final Bubble bubbleToAdd = this.gameMode.getBubbleFactory().createGridBubble(position, BubbleColor.getRandomColor());
		bubbleToAdd.setColor(bubble.getColor());
		this.gameMode.getBubblesManager().addBubble(Collections.singletonList(bubbleToAdd));
		this.gameMode.loadShootingBubble();
		this.gameMode.loadSwitchBubble();
		return bubbleToAdd;
	}

	public final boolean isOffsetRaw() {
		return this.offsetRow;
	}
}
