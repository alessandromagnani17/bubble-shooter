package bubbleshooter.model.component;

import bubbleshooter.model.gameobject.GameObject;

public interface Component {

    void update(double elapsed);

    void setContainer(GameObject parent);
	
    GameObject getContainer();

    ComponentType getComponentType();
}
