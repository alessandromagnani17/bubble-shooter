package bubbleshooter.model.gamemodality;

import java.util.LinkedList;
import java.util.List;
import bubbleshooter.model.collision.CollisionController;
import bubbleshooter.model.collision.CollisionControllerImpl;

import bubbleshooter.model.gameobject.Bubble;
import bubbleshooter.model.gameobject.Cannon;
import bubbleshooter.model.gameobject.GameObject;
import bubbleshooter.model.gameobject.GameObjectManager;


public class BasicMode implements GameModality{

    private GameObjectManager gameObjectManager;
    private CollisionController collisionController;
    private GameStatus status = GameStatus.PAUSE;
    //gameDataManager per gestire punteggio

    @Override
    public void startLevel() {
        this.collisionController = new CollisionControllerImpl(this, this.gameObjectManager);
        this.gameObjectManager = new GameObjectManager();
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

}
