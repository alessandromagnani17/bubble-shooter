package bubbleshooter.model.collision;

import bubbleshooter.utility.PhysicHelper;
import bubbleshooter.utility.Settings;
import bubbleshooter.model.gamemodality.AbstractGameMode;
import bubbleshooter.model.gameobject.Bubble;
import bubbleshooter.model.gameobject.BubbleGridHelper;
import bubbleshooter.model.gameobject.BubbleGridManager;
import javafx.geometry.Point2D;

/**
 * 
 * Class used to check the {@link Collision} of a {@link Bubble} with the Wall.
 *
 */
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
        return this.shootingBubble.getPosition().getY() <= Bubble.getRadius();
    }

    private boolean hasNeighbour() {
        return this.gridHelper.getBubbleNeighbours(shootingBubble).size() > 0;
    }

    private void linkToTopWall() {
        this.shootingBubble.setPosition(this.getPositionToLink());
        if (!this.hasNeighbour()) {
            this.gridManager.addToGrid(shootingBubble, this.getPositionToLink());
        } else {
            final Collision collision = new Collision(shootingBubble, this.gridHelper.getBubbleNeighbours(shootingBubble)
                                                                                .stream()
                                                                                .findFirst().get());
            final CollisionHandler handler = new GridCollisionHandler(collision, this.level);
            handler.handle();
          }
        }

    private Point2D getPositionToLink() {
       double min = Settings.getGuiWidth();
       double finalPos = this.shootingBubble.getPosition().getX();
       final double offset = !this.gridManager.isOffsetRaw() ? Bubble.getWidth() : Bubble.getRadius();
       for (double i = 0; i <= Settings.getNumBubbles(); i++) {
           final double xPos = i * Bubble.getWidth() + offset;
           final double distance = Math.abs(xPos - shootingBubble.getPosition().getX());
           if (distance < min) {
               min = distance;
               finalPos = xPos;
           }
       }
      return new Point2D(finalPos, Bubble.getRadius());
    }
}
