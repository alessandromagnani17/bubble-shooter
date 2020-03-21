package bubbleshooter.model.collision;

import java.util.List;

import bubbleshooter.model.gameobject.GameObject;

public interface CollisionController {

   void checkAllCollisions(List<GameObject> gameObjects);

}
