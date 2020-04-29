package bubbleshooter.model.component;

import bubbleshooter.model.gameobject.Bubble;

public interface Component {

    void update(double elapsed);

    void setContainer(Bubble parent);

    Bubble getContainer();

    ComponentType getComponentType();

    void setType(ComponentType type);
}
