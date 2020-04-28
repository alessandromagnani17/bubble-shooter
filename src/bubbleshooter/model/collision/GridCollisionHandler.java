package bubbleshooter.model.collision;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import bubbleshooter.utility.GameCostants;
import javafx.geometry.Point2D;
import bubbleshooter.model.gameobject.Bubble;
import bubbleshooter.model.gameobject.BubbleGridManager;

public class GridCollisionHandler implements CollisionHandler {

    private Bubble shootingBubble;
    private final Bubble basicBubble;
    private final BubbleGridManager gridManager;

    public GridCollisionHandler(final Collision collision, final BubbleGridManager gridManager) {
        this.shootingBubble = collision.getShootingBubble();
        this.basicBubble  = collision.getCollided();
        this.gridManager = gridManager;
       }

    @Override
    public final void handle() {
        this.linkToGrid();
        if (this.canExplode()) {
            this.explode();
         }
    }

    private void linkToGrid() {
        this.shootingBubble = this.gridManager.addToGrid(this.shootingBubble, this.getPositionToLink());
    }

    private void explode() {
        this.getBubblesToExplode(this.shootingBubble, new HashSet<>()).stream().forEach(a -> a.destroy());
        this.gridManager.getIsolatedBubbles().forEach(a -> a.destroy());
    }

    private boolean canExplode() {
        return this.getBubblesToExplode(this.shootingBubble, new HashSet<Bubble>()).size() > 2;
    }

    private List<Bubble> getNeighboursToExplode(final Bubble bubble) {
        return this.gridManager.getBubbleNeighbours(bubble).stream()
                                                           .filter(a -> this.gridManager.areEquals(a, bubble))
                                                           .collect(Collectors.toList());
     }

    private Set<Bubble> getBubblesToExplode(final Bubble bubble, final Set<Bubble> bubblesToPop) {
        this.getNeighboursToExplode(bubble).stream()
                                           .filter(a -> !bubblesToPop.contains(a) && bubblesToPop.add(a))
                                           .forEach(a -> getBubblesToExplode(a, bubblesToPop));
        return bubblesToPop;
       }

    private Set<Point2D> getFreePlacesToLink() {
        return this.gridManager.getNeighbourPosition(this.basicBubble).stream()
                                                                      .filter(a -> !this.gridManager.getBubbleNeighbours(this.basicBubble)
                                                                      .stream()
                                                                      .anyMatch(b -> b.getPosition().equals(a)))
                                                                      .filter(a -> a.getX() >= shootingBubble.getRadius() && a.getX() 
                                                                      <= GameCostants.GUIWIDTH.getValue() - shootingBubble.getRadius())
                                                                      .collect(Collectors.toSet());
     }

    private Point2D getPositionToLink() {
        if (this.getFreePlacesToLink().size() > 1) {
            return this.getFreePlacesToLink().stream()
                                             .min((a, b) -> Math.abs(shootingBubble.getPosition().getX() - a.getX()) 
                                                          + Math.abs(shootingBubble.getPosition().getY() - a.getY())
                                                          < Math.abs(shootingBubble.getPosition().getX() - b.getX())
                                                          + Math.abs(shootingBubble.getPosition().getY() - b.getY()) ? -1 : 1).get();
       } else {
             return this.getFreePlacesToLink().iterator().next();
        }
    }
}
