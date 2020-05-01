package bubbleshooter.view.rendering;

import java.io.FileNotFoundException;

import com.sun.javafx.scene.paint.GradientUtils.Point;

import javafx.geometry.Point2D;
import bubbleshooter.utility.GameCostants;
import bubbleshooter.view.images.ImageLoader;
import bubbleshooter.view.images.ImagePath;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.transform.Rotate;

public class SpriteImpl implements Sprite {

	private static final double DEFAULT = GameCostants.RADIUS.getValue() * 2;
	private final GraphicsContext gc;
	private double heigth;
	private double width;
	private Point2D position;
	private Image image;

	public SpriteImpl(final GraphicsContext gc) {
		this.gc = gc;
	}

	@Override
	public void draw() {
		this.gc.drawImage(this.image, this.getTopLeftFromCenter(this.getPosition()).getX(),
				this.getTopLeftFromCenter(this.getPosition()).getY(), this.getWidth(), this.getHeigth());

	}

	private Point2D getTopLeftFromCenter(Point2D center) {
		return new Point2D(this.position.getX() - (this.getWidth() / 2), this.position.getY() - (this.getHeigth() / 2));
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
		this.image = ImageLoader.getLoader().getImage(source);

	}

	public Image getSource() {
		return this.image;

	}

	@Override
	public double getWidth() {
		return this.width;
	}

	@Override
	public double getHeigth() {
		return this.heigth;
	}

	@Override
	public void setHeigth(double heigth) {
		this.heigth = heigth;

	}

	@Override
	public void setWidth(double width) {
		this.width = width;
	}

}
