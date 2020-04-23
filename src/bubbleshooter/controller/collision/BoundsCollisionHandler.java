package bubbleshooter.controller.collision;

import bubbleshooter.utility.GameCostants;

import java.util.stream.Collectors;

import bubbleshooter.model.gameobject.Bubble;
import bubbleshooter.model.gameobject.BubbleGridManager;

import javafx.geometry.Point2D;

public class BoundsCollisionHandler implements CollisionHandler {

	private Bubble shootingBubble;
	private final BubbleGridManager gridManager;

	public BoundsCollisionHandler(final Bubble shootingBubble, final BubbleGridManager gridManager) {
		this.shootingBubble = shootingBubble;
		this.gridManager = gridManager;
	}

	@Override
	public final void handle() {
		if (this.isTopWall()) {
			this.linkToTopWall();
		} else {
			this.bounce();
		}
	}

	private void linkToTopWall() {
		this.shootingBubble.setPosition(this.getPositionToLink());
		if (!this.gridManager.getBubbleNeighbours(shootingBubble).isEmpty()) {
			CollisionHandler handler = new GridCollisionHandler(shootingBubble,
					this.gridManager.getBubbleNeighbours(shootingBubble).stream().findFirst().get(), this.gridManager);
			handler.handle();
		} else {
			this.shootingBubble = this.gridManager.addToGrid(shootingBubble, this.getPositionToLink());
		}
	}

	private Point2D getPositionToLink() {
		double min = GameCostants.GUIWIDTH.getValue();
		double finalPos = this.shootingBubble.getPosition().getX();
		double offset = !this.gridManager.isOffsetRaw() ? GameCostants.BUBBLE_WIDTH.getValue()
				: GameCostants.BUBBLE_WIDTH.getValue() / 2;
		for (double i = 0; i <= GameCostants.ROW_BUBBLE.getValue(); i++) {
			double xPos = i * GameCostants.BUBBLE_WIDTH.getValue() + offset;
			double distance = Math.abs(xPos - shootingBubble.getPosition().getX());
			if (distance < min) {
				min = distance;
				finalPos = xPos;
			}
		}
		return new Point2D(finalPos, GameCostants.BUBBLE_HEIGTH.getValue() / 2);
	}

	private boolean isTopWall() {
		return this.shootingBubble.getPosition().getY() <= GameCostants.BUBBLE_HEIGTH.getValue() / 2;
	}

	private void bounce() {
		this.shootingBubble.setDirection(
				new Point2D(this.shootingBubble.getDirection().getX() * -1, this.shootingBubble.getDirection().getY()));
	}

}
