package bubbleshooter.model.collision;

import bubbleshooter.utility.GameCostants;
import bubbleshooter.utility.PhysicHelper;
import bubbleshooter.model.gamemodality.LevelTypes;
import bubbleshooter.model.gameobject.Bubble;
import bubbleshooter.model.gameobject.BubbleGridManager;
import javafx.geometry.Point2D;

public class BoundsCollisionHandler implements CollisionHandler {

    private Bubble shootingBubble;
    private final BubbleGridManager gridManager;
    private final LevelTypes levelType;

    public BoundsCollisionHandler(final Bubble shootingBubble, final BubbleGridManager gridManager, final LevelTypes levelTypes) {
        this.shootingBubble = shootingBubble;
        this.gridManager = gridManager;
        this.levelType = levelTypes;
    }

    @Override
    public final void handle() {
        if (this.isTopWall()) {
           this.linkToTopWall();
        } else {
            PhysicHelper.bounce(this.shootingBubble);
        }
    }

    private void linkToTopWall() {
        this.shootingBubble.setPosition(this.getPositionToLink());
        if (!this.hasNeighbour()) {
            this.gridManager.addToGrid(shootingBubble, this.getPositionToLink());
        } else {
            Collision collision = new Collision(shootingBubble, this.gridManager.getBubbleNeighbours(shootingBubble)
                                                                                .stream()
                                                                                .findFirst().get());
            CollisionHandler handler = new GridCollisionHandler(collision, this.gridManager, this.levelType);
            handler.handle();
          }
        }

    private boolean isTopWall() {
        return this.shootingBubble.getPosition().getY() <= GameCostants.BUBBLE_WIDTH.getValue() / 2;
    }

    private boolean hasNeighbour() {
        return this.gridManager.getBubbleNeighbours(shootingBubble).size() > 0;
    }

    private Point2D getPositionToLink() {
       double min = GameCostants.GUIWIDTH.getValue();
       double finalPos = this.shootingBubble.getPosition().getX();
       double offset = !this.gridManager.isOffsetRaw() ? GameCostants.BUBBLE_WIDTH.getValue() : GameCostants.BUBBLE_WIDTH.getValue() / 2;
       for (double i = 0; i <= GameCostants.ROW_BUBBLE.getValue(); i++) {
           double xPos = i * GameCostants.BUBBLE_WIDTH.getValue() + offset;
           double distance = Math.abs(xPos - shootingBubble.getPosition().getX());
           if (distance < min) {
               min = distance;
               finalPos = xPos;
           }
       }
      return new Point2D(finalPos, GameCostants.BUBBLE_WIDTH.getValue() / 2);
    }
}
