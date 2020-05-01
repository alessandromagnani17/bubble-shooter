package bubbleshooter.model.component;

import bubbleshooter.model.gameobject.Bubble;

public interface Component {

    void update(double elapsed);

    void setContainer(Bubble parent);

    void setType(ComponentType type);

    Bubble getContainer();

    ComponentType getComponentType();
}
