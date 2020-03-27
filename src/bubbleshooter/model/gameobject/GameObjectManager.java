package bubbleshooter.model.gameobject;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class GameObjectManager {
    
    private List<GameObject> gameObjects;

    public GameObjectManager() {
        this.gameObjects = new LinkedList<>();
    } 
    
    public final void update(final double elapsed) {
        this.gameObjects.forEach(x -> x.update(elapsed));
    }

    public final void addGameObject(final GameObject gObj) {
        this.gameObjects.add(gObj);
    }
    
    
    public final List<GameObject> getGameObjects(){
        return Collections.unmodifiableList(gameObjects); 
    }
    
    public final  GameObject getGameObjectFromList(final GameObjectsTypes type) {
        return  this.gameObjects
                .stream()
                .filter(a -> a.getType().equals(type))
                .iterator().next();
    }
}
    
