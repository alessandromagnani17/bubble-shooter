package bubbleshooter.view.rendering;

import java.io.FileNotFoundException;
import javafx.geometry.Point2D;
import bubbleshooter.model.bubble.Bubble;
import bubbleshooter.view.images.ImageLoader;
import bubbleshooter.view.images.ImagePath;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class BubbleSprite implements Sprite {

	private final GraphicsContext gc;
	private double height;
	private double width;
	private Point2D position;
	private Image image;

	public BubbleSprite(final GraphicsContext gc) {
		this.gc = gc;

	}

	@Override
	public void draw() {
		this.gc.drawImage(this.image, this.getTopLeftFromCenter(this.getPosition()).getX(),
				this.getTopLeftFromCenter(this.getPosition()).getY(), this.getWidth(), this.getHeight());

	}
	/**
	 * Gets the top-left point of the image.
	 * @param center of the {@link Bubble}.
	 * @return the top-left point.
	 */
	private Point2D getTopLeftFromCenter(Point2D center) {
		return new Point2D(this.position.getX() - (this.getWidth() / 2), this.position.getY() - (this.getHeight() / 2));
	}

	@Override
	public void setPosition(Point2D coordinate) {
		this.position = coordinate;

	}

	@Override
	public Point2D getPosition() {
		return this.position;
	}

	@Override
	public void setSource(ImagePath source) throws FileNotFoundException {
		this.image = ImageLoader.getImage(source);

	}

	public Image getSource() {
		return this.image;

	}

	@Override
	public double getWidth() {
		return this.width;
	}

	@Override
	public double getHeight() {
		return this.height;
	}

	@Override
	public void setHeight(double height) {
		this.height = height;

	}

	@Override
	public void setWidth(double width) {
		this.width = width;
	}

}
