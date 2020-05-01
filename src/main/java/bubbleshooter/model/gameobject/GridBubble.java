package bubbleshooter.model.gameobject;

import bubbleshooter.model.component.CollisionComponent;
import javafx.geometry.Point2D;

public class GridBubble extends AbstractBubble {
	
	private CollisionComponent collisionComponent;
	
	public GridBubble(final Point2D position) {
		super(BubbleType.GRID_BUBBLE, position);
	}

	@Override
	protected final void setComponents() {
        this.addComponent(new CollisionComponent(this));
	}
}
