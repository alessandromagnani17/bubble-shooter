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
    
    
    
    public BubbleGridManager() {
        this.createdRows = 0;
        this.offsetRow = false; 
    }

    public List<GameObject> createBubbleGrid(){
        List<GameObject> grid = new LinkedList<GameObject>();
        for(int i = 0; i < GameCostants.ROWS.getValue(); i++) {
            grid.addAll(this.createNewRow()); 
            this.createdRows++; 
        }
        return grid; 
    }
    
    public List<GameObject> getBubbleNeighbours(GameObject bubble){
        //todo
        return null; 
    }
    
    //crea una nuova riga in cima
    private List<GameObject> createNewRow(){
        List<GameObject> newRow = new LinkedList<>();
        double offset = this.offsetRow ? 45 : 30;  
        this.dropBubble();
        for (double x = 0; x < 10 ; x++) {
            newRow.add(gameObjectFactory.createBasicBubble
                    (new Point2D(x * GameCostants.BUBBLE_WIDTH.getValue() + offset, GameCostants.BUBBLE_HEIGTH.getValue()))); 
        }
        this.offsetRow = !this.offsetRow;
        return newRow; 
    }
        
    //tira le palline una riga più in giù
    private void dropBubble() {
        this.getBubbleGrid().stream()
        .forEach(b -> b.setPosition
                (new Point2D(b.getPosition().getX(), b.getPosition().getY() + GameCostants.BUBBLE_HEIGTH.getValue())));
    }
    
    //ritorna le pallina della griglia
    private List<GameObject> getBubbleGrid(){
        return this.gameObjectManager.getGameObjects().stream()
                .filter(o -> o.getType() == GameObjectsTypes.BASICBUBBLE)
                .collect(Collectors.toList()); 
    }
    
    public int getCreatedRows() {
        return this.createdRows; 
    }
    
    
    
    

}
