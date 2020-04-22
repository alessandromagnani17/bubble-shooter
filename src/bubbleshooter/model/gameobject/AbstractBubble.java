package bubbleshooter.model.gameobject;

import bubbleshooter.utility.GameCostants;
import javafx.geometry.Point2D;

public abstract class AbstractBubble implements Bubble {

	private Point2D position;
	private boolean isDestroyed;
	private double radius;
	private BubbleType type;
	private BubbleColor color;

	public AbstractBubble(BubbleType type, Point2D position) {
		this.isDestroyed = false;
		this.radius = GameCostants.RADIUS.getValue();

	}

	@Override
	public Point2D getPosition() {
		return this.position;
	}

	@Override
	public void setPosition(Point2D position) {
		this.position = position;

	}

	@Override
	public boolean isDestroyed() {
		return this.isDestroyed;
	}

	@Override
	public void destroy() {
		this.isDestroyed = true;

	}

	@Override
	public double getRadius() {
		return this.radius;
	}

	@Override
	public void setRadius(double radius) {
		this.radius = radius;

	}

	@Override
	public BubbleType getType() {
		return this.type;
	}

	public void setType(BubbleType type) {
		this.type = type;
	}

	@Override
	public BubbleColor getColor() {
		return this.color;
	}

	@Override
	public void setColor(BubbleColor color) {
		this.color = color;
	}

}
