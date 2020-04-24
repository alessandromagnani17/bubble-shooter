package bubbleshooter.model.gameobject;

import bubbleshooter.model.component.CollisionComponent;
import javafx.geometry.Point2D;
import javafx.scene.shape.Shape;

public class GridBubble extends AbstractBubble {
	
	private CollisionComponent collisionComponent;
	
	public GridBubble(final Point2D position) {
		super(BubbleType.GRID_BUBBLE, position);
	}

	@Override
	protected final void setComponents() {
        this.collisionComponent = new CollisionComponent();
        this.collisionComponent.setContainer(this);
	}

	@Override
	public final Shape getShape() {
		return this.collisionComponent.getCollisionShape();
	}

}
