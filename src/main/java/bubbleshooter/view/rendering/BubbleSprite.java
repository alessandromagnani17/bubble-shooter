package bubbleshooter.view.rendering;

import java.io.FileNotFoundException;
import javafx.geometry.Point2D;
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
    public final void draw() {
        this.gc.drawImage(this.image, this.getTopLeftFromCenter().getX(), this.getTopLeftFromCenter().getY(),
                this.getWidth(), this.getHeight());
    }

    /**
     * Gets the top-left point of the image.
     * 
     * @param center of the {@link Bubble}.
     * @return the top-left point.
     */
    private Point2D getTopLeftFromCenter() {
        return new Point2D(this.position.getX() - (this.getWidth() / 2), this.position.getY() - (this.getHeight() / 2));
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
    public final double getHeight() {
        return this.height;
    }

    @Override
    public final void setHeight(final double height) {
        this.height = height;

    }

    @Override
    public final void setWidth(final double width) {
        this.width = width;
    }

}
