package bubbleshooter.model.gameobject;

import org.locationtech.jts.geom.Geometry;
import org.locationtech.jts.util.GeometricShapeFactory;
import javafx.geometry.Point2D;

public class BasicBubble extends AbstractGameObject {


    public BasicBubble(Point2D position, Property property) {
        super(position, property);
        super.setType(GameObjectsTypes.BASICBUBBLE);
    }

    @Override
    public void update(double elapsed) {
        // todo
    }


}
