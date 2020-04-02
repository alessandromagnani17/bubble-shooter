 package bubbleshooter.model.gameobject;

import org.locationtech.jts.geom.Coordinate;

import javafx.geometry.Point2D;

public abstract class AbstractGameObject implements GameObject {

    
    private Point2D position;
    private double width;
    private double heigth;
    private boolean isDestroyed; 
    

    public AbstractGameObject(Point2D position) {
        this.position = position; 
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
    
    public final boolean isDestroyed() {
        return this.isDestroyed; 
    }
    
    public final void destroy() {
        this.isDestroyed = true; 
    }
    
}
