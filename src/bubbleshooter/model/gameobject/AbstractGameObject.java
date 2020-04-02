 package bubbleshooter.model.gameobject;

import org.locationtech.jts.geom.Coordinate;

import javafx.geometry.Point2D;

public abstract class AbstractGameObject implements GameObject {

    private GameObjectsTypes type;
    private Point2D position;
    private double width;
    private double heigth;
    private boolean isDestroyed; 
    
    

    public AbstractGameObject(GameObjectsTypes type,  Point2D position, double width, double heigth) {
        this.type = type;
        this.position = position; 
        this.width = width; 
        this.heigth = heigth; 
        this.isDestroyed = false; 
    }
    

    @Override
    public double getHeight() {
        return this.heigth;
    }

    @Override
    public double getWidth() {
        return this.width;
    }

    @Override
    public Point2D getPosition() {
        return this.position;
    }

    @Override
    public void setPosition(final Point2D position) {
        this.position = position;
    }

    @Override
    public void setHeigth(final double heigth) {
        this.heigth = heigth;
    }

    @Override
    public void setWidth(final double width) {
        this.width = width;
    }

    @Override
    public GameObjectsTypes getType() {
        return this.type;
    }

    @Override
    public void setType(final GameObjectsTypes type) {
        this.type = type;
    }
    
    public final boolean isDestroyed() {
        return this.isDestroyed; 
    }
    
    public final void destroy() {
        this.isDestroyed = true; 
    }
    
}
