package bubbleshooter.model.gameobject;

import org.locationtech.jts.geom.Coordinate;

import org.locationtech.jts.math.Vector2D;
import javafx.geometry.Point2D;
import bubbleshooter.view.images.Color;

public class ShootingBubble extends BasicBubble  {

    public ShootingBubble(Point2D position, double width, double heigth) {
        super(position, width, heigth);
        // TODO Auto-generated constructor stub
    }

    /*private Vector2D direction;
    
    public ShootingBubble(final Coordinate position, final Color color) {
        super(position, color);
    }

    public final void setDirection(final Vector2D direction) {
        this.direction = direction;
    }
    
    public final Vector2D getDirection() {
        return this.direction;
    }*/
}
