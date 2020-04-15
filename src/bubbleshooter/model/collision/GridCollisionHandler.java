package bubbleshooter.model.collision;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import bubbleshooter.model.gameobject.GameObject;
import bubbleshooter.model.gameobject.BubbleGridManager;

public class GridCollisionHandler implements CollisionHandler {

    private GameObject visitor;
    private GameObject acceptor;
    private BubbleGridManager gridManager;

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
        
    }

    private void explode() {
    this.recursiveExplosion(acceptor, new HashSet<>()).stream()
                                                      .forEach(a -> this.gridManager.removeBubble(a));
    }

    private Set<GameObject> recursiveExplosion(final GameObject bubble, final Set<GameObject> bubblesToExplode) {
         if (this.getNeighboursToExplode(bubble).isPresent()) {
             for (GameObject toExplode : this.getNeighboursToExplode(bubble).get()) {
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
