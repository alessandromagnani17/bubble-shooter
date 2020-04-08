package bubbleshooter.model.gameobject;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import bubbleshooter.utility.GameCostants;
import javafx.geometry.Point2D;

public class BubbleGridManager {

    private int createdRows;
    private boolean offsetRow;
    private GameObjectManager gameObjectManager;
    private GameObjectFactory gameObjectFactory;

    public BubbleGridManager(GameObjectManager gameObjectManager) {

        this.createdRows = 0;
        this.offsetRow = false;
        this.gameObjectFactory = new GameObjectFactory();
        this.gameObjectManager = gameObjectManager;
    }

    public List<GameObject> getBubbleNeighbours(GameObject bubble) {
        // todo
        return null;
    }

    // crea una nuova riga in cima
    public List<GameObject> createNewRow() {
        List<GameObject> newRow = new LinkedList<>();
        this.dropBubble();
        double offset = this.offsetRow ? GameCostants.BUBBLE_WIDTH.getValue() : GameCostants.BUBBLE_WIDTH.getValue()/2;
        for (double x = 0; x < GameCostants.ROW_BUBBLE.getValue(); x++) {
            newRow.add((GameObject)(gameObjectFactory.createBasicBubble(
                    new Point2D(x * GameCostants.BUBBLE_WIDTH.getValue() + offset,
                            GameCostants.BUBBLE_HEIGTH.getValue()/2))));
        }
        
        this.createdRows++;
        this.offsetRow = !this.offsetRow;
        return newRow;
    }

    // tira le palline una riga più in giù
    private void dropBubble() {
        
       
        //this.getBubbleGrid().stream().forEach(b -> b.setPosition(
               // new Point2D(b.getPosition().getX(), b.getPosition().getY() + GameCostants.BUBBLE_HEIGTH.getValue())));
        this.getBubbleGrid().stream()
        .forEach(b -> {
            b.setPosition(b.getPosition().add(new Point2D(0, GameCostants.BUBBLE_HEIGTH.getValue()))); 
        });
        
    }

    // ritorna le pallina della griglia
     public List<GameObject> getBubbleGrid() {
        return this.gameObjectManager.getGameObjects().stream().filter(o -> o.getType() == GameObjectsTypes.BASICBUBBLE)
                .collect(Collectors.toList());
    }

    public int getCreatedRows() {
        return this.createdRows;
    }

}
