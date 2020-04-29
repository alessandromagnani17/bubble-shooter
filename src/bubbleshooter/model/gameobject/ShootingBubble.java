package bubbleshooter.model.gameobject;

import bubbleshooter.model.component.CollisionComponent;
import bubbleshooter.model.component.ShootingComponent;
import javafx.geometry.Point2D;
import javafx.scene.shape.Shape;

public class ShootingBubble extends AbstractBubble {
	
	private CollisionComponent collisionComponent;
	private ShootingComponent shootingComponent;
	
	public ShootingBubble(final Point2D position) {
		super(BubbleType.SHOOTING_BUBBLE, position);
	}

	@Override
	protected final void setComponents() {
		this.collisionComponent = new CollisionComponent();
		this.shootingComponent = new ShootingComponent();
		this.collisionComponent.setContainer(this);
		this.shootingComponent.setContainer(this);
	}

	@Override
	public final Shape getShape() {
		return this.collisionComponent.getCollisionShape();
	}

	@Override
	public final void update(final double elapsed) {
        this.shootingComponent.update(elapsed);
	}
	
}
