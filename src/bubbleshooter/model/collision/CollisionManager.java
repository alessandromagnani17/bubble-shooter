package bubbleshooter.model.collision;


import bubbleshooter.model.gameobject.GameObject;
import javafx.geometry.Point2D;

public class CollisionManager {


    public final void resolveCollsion(final Collision collision) {
        switch (collision.getCollistionType()) {
        case bubbleToGrid :
            //LINK OR POP
        case bubbleToLeftWall:
            GameObject shootingBubble = collision.getFirstCollided();
            Point2D oldDirection = shootingBubble.getDirection();
            shootingBubble.setDirection(new Point2D(oldDirection.getX() * -1, oldDirection.getY()));
            break;
        case bubbleToRightWall:
        case gridToCannon:
            //GAMEOVER
            break;
        default:
            break;
        }
    }
}
