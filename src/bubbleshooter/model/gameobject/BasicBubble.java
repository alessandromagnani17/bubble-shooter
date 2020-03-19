package bubbleshooter.model.gameobject;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.locationtech.jts.geom.Geometry;
import org.locationtech.jts.util.GeometricShapeFactory;

import bubbleshooter.view.images.Color;
import javafx.geometry.Point2D;

public class BasicBubble extends AbstractGameObject implements Bubble {

    private final double radius = 10;
    private Map<Direction, Optional<Bubble>> connections = new HashMap<>();
    private Color color;
    private Geometry shape;

    public BasicBubble(final Point2D position, final Color color) {
        super.setPosition(position);
        this.color = color;
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
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public void setColor(final Color bubbleColor) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public Color getColor() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Collection<Bubble> getNeighbours() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Map<Direction, Optional<Bubble>> getConnections() {
        // TODO Auto-generated method stub
        return null;
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
