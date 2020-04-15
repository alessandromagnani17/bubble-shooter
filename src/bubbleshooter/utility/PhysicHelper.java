package bubbleshooter.utility;

import javafx.geometry.Point2D;

 public class PhysicHelper {

    public static final Point2D calculateShootingDirection(final Point2D inputPosition) {
        double angle = Math.atan2(inputPosition.getY(), inputPosition.getX());
        double xVel = GameCostants.BUBBLESPEED.getValue() * Math.cos(angle);
        double yVel = GameCostants.BUBBLESPEED.getValue() * Math.sin(angle);
        return new Point2D(xVel, yVel);
    }

}
