package bubbleshooter.model.gameobject;


import javafx.geometry.Point2D;

public abstract class AbstractGameObject implements GameObject {

    private GameObjectsTypes type;
    private Point2D position;
    private boolean isOver = false;
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
    public Point2D getPosition() {
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
