package bubbleshooter.model.collision;

import bubbleshooter.utility.PhysicHelper;
import bubbleshooter.utility.Settings;
import bubbleshooter.model.gamemodality.GameMode;
import bubbleshooter.model.gameobject.Bubble;
import javafx.geometry.Point2D;

/**
 * Class used to check the {@link Collision} of a {@link Bubble} with the boundaries of the game.
 */
public class BoundsCollisionHandler implements CollisionHandler {

    private final Bubble shootingBubble;
    private final GameMode level;

    /**
     * @param shootingBubble the shootingBubble of the game.
     * @param level the current level of the game.
     */
    public BoundsCollisionHandler(final Bubble shootingBubble, final GameMode level) {
        this.shootingBubble = shootingBubble;
        this.level = level;
    }

    /**
    * The method which handle the {@link Collision}.
    * It calls the static method of {@link PhysicHelper} to make the {@link Bubble} bounce.
    */
    @Override
    public final void handle() {
        if (this.isTopWall()) {
           this.linkToTopWall();
        } else {
            PhysicHelper.bounce(this.shootingBubble);
        }
    }

    /**
     * @return true if the {@link Bubble} collides with the top wall.
     */
    private boolean isTopWall() {
        return this.shootingBubble.getPosition().getY() <= Bubble.getRadius();
    }

    /**
     * @return true if the {@link Bubble} has neighbor when it snaps to the wall.
     */
    private boolean hasNeighbour() {
        return this.level.getGridHelper().getBubbleNeighbours(shootingBubble).size() > 0;
    }

    /**
     * Method to snap the {@link Bubble} to the top wall and check if a {@link Collision} has appened.
     */
    private void linkToTopWall() {
        this.shootingBubble.setPosition(this.getPositionToLink());
        if (!this.hasNeighbour()) {
            this.level.getGridManager().addToGrid(shootingBubble, this.getPositionToLink());
        } else {
            final Collision collision = new Collision(shootingBubble, this.level.getGridHelper().getBubbleNeighbours(shootingBubble)
                                                                                .stream()
                                                                                .findFirst().get());
            final CollisionHandler handler = new GridCollisionHandler(collision, this.level);
            handler.handle();
          }
        }

    /**
     * @return the right position of the {@link Bubble} in the top wall.
     */
    private Point2D getPositionToLink() {
       double min = Settings.getGuiWidth();
       double finalPos = this.shootingBubble.getPosition().getX();
       final double offset = !this.level.getGridManager().isOffsetRaw() ? Bubble.getWidth() : Bubble.getRadius();
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
