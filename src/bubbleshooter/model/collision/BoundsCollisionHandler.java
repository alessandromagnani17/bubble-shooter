package bubbleshooter.model.collision;

import bubbleshooter.model.gameobject.GameObject;
import javafx.geometry.Point2D;

public class BubbleToBoundsHandler implements CollisionHandler {

    private GameObject shootingBubble;

    public BubbleToBoundsHandler(final GameObject shootingBubble) {
        this.shootingBubble = shootingBubble;
    }

    @Override
    public void handle() {
        Point2D newDirection = new Point2D(this.shootingBubble.getDirection().getX() * -1, this.shootingBubble.getDirection().getY());
        this.shootingBubble.setDirection(newDirection);
    }

}
