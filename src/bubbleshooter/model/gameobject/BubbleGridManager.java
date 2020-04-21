package bubbleshooter.model.gameobject;


import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import bubbleshooter.utility.GameCostants;
import javafx.geometry.Point2D;


public class BubbleGridManager {

    private int createdRows;
    private boolean offsetRow; 
    private GameObjectManager gameObjectManager; 
    private GameObjectFactory gameObjectFactory; 

    public BubbleGridManager(final GameObjectManager gameObjectManager) {
        this.gameObjectManager = gameObjectManager;
        this.createdRows = 0;
        this.offsetRow = false; 
        this.gameObjectFactory = new GameObjectFactory();
    }

    public final List<GameObject> getBubbleNeighbours(final GameObject bubble) {
       return this.getBubbleGrid().stream()
                                  .filter(a -> this.isNear(a, bubble))
                                  .collect(Collectors.toList());
    }

    // crea una nuova riga in cima
    public final List<GameObject> createNewRow() {
        List<GameObject> newRow = new LinkedList<>();
        this.dropBubble();
        double offset = this.offsetRow ? GameCostants.BUBBLE_WIDTH.getValue() : GameCostants.BUBBLE_WIDTH.getValue() / 2;
        for (double x = 0; x < GameCostants.ROW_BUBBLE.getValue(); x++) {
            newRow.add((GameObject) (gameObjectFactory.createBasicBubble(
                    new Point2D(x * GameCostants.BUBBLE_WIDTH.getValue() + offset,
                            GameCostants.BUBBLE_HEIGTH.getValue() / 2))));
        }

        this.createdRows++;
        this.offsetRow = !this.offsetRow;
        return newRow;
    }

    public final double getDistanceBetweenBubbles(final GameObject bubbleAt, final GameObject bubbleTo) {
        Point2D bubbleAtPos = bubbleAt.getPosition();
        Point2D bubbleToPos = bubbleTo.getPosition();
        return  Math.sqrt(Math.pow(bubbleAtPos.getX() - bubbleToPos.getX(), 2) 
                + (Math.pow(bubbleAtPos.getY() - bubbleToPos.getY(), 2)));
    }

    //tira le palline una riga più in giù
    private void dropBubble() {
        this.getBubbleGrid().stream()
        .forEach(b -> b.setPosition(new Point2D(b.getPosition().getX(), b.getPosition().getY() + GameCostants.BUBBLE_HEIGTH.getValue())));
    }

    public final boolean isNear(final GameObject bubbleAt, final GameObject bubbleTo) {
        return this.getDistanceBetweenBubbles(bubbleAt, bubbleTo) <= 45
                && this.getDistanceBetweenBubbles(bubbleAt, bubbleTo) > 0;
    }

    private List<GameObject> getLinkedBubbles(final GameObject starting, final List<GameObject> linkedBubbles) {
    	this.getBubbleNeighbours(starting).stream()
    		                              .filter(a -> !linkedBubbles.contains(a) && !a.isDestroyed() && linkedBubbles.add(a))
    				                      .forEach(a -> this.getLinkedBubbles(a, linkedBubbles));
    	return linkedBubbles;
    }
    
    public final List<GameObject> getIsolatedBubbles() {
    	List<GameObject> firstLineBubbles = this.getBubbleGrid().stream()
    												   .filter(a ->  a.getPosition().getY() == GameCostants.BUBBLE_HEIGTH.getValue() / 2
    												    && !a.isDestroyed())
    									               .collect(Collectors.toList());
    	Set<GameObject> linkedBubbles = new HashSet<GameObject>();
    	linkedBubbles.addAll(firstLineBubbles);
    	for (GameObject bubble : firstLineBubbles) {
    		linkedBubbles.addAll(this.getLinkedBubbles(bubble, new LinkedList<GameObject>()));
    	}
    	return this.getBubbleGrid().stream()
    				               .filter(a -> !linkedBubbles.contains(a))
    						       .collect(Collectors.toList());
    }

    public final List<GameObject> getBubbleGrid() {
        return this.gameObjectManager.getGameObjects().stream()
                .filter(o -> o.getType().equals(GameObjectsTypes.BASICBUBBLE))
                .collect(Collectors.toList()); 
    }

    public final Set<Point2D> getNeighbourPosition(final GameObject bubble) {
        Point2D bubblePos = bubble.getPosition();
        return Set.of(new Point2D(bubblePos.getX() - GameCostants.BUBBLE_WIDTH.getValue(), bubblePos.getY()),
                      new Point2D(bubblePos.getX() + GameCostants.BUBBLE_WIDTH.getValue(), bubblePos.getY()),
                      new Point2D(bubblePos.getX() - GameCostants.BUBBLE_WIDTH.getValue() / 2, bubblePos.getY() - GameCostants.BUBBLE_HEIGTH.getValue()),
                      new Point2D(bubblePos.getX() + GameCostants.BUBBLE_WIDTH.getValue() / 2, bubblePos.getY() - GameCostants.BUBBLE_HEIGTH.getValue()),
                      new Point2D(bubblePos.getX() - GameCostants.BUBBLE_WIDTH.getValue() / 2, bubblePos.getY() + GameCostants.BUBBLE_HEIGTH.getValue()),
                      new Point2D(bubblePos.getX() + GameCostants.BUBBLE_WIDTH.getValue() / 2, bubblePos.getY() + GameCostants.BUBBLE_HEIGTH.getValue()));
    }

    public final int getCreatedRows() {
        return this.createdRows; 
    }

    public final void removeBubble(final GameObject bubble) {
        this.gameObjectManager.removeGameObject(bubble);
    }

    public final boolean areEquals(final GameObject a, final GameObject b) {
        return a.getColor().equals(b.getColor());
    }

    public final GameObject addToGrid(final GameObject bubble, final Point2D position) {
        GameObject bubbleToAdd = new BasicBubble(position);
        bubbleToAdd.setProperty(bubble.getColor());
        this.gameObjectManager.addGameObject(Collections.singletonList(bubbleToAdd));
    	this.gameObjectManager.reloadShootingBubble();
        return bubbleToAdd;
    }
    
    public final boolean isOffsetRaw() {
    	return this.offsetRow;
    }
}
