package bubbleshooter.view.rendering;

import java.io.FileNotFoundException;
import javafx.geometry.Point2D;
import bubbleshooter.view.images.ImagePath;

public interface Sprite {
	
	void draw();

	void setPosition(Point2D coordinate);

	void setSource(ImagePath source) throws FileNotFoundException;

	void setHeigth(double heigth);

	void setWidth(double width);

	Point2D getPosition();

	double getWidth();

	double getHeigth();

}
