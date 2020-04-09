package bubbleshooter.model.collision;

import bubbleshooter.model.gameobject.GameObject;
import bubbleshooter.model.gameobject.bubble.BubbleGridManager;
import bubbleshooter.utility.GameCostants;
import javafx.geometry.Point2D;

public class BoundsCollisionHandler implements CollisionHandler {

    private final GameObject shootingBubble;
    private final BubbleGridManager gridManager;

    public BoundsCollisionHandler(final GameObject shootingBubble, final BubbleGridManager gridManager) {
        this.shootingBubble = shootingBubble;
        this.gridManager = gridManager;
    }

    @Override
    public final void handle() {
        if (this.isTopWall()) {
           this.linkToTopWall();
        } else {
            this.bounce();
        }
    }

    private void linkToTopWall() {
        this.gridManager.addToGrid(shootingBubble, this.getPositionToLink());
    }

    private Point2D getPositionToLink() {
       double min = 10000;
       double finalPos = 0;
       for (double i = GameCostants.BUBBLE_WIDTH.getValue() / 2; i <= GameCostants.GUIWIDTH.getValue(); i += GameCostants.BUBBLE_WIDTH.getValue()) {
           Point2D pos = new Point2D(i, GameCostants.BUBBLE_HEIGTH.getValue() / 2);
           double distance = Math.abs(i - shootingBubble.getPosition().getX());
           if (distance < min) {
               min = distance;
               finalPos = i;
           }
       }
      return new Point2D(finalPos, GameCostants.BUBBLE_HEIGTH.getValue() / 2);
    }

    private boolean isTopWall() {
        return this.shootingBubble.getPosition().getY() <= GameCostants.BUBBLE_HEIGTH.getValue() / 2;
    }

    private void bounce() {
        this.shootingBubble.setDirection(new Point2D(this.shootingBubble.getDirection().getX() * -1, this.shootingBubble.getDirection().getY()));
    }

}
