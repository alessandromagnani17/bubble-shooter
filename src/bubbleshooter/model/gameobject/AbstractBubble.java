package bubbleshooter.model.gameobject;

import javafx.geometry.Point2D;
import javafx.scene.shape.Shape;

public abstract class AbstractBubble implements Bubble {

	private final double radius = 18;
	private Point2D position;
	private Point2D direction;
	private boolean isDestroyed;
	private BubbleType type;
	private BubbleColor color;
	
	public AbstractBubble(final BubbleType type, final Point2D position) {
		this.type = type;
		this.position = position;
		this.direction = position;
		this.isDestroyed = false;
		this.color = BubbleColor.getRandomColor();
		this.type = type;
		this.position = position;
		this.setComponents();
	}

	protected abstract void setComponents();

	@Override
	public final Point2D getPosition() {
		return this.position;
	}

	@Override
	public final void setPosition(final Point2D position) {
		this.position = position;
	}

	@Override
	public final boolean isDestroyed() {
		return this.isDestroyed;
	}

	@Override
	public final void destroy() {
		this.isDestroyed = true;

	}

	@Override
	public final double getRadius() {
		return this.radius;
	}

	@Override
	public final BubbleType getType() {
		return this.type;
	}

	public final void setType(final BubbleType type) {
		this.type = type;
	}

	@Override
	public final BubbleColor getColor() {
		return this.color;
	}

	@Override
	public final void setColor(final BubbleColor color) {
		this.color = color;
	}

	@Override
	public void update(final double elapsed){
	}

	@Override
	public Point2D getDirection() {
		return this.direction;
	}

	@Override
	public void setDirection(final Point2D direction) {
		this.direction = direction;
	}

	@Override
	public double getWidth() {
		return this.radius * 2;
	}
}
