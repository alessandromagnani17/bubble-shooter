package bubbleshooter.model.gameobject;

import bubbleshooter.model.component.CollisionComponent;
import bubbleshooter.model.component.ShootingComponent;
import javafx.geometry.Point2D;

public class ShootingBubble extends AbstractBubble {
	
	public ShootingBubble(final Point2D position) {
		super(BubbleType.SHOOTING_BUBBLE, position);
		this.setComponents();
	}

	@Override
	protected final void setComponents() {
		this.addComponent(new CollisionComponent());
		this.addComponent(new ShootingComponent());
	}
	
}
