package bubbleshooter.model.collision;

import bubbleshooter.model.gamemodality.GameModality;
import bubbleshooter.model.gameobject.GameObject;
import bubbleshooter.model.gameobject.ShootingBubble;
import bubbleshooter.utility.GameCostants;

public class CollisionController {

    private GameModality level;

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
        GameObject shootingBubble = this.level.getGameObjectManager().getShootingBubble();
        double xPos = shootingBubble.getPosition().getX() + GameCostants.RADIUS.getValue();
        if (xPos >= GameCostants.GUIWIDTH.getValue() || xPos <= 0) {
            CollisionHandler handler = new BoundsCollisionHandler(shootingBubble, this.level.getGridManager());
            handler.handle();
        }
    }

    private void checkGridCollision() {
        GameObject shootingBubble = this.level.getGameObjectManager().getShootingBubble();
        for (GameObject basicbubble : this.level.getGridManager().getBubbleGrid()) {
            if (this.hasCollided(shootingBubble, basicbubble)) {
              Acceptor acceptor = new GameObjectAcceptor(basicbubble);
              Visitor visitor = new GameObjectVisitor(shootingBubble);
              acceptor.accept(visitor, this.level.getGridManager());
            }
            break;
        }
    }

    private void checkGameOver() {

       } 

    private boolean hasCollided(final GameObject bubbleAt, final GameObject bubbleTo) {
        return this.level.getGridManager().getDistanceBetweenBubbles(bubbleAt, bubbleTo) <= GameCostants.RADIUS.getValue() * 2;
    }

}
