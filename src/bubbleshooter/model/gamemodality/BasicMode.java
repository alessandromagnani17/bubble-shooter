package bubbleshooter.model.gamemodality;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Stream;

import bubbleshooter.model.collision.CollisionController;
import bubbleshooter.model.collision.CollisionControllerImpl;
import bubbleshooter.model.gameobject.CreateGameObject;
import bubbleshooter.model.gameobject.GameObject;
import bubbleshooter.model.gameobject.GameObjectManager;

public class BasicMode implements GameModality {

    private GameObjectManager gameObjectManager;
    private CollisionController collisionController;
    private CreateGameObject creator; 
    private GameStatus status = GameStatus.PAUSE;
    // gameDataManager per gestire punteggio

    public BasicMode() {
        this.gameObjectManager = new GameObjectManager();
        this.collisionController = new CollisionControllerImpl();
        this.creator = new CreateGameObject(); 
        this.status = GameStatus.PAUSE;
    }

    @Override
    public void start() {
        this.status = GameStatus.RUNNING;
        this.initGameObjectsManager();
    }
    
    public List<GameObject>createGameObject() {
        List<GameObject> object = new LinkedList<>(); 
        object.addAll(creator.createBubbleGrid()); 
        //da aggiungere il resto dei gameObject
        return object; 
   }

    private void initGameObjectsManager() {
        this.gameObjectManager.update(0);
    }

    public GameObjectManager getGameObjectManager() {
        return this.gameObjectManager;
    }

    @Override
    public void update(final double elapsed) {
        if (this.status == GameStatus.RUNNING) {
            this.gameObjectManager.update(elapsed);

        }
    }

    @Override
    public void setGameStatus(final GameStatus status) {
        this.status = status;
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

}
