package bubbleshooter.model.gameobject;

import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.Geometry;
import org.locationtech.jts.util.GeometricShapeFactory;

public class BasicBubble extends AbstractGameObject  {

    
    
    private Geometry shape; 

    

    public BasicBubble(Coordinate position, double width, double heigth){
        super(GameObjectsTypes.BASICBUBBLE, position, width, heigth);
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
}
