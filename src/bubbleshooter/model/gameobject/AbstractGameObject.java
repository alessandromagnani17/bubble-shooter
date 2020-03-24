 package bubbleshooter.model.gameobject;

import org.locationtech.jts.geom.Coordinate;

public abstract class AbstractGameObject implements GameObject {

    private GameObjectsTypes type;
    private Coordinate position;
    private double width;
    private double heigth;
    private boolean isAvailable; 
    
    

    public AbstractGameObject(GameObjectsTypes type, Coordinate position, double width, double heigth) {
        this.type = type;
        this.position = position; 
        this.width = width; 
        this.heigth = heigth; 
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
    public Coordinate getPosition() {
        return this.position;
    }

    @Override
    public void setPosition(final Coordinate position) {
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
        return !this.isAvailable; 
    }
    
    public final void destroy() {
        this.isAvailable = false; 
    }
    
}
