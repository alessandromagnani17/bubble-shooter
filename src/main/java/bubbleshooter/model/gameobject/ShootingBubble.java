package bubbleshooter.model.gameobject;

import bubbleshooter.model.component.CollisionComponent;
import bubbleshooter.model.component.ComponentType;
import bubbleshooter.model.component.ShootingComponent;
import javafx.geometry.Point2D;

public class ShootingBubble extends AbstractBubble {
	
	public ShootingBubble(final Point2D position) {
		super(BubbleType.SHOOTING_BUBBLE, position);
	}

	@Override
	protected final void setComponents() {
		this.addComponent(new ShootingComponent(this));
		this.addComponent(new CollisionComponent(this));
	}

	@Override
	public final void update(final double elapsed) {
        this.getComponent(ComponentType.SHOOTINGCOMPONENT).get().update(elapsed);
	}
	
}
