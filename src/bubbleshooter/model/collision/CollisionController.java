package bubbleshooter.model.collision;

import java.util.Collections;

import bubbleshooter.model.gamemodality.GameModality;
import bubbleshooter.model.gameobject.GameObject;
import bubbleshooter.model.gameobject.ShootingBubble;
import bubbleshooter.utility.GameCostants;
import javafx.geometry.Point2D;

public class CollisionController {

    private final GameModality level;

    public CollisionController(final GameModality level) {
        this.level = level;
    }

    public final void checkCollisions() {
        this.checkGameCollisions();
        this.checkGameOver();
    }

    private void checkGameCollisions() {
        this.checkBounceCollision();
        this.checkGridCollision();
    }

    private void checkBounceCollision() {
        final GameObject shootingBubble = this.level.getGameObjectManager().getShootingBubble();
        final double xPos = shootingBubble.getPosition().getX();
        if (xPos + GameCostants.BUBBLE_WIDTH.getValue()/2 >= GameCostants.GUIWIDTH.getValue() ||
           xPos +  GameCostants.BUBBLE_WIDTH.getValue()/2 <= GameCostants.BUBBLE_WIDTH.getValue()/2) {
        	final CollisionHandler handler = new BoundsCollisionHandler(shootingBubble, this.level.getGridManager());
            handler.handle();
        }
    }

    private void checkGridCollision() {
        final GameObject shootingBubble = this.level.getGameObjectManager().getShootingBubble();
        for (final GameObject basicbubble : this.level.getGridManager().getBubbleGrid()) {
            if (this.hasCollided(shootingBubble, basicbubble)) {
                final Acceptor acceptor = new GameObjectAcceptor(basicbubble);
                final Visitor visitor = new GameObjectVisitor(shootingBubble);
              acceptor.accept(visitor, this.level.getGridManager());
              this.level.loadShootingBubble();
            }
        }
    }

    private void checkGameOver() {

       } 

    private boolean hasCollided(final GameObject bubbleAt, final GameObject bubbleTo) {
        return this.level.getGridManager().getDistanceBetweenBubbles(bubbleAt, bubbleTo) <= GameCostants.RADIUS.getValue() * 2;
    }

}
