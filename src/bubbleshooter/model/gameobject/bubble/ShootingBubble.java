package bubbleshooter.model.gameobject.bubble;


import bubbleshooter.model.collision.GridCollisionHandler;
import bubbleshooter.model.collision.CollisionHandler;
import bubbleshooter.model.collision.Visitor;
import bubbleshooter.model.gameobject.GameObject;
import bubbleshooter.model.gameobject.GameObjectsTypes;
import bubbleshooter.utility.GameCostants;
import javafx.geometry.Point2D;


public class ShootingBubble extends BasicBubble implements Visitor {

    private Point2D shootingDirection;

    public ShootingBubble(final Point2D position) {
        super(position);
        super.setType(GameObjectsTypes.SHOOTINGBUBBLE);
        this.shootingDirection = this.getPosition();
    }


    //IL METODO CHE DEVE CHIAMARE IL CONTROLLER QUANDO C'E IL CLICK 
    //IL CONTROLLER MI PASSA IL PUNTO CLICCATO DAL MOUSE
    //E IO MI CALCOLO LA DIREZIONE GIUSTA COL METODO PRIVATO
    public final void setDirection(final Point2D inputPosition) {
        this.shootingDirection = this.calculateDirection(inputPosition);
    }

    public final Point2D getDirection() {
        return this.shootingDirection;
    }

    public final void update(final double elapsed) {
        this.setPosition(this.getPosition().add(this.shootingDirection));
    }

    public final Point2D calculateDirection(final Point2D inputPosition) {
        double angle = Math.atan2(inputPosition.getY(), inputPosition.getX());
        double xVel = GameCostants.BUBBLESPEED.getValue() * Math.cos(angle);
        double yVel = GameCostants.BUBBLESPEED.getValue() * Math.sin(angle);
        return new Point2D(xVel, yVel);
    }


    @Override
    public final void visit(final GameObject gameObject, final GameObjectsTypes type, final BubbleGridManager gridManager) {
        CollisionHandler handler = new GridCollisionHandler(this, gameObject, gridManager);
        handler.handle();
    }
}
