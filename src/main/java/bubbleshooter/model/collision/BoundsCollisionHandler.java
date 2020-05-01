package bubbleshooter.model.collision;

import bubbleshooter.utility.GameCostants;
import bubbleshooter.utility.PhysicHelper;
import bubbleshooter.model.gamemodality.AbstractGameMode;
import bubbleshooter.model.gameobject.Bubble;
import bubbleshooter.model.gameobject.BubbleGridHelper;
import bubbleshooter.model.gameobject.BubbleGridManager;
import javafx.geometry.Point2D;

public class BoundsCollisionHandler implements CollisionHandler {

    private final Bubble shootingBubble;
    private final AbstractGameMode level;
    private final BubbleGridManager gridManager;
    private final BubbleGridHelper gridHelper;

    public BoundsCollisionHandler(final Bubble shootingBubble, final AbstractGameMode level) {
        this.shootingBubble = shootingBubble;
        this.gridManager = level.getGridManager();
        this.gridHelper = level.getGridHelper();
        this.level = level;
    }

    @Override
    public final void handle() {
        if (this.isTopWall()) {
           this.linkToTopWall();
        } else {
            PhysicHelper.bounce(this.shootingBubble);
        }
    }

    private boolean isTopWall() {
        return this.shootingBubble.getPosition().getY() <= this.shootingBubble.getRadius();
    }

    private boolean hasNeighbour() {
        return this.gridHelper.getBubbleNeighbours(shootingBubble).size() > 0;
    }

    private void linkToTopWall() {
        this.shootingBubble.setPosition(this.getPositionToLink());
        if (!this.hasNeighbour()) {
            this.gridManager.addToGrid(shootingBubble, this.getPositionToLink());
        } else {
            Collision collision = new Collision(shootingBubble, this.gridHelper.getBubbleNeighbours(shootingBubble)
                                                                                .stream()
                                                                                .findFirst().get());
            CollisionHandler handler = new GridCollisionHandler(collision, this.level);
            handler.handle();
          }
        }

    private Point2D getPositionToLink() {
       double min = GameCostants.GUIWIDTH.getValue();
       double finalPos = this.shootingBubble.getPosition().getX();
       double offset = !this.gridManager.isOffsetRaw() ? this.shootingBubble.getWidth() : this.shootingBubble.getRadius();
       for (double i = 0; i <= GameCostants.ROW_BUBBLE.getValue(); i++) {
           double xPos = i * this.shootingBubble.getWidth() + offset;
           double distance = Math.abs(xPos - shootingBubble.getPosition().getX());
           if (distance < min) {
               min = distance;
               finalPos = xPos;
           }
       }
      return new Point2D(finalPos, this.shootingBubble.getRadius());
    }
}
