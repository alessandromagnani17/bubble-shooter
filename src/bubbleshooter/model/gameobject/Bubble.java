package bubbleshooter.model.gameobject;

import java.util.Collection;
import java.util.Map;
import java.util.Optional;

import bubbleshooter.view.images.Color;
import javafx.geometry.Point2D;

public interface Bubble {

    void connectBoth(Direction direction, Optional<Bubble> bubbleToConnect);

    Optional<Bubble> getBubbleAt(Direction direction);

    void setBubbleAt(Direction direction, Optional<Bubble> bubble);

    boolean hasBubbleAt(Direction direction);

    void setColor(Color bubbleColor);

    void setPosition(Point2D position);

    void update(double elapsed);

    Color getColor();

    Collection<Bubble> getNeighbours();

    Map<Direction, Optional<Bubble>> getConnections();

    String toString();

    Point2D getPosition();

}
