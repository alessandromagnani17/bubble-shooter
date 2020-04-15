package bubbleshooter.model.gamemodality;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import bubbleshooter.model.collision.CollisionController;
import bubbleshooter.model.gameobject.GameObject;
import bubbleshooter.model.gameobject.GameObjectFactory;
import bubbleshooter.model.gameobject.GameObjectManager;
import bubbleshooter.utility.GameCostants;
import javafx.geometry.Point2D;
import bubbleshooter.model.gameobject.BubbleGridManager;



public class BasicMode implements GameModality {

    private GameObjectManager gameObjectManager;
    private BubbleGridManager gridManager;
    private CollisionController collisionController;
    private BubbleGridManager bubbleGridManager; 
    private GameObjectFactory gameObjectFactory; 
    private GameStatus status = GameStatus.PAUSE;
    // gameDataManager per gestire punteggio

    public BasicMode() {
        this.gameObjectManager = new GameObjectManager(); 
        this.bubbleGridManager = new BubbleGridManager(this.gameObjectManager); 
        this.collisionController = new CollisionController(this);
        this.gameObjectFactory = new GameObjectFactory(); 
        this.status = GameStatus.PAUSE;
    }

    @Override
    public void start() {
        this.status = GameStatus.RUNNING;
        this.initGameObjectsManager();
        this.initGameObject(); 
        
    }

    public void initGameObject() {
       for (int i = 0; i < GameCostants.ROWS.getValue(); i++) {
           this.gameObjectManager.addGameObject(this.bubbleGridManager.createNewRow());
       }
       this.gameObjectManager.addGameObject
                       (Collections.singletonList
                                  (this.gameObjectFactory.createShootingBubble
                                          (new Point2D(GameCostants.GUIWIDTH.getValue()/2, 600))));
    }

    private void initGameObjectsManager() {
        this.gameObjectManager.update(0);
    }

    public GameObjectManager getGameObjectManager() {
        return this.gameObjectManager;
    }

    @Override
    public void update(final double elapsed) {
       this.gameObjectManager.update(elapsed);
       this.collisionController.checkCollisions();
    }

    @Override
    public void setGameStatus(final GameStatus status) {
        this.status = status;
    }

    @Override
    public List<GameObject> getCurrentGameObjects() {
        return this.gameObjectManager.getGameObjects();
    }

    @Override
    public void setGameOver() {
        this.setGameStatus(GameStatus.GAMEOVER);
    }

    @Override
    public CollisionController getCollisionController() {
        return this.collisionController;
    }

    @Override
    public GameStatus getGameStatus() {
        return this.status;
    }

    @Override
    public BubbleGridManager getGridManager() {
        return this.gridManager;
    }
    
    

}
