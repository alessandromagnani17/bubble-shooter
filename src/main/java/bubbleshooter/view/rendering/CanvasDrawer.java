package bubbleshooter.view.rendering;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.stream.Collectors;
import java.util.Map;
import bubbleshooter.model.gameobject.Bubble;
import bubbleshooter.model.gameobject.BubbleColor;
import bubbleshooter.view.images.ImagePath;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class CanvasDrawer {

    private final Canvas canvas;
    private static final Map<BubbleColor, ImagePath> COLOR_MAP;

    static {
       COLOR_MAP = Map.of(BubbleColor.BLUE, ImagePath.BLUE_BUBBLE, BubbleColor.GREEN, ImagePath.GREEN_BUBBLE,
                BubbleColor.PURPLE, ImagePath.PURPLE_BUBBLE, BubbleColor.RED, ImagePath.RED_BUBBLE,
                BubbleColor.LIGHT_BLUE, ImagePath.LIGHT_BLUE_BUBBLE, BubbleColor.YELLOW, ImagePath.YELLOW_BUBBLE);
    }

    public CanvasDrawer(final Canvas canvas) {
        this.canvas = canvas;
    }

	private Sprite generateSprite(Bubble bubble) {
		Sprite sprite = new SpriteImpl(this.canvas.getGraphicsContext2D());
		try {
			sprite.setSource(COLOR_MAP.get(bubble.getColor()));
			sprite.setPosition(bubble.getPosition());
			sprite.setHeigth(Bubble.getRadius() * 2);
			sprite.setWidth(Bubble.getRadius() * 2);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sprite;
    }

    public final Canvas getCanvas() {
        return canvas;
    }

    public final void draw(final List<Bubble> bubbles) {
		final GraphicsContext gc = this.canvas.getGraphicsContext2D();
		this.createSpriteList(bubbles).forEach(s -> {
			try {
				gc.save();
				s.draw();
				gc.restore();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		});
	}

	private List<Sprite> createSpriteList(final List<Bubble> bubbles) {
		return bubbles.stream().map(this::generateSprite).collect(Collectors.toList());
	}

}
