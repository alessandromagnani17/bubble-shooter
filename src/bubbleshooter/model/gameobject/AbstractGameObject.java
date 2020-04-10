package bubbleshooter.model.gameobject; 
import javafx.geometry.Point2D;

public abstract class AbstractGameObject implements GameObject {

    
    private Point2D position;
    private double width;
    private double heigth;
    private boolean isDestroyed; 
    private Property property; 
    private GameObjectsTypes type; 
    

    public AbstractGameObject(Point2D position) {
        this.position = position;
        this.property = Property.getRandomColor(); 
        this.isDestroyed = false; 
    }
    
    @Override
    public Property getColor() {
        return this.property;  
    }

    
    public GameObjectsTypes getType() {
        return type;
    }
    
    public void setType(GameObjectsTypes type) {
        this.type = type;
    }

    
    @Override
    public Property getProperty() {
        return this.property; 
    }
    
    public void setProperty(Property property) {
        this.property = property;
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
