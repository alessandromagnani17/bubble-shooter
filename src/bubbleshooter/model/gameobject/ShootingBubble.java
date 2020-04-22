package bubbleshooter.model.gameobject;

import javafx.geometry.Point2D;

public class ShootingBubble extends AbstractBubble {

	private Point2D shootingDirection;

	public ShootingBubble(Point2D position) {
		super(BubbleType.SHOOTING_BUBBLE, position);
	}

	public final void setDirection(final Point2D direction) {
		this.shootingDirection = direction;
	}

	public final Point2D getDirection() {
		return this.shootingDirection;
	}

	public final void update(final double elapsed) {
		if (!this.shootingDirection.equals(this.getPosition())) {
			super.setPosition(super.getPosition().add(this.shootingDirection.multiply(elapsed)));
		}
	}

}
