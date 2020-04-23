package bubbleshooter.model.collision;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import bubbleshooter.utility.GameCostants;
import javafx.geometry.Point2D;
import bubbleshooter.model.gamemodality.LevelTypes;
import bubbleshooter.model.gameobject.Bubble;
import bubbleshooter.model.gameobject.BubbleGridManager;
import bubbleshooter.model.gameobject.GridBubble;
import bubbleshooter.model.gameobject.ShootingBubble;

public class GridCollisionHandler implements CollisionHandler {

    private Bubble shootingBubble;
    private final Bubble basicBubble;
    private final BubbleGridManager gridManager;
    private final LevelTypes levelType;

    public GridCollisionHandler(final Collision collision, final BubbleGridManager gridManager, final LevelTypes levelType) {
        this.shootingBubble = collision.getShootingBubble();
        this.basicBubble  = collision.getCollided();
        this.gridManager = gridManager;
        this.levelType = levelType;
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

    private Point2D getPositionToLink() {
      if (this.getFreePlacesToLink().size() > 1) {
      return this.getFreePlacesToLink()
                                .stream()
                                .min((a, b) -> Math.abs(shootingBubble.getPosition().getX() - a.getX()) + Math.abs(shootingBubble.getPosition().getY() - a.getY())
                                             < Math.abs(shootingBubble.getPosition().getX() - b.getX()) + Math.abs(shootingBubble.getPosition().getY() - b.getY()) ? -1 : 1)
                                .get();
      } else {
            return this.getFreePlacesToLink().iterator().next();
      }
    }

    private Set<Point2D> getFreePlacesToLink() {
       return this.gridManager.getNeighbourPosition(this.basicBubble)
                                                       .stream()
                                                       .filter(a -> !this.gridManager.getBubbleNeighbours(this.basicBubble)
                                                                                     .stream()
                                                                                     .anyMatch(b -> b.getPosition().equals(a)))
                                                       .filter(a -> a.getX() >= GameCostants.BUBBLE_WIDTH.getValue() / 2 && a.getX() <= GameCostants.GUIWIDTH.getValue() - GameCostants.BUBBLE_WIDTH.getValue()/2)
                                                       .collect(Collectors.toSet());
    }

    private void explode() {
            this.getBubblesToExplode(this.shootingBubble, new HashSet<>()).stream().forEach(a -> a.destroy());
            this.gridManager.getIsolatedBubbles().forEach(a -> a.destroy());
    }


    private Set<Bubble> getBubblesToExplode(final Bubble bubble, final Set<Bubble> bubblesToPop) {
     this.getNeighboursToExplode(bubble).stream()
                                        .filter(a -> !bubblesToPop.contains(a) && bubblesToPop.add(a))
                                        .forEach(a -> getBubblesToExplode(a, bubblesToPop));
     return bubblesToPop;
    }

    private List<Bubble> getNeighboursToExplode(final Bubble bubble) {
        return this.gridManager.getBubbleNeighbours(bubble).stream()
                                                           .filter(a -> this.gridManager.areEquals(a, bubble))
                                                           .collect(Collectors.toList());
     }

    private boolean canExplode() {
        return  this.getBubblesToExplode(this.shootingBubble, new HashSet<Bubble>()).size() > 2;
    }

}
