package bubbleshooter.model.gameobject;

import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import bubbleshooter.utility.GameCostants;
import javafx.geometry.Point2D;

public class BubbleGridManager {

	private int createdRows;
	private boolean offsetRow;
	private GameObjectManager gameObjectManager;

	public BubbleGridManager(final GameObjectManager gameObjectManager) {
		this.gameObjectManager = gameObjectManager;
		this.createdRows = 0;
		this.offsetRow = false;
	}

	// crea una nuova riga in cima
	public final List<Bubble> createNewRow() {
		List<Bubble> newRow = new LinkedList<>();
		double offset = this.offsetRow ? GameCostants.BUBBLE_WIDTH.getValue(): GameCostants.BUBBLE_WIDTH.getValue() / 2;
		this.dropBubble();
		Stream.iterate(0 , x -> x += 1).limit((long)GameCostants.ROW_BUBBLE.getValue())
										.forEach(x -> newRow.add(BubbleFactory.createGridBubble
												(new Point2D(x * GameCostants.BUBBLE_WIDTH.getValue() + offset,
														GameCostants.BUBBLE_HEIGTH.getValue() / 2))));
		this.offsetRow = !offsetRow; 
		return newRow; 

	}

	// tira le palline una riga più in giù
	private void dropBubble() {
		this.getBubbleGrid().stream().forEach(b -> b.setPosition(
				new Point2D(b.getPosition().getX(), b.getPosition().getY() + GameCostants.BUBBLE_HEIGTH.getValue())));
	}

	public final List<Bubble> getBubbleGrid() {
		return this.gameObjectManager.getBubbleGrid();
	}

	public final int getCreatedRows() {
		return this.createdRows;
	}

	public final void removeBubble(final Bubble bubble) {
		this.gameObjectManager.removeGameObject(bubble);
	}

	public final Bubble addToGrid(final Bubble bubble, final Point2D position) {
		Bubble bubbleToAdd = BubbleFactory.createGridBubble(position);
		bubbleToAdd.setColor(bubble.getColor());
		this.gameObjectManager.addBubble(Collections.singletonList(bubbleToAdd));
		this.gameObjectManager.reloadShootingBubble();
		this.gameObjectManager.reloadSwitchBubble();
		return bubbleToAdd;
	}

	public final boolean isOffsetRaw() {
		return this.offsetRow;
	}
}
