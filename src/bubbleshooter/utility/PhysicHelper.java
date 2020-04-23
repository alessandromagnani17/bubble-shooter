package bubbleshooter.utility;

import bubbleshooter.model.component.ComponentType;
import bubbleshooter.model.component.ShootingComponent;
import bubbleshooter.model.gameobject.Bubble;
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

    public static void bounce(final Bubble shootingBubble) {
        ShootingComponent shootingComponent = (ShootingComponent) shootingBubble.getComponents().stream()
                                                                                .filter(a -> a.getComponentType().equals(ComponentType.SHOOTINGCOMPONENT))
                                                                                .findFirst().get();
        shootingComponent.setDirection(new Point2D(shootingComponent.getDirection().getX() * -1, shootingComponent.getDirection().getY()));
    }
}
