package bubbleshooter.model.gameobject;

import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.math.Vector2D;

public abstract class AbstractGameObject implements GameObject {

    private GameObjectsTypes type;
    private Vector2D position;
    private boolean isOver;
    private double width;
    private double heigth;

    @Override
    public double getHeight() {
        return this.heigth;
    }

    @Override
    public double getWidth() {
        return this.width;
    }

    @Override
    public Vector2D getPosition() {
        return this.position;
    }

    @Override
    public void setPosition(final Vector2D position) {
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
    public boolean isOver() {
        return this.isOver;
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
}
