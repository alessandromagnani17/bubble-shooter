package bubbleshooter.model.gamemodality;

import bubbleshooter.model.collision.CollisionController;
import bubbleshooter.model.collision.CollisionControllerImpl;
import bubbleshooter.model.gameobject.GameObjectManager;

public class BasicMode implements GameModality {

    private GameObjectManager gameObjectManager;
    private CollisionController collisionController;
    private GameStatus status = GameStatus.PAUSE;
    // gameDataManager per gestire punteggio

    public BasicMode() {
        this.gameObjectManager = new GameObjectManager();
        this.collisionController = new CollisionControllerImpl();
        this.status = GameStatus.PAUSE;
    }

    @Override
    public void start() {
        this.status = GameStatus.RUNNING;
        this.initGameObjectsManager();
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
