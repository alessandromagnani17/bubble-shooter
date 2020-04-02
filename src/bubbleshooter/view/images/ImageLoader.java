package bubbleshooter.view.images;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.Map;

import javafx.scene.image.Image;



/**
 * A simple image loader with caching.
 */

public class ImageLoader {
    private static final ImageLoader SINGLETON = new ImageLoader();
    private final Map<ImagePath, Image> imageMap;

    /**
     * Simple constructor.
     */
    public ImageLoader() {
        this.imageMap = new EnumMap<>(ImagePath.class);
    }

    /**
     *
     * @return the {@link ImageLoader}.
     */
    public static ImageLoader getLoader() {
        return SINGLETON;
    }

    /**
     * @param imagePath the path of the image to get.
     * @return the image of the object required.
     */
    public Image getImage(final ImagePath imagePath) {
        if (imagePath.equals(ImagePath.BUBBLE) && !this.imageMap.containsKey(imagePath)) {
            final Image img = this.loadImage(Color.getRandomColor()); 
            this.imageMap.put(imagePath, img); 
        }
        return this.imageMap.get(imagePath);
    }

    /**
     * Loads all images.
     */
    public void loadAll() {
        Arrays.stream(ImagePath.values()).forEach(this::getImage);
    }


    private Image loadImage(final String imagePath) {
        return new Image(ImageLoader.class.getResourceAsStream(imagePath));
    }
}
