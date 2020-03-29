package bubbleshooter.model.gameobject;

import javafx.geometry.Point2D;
import javafx.scene.shape.Shape;

public abstract class AbstractGameObject implements GameObject {

    private GameObjectsTypes type;
    private Point2D position;
    private boolean isOver = false;
    private double width;
    private double heigth;
    private Shape shape;

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
    public final boolean isOver() {
        return this.isOver;
    }

    @Override
    public void update(final double elapsed) {
        // TODO Auto-generated method stub
    }

    @Override
    public final GameObjectsTypes getType() {
        return this.type;
    }

    @Override
    public final void setType(final GameObjectsTypes type) {
        this.type = type;
    }

    @Override
    public final Shape getShape() {
        return this.shape;
    }

    @Override
    public final void setShape(final Shape shape) {
        this.shape = shape;
    }
}
