package bubbleshooter.model.bubble;

import javafx.geometry.Point2D;

public final class BubbleFactory {

    public Bubble createGridBubble(final Point2D position, final BubbleColor color) {
        return new GridBubble(position, color);
    }

    public Bubble createShootingBubble(final Point2D position, final BubbleColor color) {
        return new ShootingBubble(position, color);
    }

    public Bubble createSwitchBubble(final Point2D position, final BubbleColor color) {
        return new SwitchBubble(position, color);
    }
}
