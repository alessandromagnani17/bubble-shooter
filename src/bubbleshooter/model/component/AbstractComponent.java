package bubbleshooter.model.component;

import bubbleshooter.model.gameobject.GameObject;

public abstract class AbstractComponent implements Component {

    private GameObject container;
    private ComponentType type;

    public AbstractComponent(final ComponentType type) {
        this.type = type;
    }

    @Override
    public void update(final double elapsed) {
    }

    @Override
    public final void setContainer(final GameObject container) {
        this.container = container;
    }

    @Override
    public final GameObject getContainer() {
        return this.container;
    }

    @Override
    public final ComponentType getComponentType() {
        return this.type;
    }
}
