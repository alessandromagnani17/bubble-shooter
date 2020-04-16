package bubbleshooter.model.collision;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import bubbleshooter.model.gameobject.GameObject;
import javafx.geometry.Point2D;
import bubbleshooter.model.gameobject.BubbleGridManager;

public class GridCollisionHandler implements CollisionHandler {

    private final GameObject visitor;
    private final GameObject acceptor;
    private final BubbleGridManager gridManager;

    public GridCollisionHandler(final GameObject visitor, final GameObject acceptor, final BubbleGridManager gridManager) {
        this.visitor = visitor;
        this.acceptor  = acceptor;
        this.gridManager = gridManager;
    }

    @Override
    public final void handle() {
        if (this.canExplode()) {
           this.explode();
       } else {
           this.linkToGrid();
       }
    }

    private void linkToGrid() {
        this.gridManager.addToGrid(this.visitor, this.getPositionToLink());
    }

    private Point2D getPositionToLink() {
      return this.getFreePlacesToLink()
                                .stream()
                                .min((a, b) -> Math.abs(visitor.getPosition().getX() - a.getX()) + Math.abs(visitor.getPosition().getY() - a.getY())
                                             < Math.abs(visitor.getPosition().getX() - b.getX()) + Math.abs(visitor.getPosition().getY() - b.getY()) ? -1 : 1)
                                .get();
    }

    private Set<Point2D> getFreePlacesToLink() {
       return this.gridManager.getNeighbourPosition(acceptor)
                                                       .stream()
                                                       .filter(a -> !this.gridManager.getBubbleNeighbours(acceptor)
                                                       .stream().anyMatch(b -> b.getPosition().equals(a)))
                                                       .collect(Collectors.toSet());
    }

    private void explode() {
    System.out.println("here");
    this.recursiveExplosion(acceptor, new HashSet<>()).stream()
                                                      .forEach(a -> a.destroy());
    }

    private Set<GameObject> recursiveExplosion(final GameObject bubble, final Set<GameObject> bubblesToExplode) {
         if (this.getNeighboursToExplode(bubble).isPresent()) {
             for (final GameObject toExplode : this.getNeighboursToExplode(bubble).get()) {
                 bubblesToExplode.add(toExplode);
                 this.recursiveExplosion(toExplode, bubblesToExplode);
             }
         }
         return bubblesToExplode;
    }

    private Optional<List<GameObject>> getNeighboursToExplode(final GameObject bubble) {
        return Optional.of(this.gridManager.getBubbleNeighbours(bubble).stream()
                                                           .filter(a -> this.gridManager.areEquals(a, bubble))
                                                           .collect(Collectors.toList()));
    }

    private boolean canExplode() {
        return this.gridManager.areEquals(acceptor, visitor) 
               && this.getNeighboursToExplode(acceptor).isPresent();
    }

}
