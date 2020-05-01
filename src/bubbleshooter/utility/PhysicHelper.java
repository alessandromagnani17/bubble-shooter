package bubbleshooter.utility;

import bubbleshooter.model.gameobject.Bubble;
import javafx.geometry.Point2D;
import javafx.scene.input.MouseEvent;

 public final class PhysicHelper {

    private PhysicHelper() {
    }

    public static Point2D calculateShootingDirection(final Point2D inputPosition, final Point2D bubblePosition) {
        double angle = Math.atan2(inputPosition.getY() - bubblePosition.getY(), inputPosition.getX() - bubblePosition.getX());
        double xVel = GameCostants.BUBBLESPEED.getValue() * Math.cos(angle);
        double yVel = GameCostants.BUBBLESPEED.getValue() * Math.sin(angle);
        return new Point2D(xVel, yVel);
    }

    public static void bounce(final Bubble shootingBubble) {
        shootingBubble.setDirection(new Point2D(shootingBubble.getDirection().getX() * -1, shootingBubble.getDirection().getY()));
    }
    
    public static double calculateAngle(final MouseEvent event, final double xBubble, final double yBubble) {
        double hypotenuse = Math.sqrt(Math.pow(event.getX() - xBubble, 2) + Math.pow(event.getY() - yBubble, 2));
        double cathetus = (event.getX() - xBubble);

        return Math.toDegrees(Math.asin(cathetus / hypotenuse));
    }
}
