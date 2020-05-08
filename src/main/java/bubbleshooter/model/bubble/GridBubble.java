package bubbleshooter.model.bubble;

import bubbleshooter.model.component.CollisionComponent;
import javafx.geometry.Point2D;

public class GridBubble extends AbstractBubble {

    public GridBubble(final Point2D position, final BubbleColor color) {
        super(BubbleType.GRID_BUBBLE, position, color);
    }

    @Override
    protected final void setComponents() {
        this.addComponent(new CollisionComponent(this));
    }
}
