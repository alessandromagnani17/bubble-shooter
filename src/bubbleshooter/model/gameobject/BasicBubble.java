package bubbleshooter.model.gameobject;

import java.util.Collection;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.locationtech.jts.geom.Geometry;
import org.locationtech.jts.math.Vector2D;
import org.locationtech.jts.util.GeometricShapeFactory;

import bubbleshooter.view.images.Color;

public class BasicBubble extends AbstractGameObject implements Bubble {

    private final double radius = 10;
    private Map<Direction, Optional<Bubble>> connections = new HashMap<>();
    private Color color;
    private Geometry shape;

    public BasicBubble(final Vector2D position, final Color color) {
        super.setPosition(position);
        this.color = color;
        super.setHeigth(20); //DA MODIFICARE
        super.setWidth(20); //DA MODIFICARE
        this.shape = this.setCollisionBox();
    }

    @Override
    public void connectBoth(final Direction direction, final Optional<Bubble> bubbleToConnect) {
        this.setBubbleAt(direction, bubbleToConnect);
        if (bubbleToConnect.isPresent()) {
            bubbleToConnect.get().setBubbleAt(direction.opposite(), Optional.of(this));
        }
    }

    @Override
    public  Optional<Bubble> getBubbleAt(final Direction direction) {
        return this.connections.get(direction).isPresent() ? this.connections.get(direction) : Optional.empty(); 
    }

    @Override
    public void setBubbleAt(final Direction direction, final Optional<Bubble> bubble) {
        if (!bubble.isPresent()) {
            this.connections.put(direction, Optional.empty());
        } else {
            this.connections.put(direction, bubble);
        }
    }

    @Override
    public boolean hasBubbleAt(final Direction direction) {
        return this.connections.get(direction).isPresent();
    }

    @Override
    public void setColor(final Color bubbleColor) {
        this.color = bubbleColor;
    }

    @Override
    public Color getColor() {
        return this.color;
    }

    @Override
    public Collection<Bubble> getNeighbours() {
        return this.connections.values()
                .stream()
                .filter(a -> a.isPresent())
                .map(a -> a.get())
                .collect(Collectors.toSet());
    }

    @Override
    public Map<Direction, Optional<Bubble>> getConnections() {
        return this.connections;
    }

    @Override
    public Geometry setCollisionBox() {
        final GeometricShapeFactory shapeFactory = new GeometricShapeFactory();
        shapeFactory.setWidth(super.getWidth());
        shapeFactory.setHeight(super.getHeight());
        return shapeFactory.createCircle();
    }

    @Override
    public Geometry getCollisionBox() {
        return this.shape;
    }


}
