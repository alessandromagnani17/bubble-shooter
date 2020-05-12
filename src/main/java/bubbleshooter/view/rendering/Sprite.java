package bubbleshooter.view.rendering;

import java.io.FileNotFoundException;
import javafx.geometry.Point2D;
import bubbleshooter.view.images.ImagePath;

/**
 * Represents an image that can be drawn on the screen at a certain position on
 * the screen.
 * 
 */
public interface Sprite {

    /**
     * Draws the {@link Sprite}.
     */
    void draw();

    /**
     * Sets the position.
     * 
     * @param coordinate
     */
    void setPosition(Point2D coordinate);

    /**
     * Sets the image.
     * 
     * @param source
     * @throws FileNotFoundException
     */
    void setSource(ImagePath source) throws FileNotFoundException;

    /**
     * Sets the height.
     * 
     * @param height
     */
    void setHeight(double height);

    /**
     * Sets the width.
     * 
     * @param width
     */
    void setWidth(double width);

    /**
     * Gets the position.
     * 
     * @return the potition
     */
    Point2D getPosition();

    /**
     * Gets the width.
     * 
     * @return width.
     */
    double getWidth();

    /**
     * Gets the height.
     * 
     * @return height.
     */
    double getHeight();

}
