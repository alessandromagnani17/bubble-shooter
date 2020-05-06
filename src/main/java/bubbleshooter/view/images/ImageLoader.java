package bubbleshooter.view.images;

import java.util.Arrays;

import java.util.HashMap;
import java.util.Map;
import javafx.scene.image.Image;

/**
 * A simple image loader with caching.
 */

public class ImageLoader {

	private static final Map<ImagePath, Image> images = new HashMap<>();

	/**
	 * @param imagePath the path of the image to get.
	 * @return the image of the object required.
	 */
	public static Image getImage(final ImagePath imagePath) {
		return images.get(imagePath);
	}

	/**
	 * Loads all images.
	 */
	public static void loadAll() {
		Arrays.stream(ImagePath.values()).forEach(p -> images.put(p, loadImage(p.getPath())));

	}

	private static Image loadImage(final String imagePath) {
		return new Image(ImageLoader.class.getResourceAsStream(imagePath));
	}
}
