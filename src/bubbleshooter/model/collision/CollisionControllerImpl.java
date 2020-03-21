package bubbleshooter.model.collision;

import java.util.List;

import bubbleshooter.model.gameobject.GameObject;

public class CollisionControllerImpl implements CollisionController {

    @Override
    public void checkCollisions(final List<GameObject> gameObjects) {
        //NON SO SE MI SERVE UN METODO PER CONTROLLARE TUTTE LE POSSIBILI COLLISIONI
        // OPPURE CONTROLLARLE SINGOLARMENTE CON hasCollided()
    }

    @Override
    public boolean hasCollided(final GameObject a, final GameObject b) {
        return a.getCollisionBox().intersects(b.getCollisionBox());
    }

    @Override
    public List<GameObject> getCollidedObjects() {
        // TODO Auto-generated method stub
        return null;
    }

}
