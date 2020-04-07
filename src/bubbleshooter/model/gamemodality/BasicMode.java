package bubbleshooter.model.gamemodality;

import java.util.List;
import bubbleshooter.model.collision.CollisionController;
import bubbleshooter.model.gameobject.GameObject;
import bubbleshooter.model.gameobject.GameObjectManager;
import bubbleshooter.model.gameobject.bubble.BubbleGridManager;


public class BasicMode implements GameModality {

    private GameObjectManager gameObjectManager;
    private BubbleGridManager gridManager;
    private CollisionController collisionController;
    private GameStatus status = GameStatus.PAUSE;
    //gameDataManager per gestire punteggio

    @Override
    public void startLevel() {
        this.gameObjectManager = new GameObjectManager();
        this.gridManager = new BubbleGridManager(this.gameObjectManager);
        this.collisionController = new CollisionController(this);
        this.status = GameStatus.RUNNING;
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
    public GameObjectManager getGameObjectManager() {
        return this.gameObjectManager;
    }

    @Override
    public BubbleGridManager getGridManager() {
        return this.gridManager;
    }
    
    

}
