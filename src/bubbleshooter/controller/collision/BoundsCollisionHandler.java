package bubbleshooter.controller.collision;

import bubbleshooter.model.gameobject.GameObject;
import bubbleshooter.utility.GameCostants;
import bubbleshooter.utility.PhysicHelper;
import bubbleshooter.utility.Utility;
import bubbleshooter.model.gamemodality.LevelTypes;
import bubbleshooter.model.gameobject.BubbleGridManager;

import javafx.geometry.Point2D;

public class BoundsCollisionHandler implements CollisionHandler {

    private GameObject shootingBubble;
    private final BubbleGridManager gridManager;
    private final LevelTypes levelType;

    public BoundsCollisionHandler(final GameObject shootingBubble, final BubbleGridManager gridManager, final LevelTypes levelTypes) {
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
            this.shootingBubble = this.gridManager.addToGrid(shootingBubble, this.getPositionToLink());
        } else {
            Collision collision = new Collision(shootingBubble, this.gridManager.getBubbleNeighbours(shootingBubble)
                                                                                .stream()
                                                                                .findFirst().get());
            CollisionHandler handler = new GridCollisionHandler(collision, this.gridManager, this.levelType);
            handler.handle();
          }
        }

    private boolean isTopWall() {
        return this.shootingBubble.getPosition().getY() <= Utility.getBubbleWidth() / 2;
    }

    private boolean hasNeighbour() {
        return this.gridManager.getBubbleNeighbours(shootingBubble).size() > 0;
    }

    private Point2D getPositionToLink() {
       double min = Utility.getGuiWidth();
       double finalPos = this.shootingBubble.getPosition().getX();
       double offset = !this.gridManager.isOffsetRaw() ? Utility.getBubbleWidth() : Utility.getBubbleWidth() / 2;
       for (double i = 0; i <= Utility.getRowBubble(); i++) {
           double xPos = i * Utility.getBubbleWidth() + offset;
           double distance = Math.abs(xPos - shootingBubble.getPosition().getX());
           if (distance < min) {
               min = distance;
               finalPos = xPos;
           }
       }
      return new Point2D(finalPos, Utility.getBubbleWidth() / 2);
    }
}
