package bubbleshooter.model.gameobject;

import javafx.geometry.Point2D;
import javafx.scene.shape.Shape;

public abstract class AbstractGameObject implements GameObject {

    private GameObjectsTypes type;
    private Point2D position;
    private boolean isDestroyed = false;
    private double width;
    private double heigth;
    private Shape shape;
    private Property property;

    public AbstractGameObject(Point2D position) {
        this.position = position;
        this.isDestroyed = false;
   }

    @Override
    public final double getHeight() {
        return this.heigth;
    }

    @Override
    public final double getWidth() {
        return this.width;
    }

    @Override
    public final Point2D getPosition() {
        return this.position;
    }

    @Override
    public Point2D getDirection() {
        return this.position;
    }

    @Override
    public void setPosition(final Point2D position) {
        this.position = position;
    }

    @Override
    public  void setDirection(final Point2D direction) {
        this.position = direction;
    }

    @Override
    public final void setHeigth(final double heigth) {
        this.heigth = heigth;
    }

    @Override
    public final void setWidth(final double width) {
        this.width = width;
    }
    @Override
    public final boolean isDestroyed() {
        return this.isDestroyed;
    }

    @Override
    public void update(final double elapsed) {
        // TODO Auto-generated method stub
    }

    @Override
    public GameObjectsTypes getType() {
        return this.type;
    }

    @Override
    public void setType(final GameObjectsTypes type) {
        this.type = type;
    }

    @Override
    public void setProperty(final Property property) {
        this.property = property;
    }

    public final Property getProperty() {
        return this.property;
    }

    public final void destroy() {
        this.isDestroyed = true;
    }
}
