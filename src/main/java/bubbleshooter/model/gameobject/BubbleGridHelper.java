package bubbleshooter.model.gameobject;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import javafx.geometry.Point2D;

public class BubbleGridHelper {

	private final GameObjectManager gameObjectManager;
	private static final double DIAGONALDISTANCE = Bubble.getWidth() * 1.20;

	public BubbleGridHelper(final GameObjectManager gameObjectManager) {
		this.gameObjectManager = gameObjectManager;
	}

	public final List<Bubble> getBubbleNeighbours(final Bubble bubble) {
		return this.getBubbleGrid().stream().filter(a -> this.isNear(a, bubble)).collect(Collectors.toList());
	}

	public final List<Bubble> getBubbleGrid() {
		return this.gameObjectManager.getBubbleGrid();
	}

	public final double getDistanceBetweenBubbles(final Bubble bubbleAt, final Bubble bubbleTo) {
		Point2D bubbleAtPos = bubbleAt.getPosition();
		Point2D bubbleToPos = bubbleTo.getPosition();
		return Math.sqrt(Math.pow(bubbleAtPos.getX() - bubbleToPos.getX(), 2)
				+ Math.pow(bubbleAtPos.getY() - bubbleToPos.getY(), 2));
	}

	public final boolean isNear(final Bubble bubbleAt, final Bubble bubbleTo) {
		return this.getDistanceBetweenBubbles(bubbleAt, bubbleTo) <= DIAGONALDISTANCE
				&& this.getDistanceBetweenBubbles(bubbleAt, bubbleTo) > 0;
	}

	public final boolean areEquals(final Bubble a, final Bubble b) {
		return a.getColor().equals(b.getColor());
	}

	private List<Bubble> getLinkedBubbles(final Bubble starting, final List<Bubble> linkedBubbles) {
		this.getBubbleNeighbours(starting).stream()
				.filter(a -> !linkedBubbles.contains(a) && !a.isDestroyed() && linkedBubbles.add(a))
				.forEach(a -> this.getLinkedBubbles(a, linkedBubbles));
		return linkedBubbles;
	}

	public final Set<Bubble> getIsolatedBubbles() {
		Set<Bubble> firstLineBubbles = this.getBubbleGrid().stream()
				.filter(a -> a.getPosition().getY() == Bubble.getWidth() / 2 && !a.isDestroyed())
				.collect(Collectors.toSet());
		Set<Bubble> linkedBubbles = new HashSet<Bubble>();
		linkedBubbles.addAll(firstLineBubbles);
		for (Bubble bubble : firstLineBubbles) {
			linkedBubbles.addAll(this.getLinkedBubbles(bubble, new LinkedList<Bubble>()));
		}
		return this.getBubbleGrid().stream().filter(a -> !linkedBubbles.contains(a)).collect(Collectors.toSet());
	}

	public final Set<Point2D> getNeighbourPosition(final Bubble bubble) {
		Point2D bubblePos = bubble.getPosition();
		return Set.of(new Point2D(bubblePos.getX() - Bubble.getWidth(), bubblePos.getY()),
				new Point2D(bubblePos.getX() + Bubble.getWidth(), bubblePos.getY()),
				new Point2D(bubblePos.getX() - Bubble.getWidth() / 2, bubblePos.getY() - Bubble.getWidth()),
				new Point2D(bubblePos.getX() + Bubble.getWidth() / 2, bubblePos.getY() - Bubble.getWidth()),
				new Point2D(bubblePos.getX() - Bubble.getWidth() / 2, bubblePos.getY() + Bubble.getWidth()),
				new Point2D(bubblePos.getX() + Bubble.getWidth() / 2, bubblePos.getY() + Bubble.getWidth()));
	}

	public List<BubbleColor> getRemainingColors() {
		System.out.println(this.getBubbleGrid().stream().filter(b -> b.getType().equals(BubbleType.GRID_BUBBLE))
				.map(b -> b.getColor()).distinct().collect(Collectors.toList()));
		return this.getBubbleGrid().stream().filter(b -> b.getType().equals(BubbleType.GRID_BUBBLE))
				.map(b -> b.getColor()).distinct().collect(Collectors.toList());
	}

}
