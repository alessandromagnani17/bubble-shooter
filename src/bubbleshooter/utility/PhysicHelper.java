package bubbleshooter.utility;

import bubbleshooter.model.gameobject.GameObject;
import javafx.geometry.Point2D;

 public final class PhysicHelper {

    private PhysicHelper() {
    }

    public static Point2D calculateShootingDirection(final Point2D inputPosition, final Point2D bubblePosition) {
        double angle = Math.atan2(inputPosition.getY() - bubblePosition.getY(), inputPosition.getX() - bubblePosition.getX());
        double xVel = Utility.getBubbleSpeed() * Math.cos(angle);
        double yVel = Utility.getBubbleSpeed() * Math.sin(angle);
        return new Point2D(xVel, yVel);
    }

    public static void bounce(final GameObject gameObject) {
        gameObject.setDirection(new Point2D(gameObject.getDirection().getX() * -1, gameObject.getDirection().getY()));
    }
}
