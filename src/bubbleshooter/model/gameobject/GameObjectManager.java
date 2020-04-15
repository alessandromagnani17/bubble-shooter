package bubbleshooter.model.gameobject;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;


public class GameObjectManager {

    private List<GameObject> gameObjects;

    public GameObjectManager() {
        this.gameObjects = new LinkedList<>();
    } 

    public final void update(final double elapsed) {
        this.gameObjects.forEach(x -> x.update(elapsed));
    }

    public final void addGameObject(final List<GameObject> gObj) {
        this.gameObjects.addAll(gObj);
    }

    public final void removeGameObject(final GameObject gObj) {
        this.gameObjects.remove(gObj);
    }

    public final GameObject getShootingBubble() {
        return this.gameObjects.stream().filter(a -> a.getType().equals(GameObjectsTypes.SHOOTINGBUBBLE)).findAny().get();
    }

    public final List<GameObject> getGameObjects() {
        return Collections.unmodifiableList(gameObjects); 
    }

}

