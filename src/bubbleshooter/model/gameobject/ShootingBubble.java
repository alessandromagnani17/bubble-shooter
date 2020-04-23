package bubbleshooter.model.gameobject;

import bubbleshooter.model.component.CollisionComponent;
import bubbleshooter.model.component.ComponentType;
import bubbleshooter.model.component.ShootingComponent;
import javafx.geometry.Point2D;

public class ShootingBubble extends AbstractBubble {

	private Point2D shootingDirection;

	public ShootingBubble(final Point2D position) {
		super(BubbleType.SHOOTING_BUBBLE, position);
		this.addComponent(new ShootingComponent());
		this.addComponent(new CollisionComponent());
		this.getComponents().forEach(a -> a.setContainer(this));
	}

	public final void setDirection(final Point2D direction) {
		this.shootingDirection = direction;
	}

	public final Point2D getDirection() {
		return this.shootingDirection;
	}

	public final void update(final double elapsed) {
		//this.getComponents().stream().filter(a -> a.equals(ComponentType.SHOOTINGCOMPONENT)).findFirst().get().update(elapsed);
	}

}
