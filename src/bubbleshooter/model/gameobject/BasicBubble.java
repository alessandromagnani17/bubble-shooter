package bubbleshooter.model.gameobject;

import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.Geometry;
import org.locationtech.jts.util.GeometricShapeFactory;

import javafx.geometry.Point2D;

public class BasicBubble extends AbstractGameObject  {

    
    
    private Geometry shape;
    
    

    

    public BasicBubble(Point2D position){
        super(position);
        this.type = GameObjectsTypes.BASICBUBBLE; 
        this.shape = this.setCollisionBox(); 
    }

    @Override
    public Geometry setCollisionBox() {
        final GeometricShapeFactory shapeFactory = new GeometricShapeFactory();
        shapeFactory.setWidth(super.getWidth());
        shapeFactory.setHeight(super.getHeight());
        return shapeFactory.createCircle();
    }

    @Override
    public Geometry getCollisionBox() {
        return this.shape; 
    }

    @Override
    public void update(double elapsed) {
        //todo
    }
    @Override
    public GameObjectsTypes getType() {
        return this.type;
    }

    @Override
    public void setType(final GameObjectsTypes type) {
        this.type = type;
    }
}
