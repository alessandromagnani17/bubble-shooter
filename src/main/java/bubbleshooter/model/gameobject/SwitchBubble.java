package bubbleshooter.model.gameobject;

import bubbleshooter.model.component.ComponentType;
import javafx.geometry.Point2D;

public class SwitchBubble extends AbstractBubble {

    public SwitchBubble(final Point2D position, final BubbleColor color) {
        super(BubbleType.SWITCH_BUBBLE, position, color);
    }

    @Override
    public final void update(final double elapsed) {
        this.getComponent(ComponentType.SWITCHCOMPONENT).get().update(elapsed);
    }

    @Override
    protected void setComponents() {
    }
}
