package bubbleshooter.view.rendering;

import java.io.FileNotFoundException;
import javafx.geometry.Point2D;
import bubbleshooter.view.images.ImagePath;

public interface Sprite {
	
	/**
	 * Draws the {@link Sprite}.
	 */
	void draw();

	/**
	 * Sets the position.
	 * @param coordinate
	 */
	void setPosition(Point2D coordinate);

	/**
	 * Sets the image.
	 * @param source
	 * @throws FileNotFoundException
	 */
	void setSource(ImagePath source) throws FileNotFoundException;

	/**
	 * Sets the height.
	 * @param height
	 */
	void setHeight(double height);

	void setWidth(double width);

	Point2D getPosition();

	double getWidth();

	double getHeight();

}
