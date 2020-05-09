package bubbleshooter.view.rendering;

import java.io.FileNotFoundException;
import javafx.geometry.Point2D;
import bubbleshooter.view.images.ImageLoader;
import bubbleshooter.view.images.ImagePath;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class BubbleSprite implements Sprite {

<<<<<<< HEAD:src/main/java/bubbleshooter/view/rendering/SpriteImpl.java
    private final GraphicsContext gc;
    private double heigth;
    private double width;
    private Point2D position;
    private Image image;

    public SpriteImpl(final GraphicsContext gc) {
        this.gc = gc;
    }

    @Override
    public final void draw() {
        this.gc.scale(1, -1);
        this.gc.drawImage(this.image, this.getTopLeftFromCenter(this.getPosition()).getX(),
                this.getTopLeftFromCenter(this.getPosition()).getY(), this.getWidth(), this.getHeigth());
    }

    private Point2D getTopLeftFromCenter(final Point2D center) {
        return new Point2D(this.position.getX() - (this.getWidth() / 2), this.position.getY() - (this.getHeigth() / 2));
    }

    @Override
    public final void setPosition(final Point2D coordinate) {
        this.position = coordinate;
    }

    @Override
    public final Point2D getPosition() {
        return this.position;
    }

    @Override
    public final void setSource(final ImagePath source) throws FileNotFoundException {
        this.image = ImageLoader.getImage(source);
    }

    public final Image getSource() {
        return this.image;
    }

    @Override
    public final double getWidth() {
        return this.width;
    }

    @Override
    public final double getHeigth() {
        return this.heigth;
    }

    @Override
    public final void setHeigth(final double heigth) {
        this.heigth = heigth;
    }

    @Override
    public final void setWidth(final double width) {
        this.width = width;
    }
=======
	private final GraphicsContext gc;
	private double heigth;
	private double width;
	private Point2D position;
	private Image image;

	public BubbleSprite(final GraphicsContext gc) {
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

>>>>>>> a08d0405b5852e285e466fbdd984491a0c2dab8e:src/main/java/bubbleshooter/view/rendering/BubbleSprite.java
}
