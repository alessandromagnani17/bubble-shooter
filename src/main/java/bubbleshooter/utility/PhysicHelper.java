package bubbleshooter.utility;

import bubbleshooter.model.gameobject.Bubble;
import javafx.geometry.Point2D;
import javafx.scene.input.MouseEvent;

 public final class PhysicHelper {
	 
	 private static final double MAXANGLE =  65.0;
	    private static final double MINANGLE = -65.0;

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
    
    public static double calculateAngle(final MouseEvent event, final double xBubble, final double yBubble) {
        double hypotenuse = Math.sqrt(Math.pow(event.getX() - xBubble, 2) + Math.pow(event.getY() - yBubble, 2));
        double cathetus = (event.getX() - xBubble);

        return checkAngle(Math.toDegrees(Math.asin(cathetus / hypotenuse)));
    }
    
    private static double checkAngle(final double angle) {
        if (angle > MAXANGLE) {
            return MAXANGLE;
        } else if (angle < MINANGLE) {
            return MINANGLE;
        }
        return angle;
    }

	public static double calculateAngularCoefficient(double x1, double y1, double x2, double y2) {
		return (y2-y1)/(x2-x1);
	}
}
