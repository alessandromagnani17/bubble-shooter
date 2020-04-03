package bubbleshooter.model.collision;

import bubbleshooter.model.gameobject.GameObject;
import bubbleshooter.model.gameobject.GameObjectManager;
import bubbleshooter.model.gameobject.bubble.BubbleGridManager;

public class GridCollisionHandler implements CollisionHandler {

    private GameObject shootingBubble;
    private GameObject bubbleCollided;
    private BubbleGridManager gridManager;

    public GridCollisionHandler(final GameObject shootingBubble, final GameObject bubbleCollided, final BubbleGridManager gridManager) {
        this.shootingBubble = shootingBubble;
        this.bubbleCollided = bubbleCollided;
        this.gridManager = gridManager;
    }

    @Override
    public void handle() {
        if (this.canExplode(shootingBubble, bubbleCollided)) {
           this.explode();
       } else {
           this.linkToGrid();
       }
    }

    private void linkToGrid() {
        
    }

    private void explode() {
        
    }

    private boolean canExplode(final GameObject bubbleAt, final GameObject bubbleTo) {
        return bubbleAt.getProperty().equals(bubbleTo.getProperty());
    }
}
