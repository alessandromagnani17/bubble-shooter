package bubbleshooter.utility;

import bubbleshooter.model.gameobject.Bubble;
import javafx.geometry.Point2D;

 public final class PhysicHelper {

    private PhysicHelper() {
    }

    public static Point2D calculateShootingDirection(final Point2D inputPosition, final Point2D bubblePosition) {
        double angle = Math.atan2(inputPosition.getY() - bubblePosition.getY(), inputPosition.getX() - bubblePosition.getX());
        double xVel = Math.cos(angle);
        double yVel = Math.sin(angle);
        return new Point2D(xVel, yVel);
    }

    public static void bounce(final Bubble shootingBubble) {
        shootingBubble.setDirection(new Point2D(shootingBubble.getDirection().get().getX() * -1, shootingBubble.getDirection().get().getY()));
    }
}
