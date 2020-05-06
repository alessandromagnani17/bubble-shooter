package bubbleshooter.model.gameobject;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Stream;
import bubbleshooter.model.gamemodality.AbstractGameMode;
import bubbleshooter.model.gamemodality.GameMode;
import bubbleshooter.utility.Settings;
import javafx.geometry.Point2D;

public class BubbleGridManager {

	private int createdRows;
	private boolean offsetRow;
	private GameMode gameMode;

	public BubbleGridManager(final GameMode gameMode) {
		this.gameMode = gameMode;
		this.createdRows = 0;
		this.offsetRow = false;
	}

	// crea una nuova riga in cima
	public final List<Bubble> createNewRow() {
		List<Bubble> newRow = new LinkedList<>();
		double offset = this.offsetRow ? Bubble.getWidth() : Bubble.getRadius();

		this.dropBubble();
		Stream.iterate(0, x -> x += 1).limit((long) Settings.getNumBubbles())
				.forEach(x -> newRow.add(this.gameMode.getBubbleFactory().createGridBubble(
						new Point2D(x * Bubble.getWidth() + offset, Bubble.getRadius()),
						BubbleColor.getRandomColor())));

		this.offsetRow = !offsetRow;
		return newRow;

	}

	// tira le palline una riga più in giù
	private void dropBubble() {
		this.getBubbleGrid().stream().forEach(
				b -> b.setPosition(new Point2D(b.getPosition().getX(), b.getPosition().getY() + Bubble.getWidth())));
	}

	public final List<Bubble> getBubbleGrid() {
		return this.gameMode.getGameObjectManager().getBubbleGrid();
	}

	public final int getCreatedRows() {
		return this.createdRows;
	}

	public final void removeBubble(final Bubble bubble) {
		this.gameMode.getGameObjectManager().removeGameObject(bubble);
	}

	public final Bubble addToGrid(final Bubble bubble, final Point2D position) {
		Bubble bubbleToAdd = this.gameMode.getBubbleFactory().createGridBubble(position, BubbleColor.getRandomColor());
		bubbleToAdd.setColor(bubble.getColor());
		this.gameMode.getGameObjectManager().addBubble(Collections.singletonList(bubbleToAdd));
		this.gameMode.reloadShootingBubble();
		this.gameMode.reloadSwitchBubble();
		return bubbleToAdd;
	}

	public final boolean isOffsetRaw() {
		return this.offsetRow;
	}
}
