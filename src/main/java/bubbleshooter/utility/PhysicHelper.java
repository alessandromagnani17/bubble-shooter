package bubbleshooter.utility;

import bubbleshooter.model.gameobject.Bubble;
import javafx.geometry.Point2D;

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
    
    public static double calculateAngle(final Point2D eventPosition, final Point2D shootingBubblePosition) {
        double hypotenuse = Math.sqrt(Math.pow(eventPosition.getX() - shootingBubblePosition.getX(), 2) + 
        		Math.pow(eventPosition.getY() - shootingBubblePosition.getY(), 2));
        double cathetus = (eventPosition.getX() - shootingBubblePosition.getX());

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

	public static double calculateAngularCoefficient(final Point2D startPointSecondLine, final Point2D endPointSecondLine) {
		return (endPointSecondLine.getY() - startPointSecondLine.getY()) / (endPointSecondLine.getX() - startPointSecondLine.getX());
	}

	public static double calculateIntercepts(final Point2D startPointSecondLine, final Point2D endPointSecondLine) {
		return (endPointSecondLine.getX() * startPointSecondLine.getY() - 
				startPointSecondLine.getX() * endPointSecondLine.getY()) / (endPointSecondLine.getX() - startPointSecondLine.getX());
	}

	public static boolean angleTooHigh(Point2D startPointFirstLine, Point2D startPointSecondLine) {
		double angle;
		angle = PhysicHelper.calculateAngle(startPointFirstLine, startPointSecondLine);
		if (angle > MAXANGLE-0.01) {
            return false;
        } else if (angle < MINANGLE+0.01) {
            return false;
        }
		return true;
	}
}
