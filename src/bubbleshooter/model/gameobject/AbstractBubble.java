package bubbleshooter.model.gameobject;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import bubbleshooter.model.component.Component;
import bubbleshooter.model.component.ComponentType;
import bubbleshooter.utility.GameCostants;
import javafx.geometry.Point2D;

public abstract class AbstractBubble implements Bubble {

	private Point2D position;
	private Point2D direction;
	private boolean isDestroyed;
	private double radius;
	private BubbleType type;
	private BubbleColor color;
	private List<Component> components;

	public AbstractBubble(final BubbleType type, final Point2D position) {
		this.type = type;
		this.position = position;
		this.direction = position;
		this.isDestroyed = false;
		this.radius = GameCostants.RADIUS.getValue();
		this.color = BubbleColor.getRandomColor();
		this.type = type;
		this.position = position;
		this.components = new LinkedList<>();
	}

	protected abstract void setComponents();

	public final List<Component> getComponents() {
		return this.components;
	}

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
	public final void setRadius(final double radius) {
		this.radius = radius;

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
	public void update(final double elapsed) {
		this.components.forEach(a -> a.update(elapsed));
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
	public void addComponent(final Component component) {
		component.setContainer(this);
		this.components.add(component);
	}

}
