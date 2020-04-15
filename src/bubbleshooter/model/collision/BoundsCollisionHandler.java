package bubbleshooter.model.collision;

import bubbleshooter.model.gameobject.GameObject;
import bubbleshooter.model.gameobject.BubbleGridManager;
import javafx.geometry.Point2D;

public class BoundsCollisionHandler implements CollisionHandler {

    private GameObject shootingBubble;
    private BubbleGridManager gridManager;
    
    public BoundsCollisionHandler(final GameObject shootingBubble, final BubbleGridManager gridManager) {
        this.shootingBubble = shootingBubble;
        this.gridManager = gridManager;
    }

    @Override
    public void handle() {
        //SE IL MURO È UNO DEI 2 DI LATO 
        Point2D newDirection = new Point2D(this.shootingBubble.getDirection().getX() * -1, this.shootingBubble.getDirection().getY());
        this.shootingBubble.setDirection(newDirection);
        //GESTIRE MURO IN ALTO
    }

}
