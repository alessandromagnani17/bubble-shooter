package bubbleshooter.view.rendering;

import java.util.List;
import java.util.stream.Collectors;
import java.util.Map;
import bubbleshooter.model.bubble.Bubble;
import bubbleshooter.model.bubble.BubbleColor;
import bubbleshooter.view.images.ImagePath;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;

public class BubbleDrawer {

	private final Canvas canvas;
	private final Map<BubbleColor, ImagePath> colorMap = Map.of(BubbleColor.BLUE, ImagePath.BLUE_BUBBLE,
			BubbleColor.GREEN, ImagePath.GREEN_BUBBLE, BubbleColor.PURPLE, ImagePath.PURPLE_BUBBLE, BubbleColor.RED,
			ImagePath.RED_BUBBLE, BubbleColor.LIGHT_BLUE, ImagePath.LIGHT_BLUE_BUBBLE, BubbleColor.YELLOW,
			ImagePath.YELLOW_BUBBLE);

	public BubbleDrawer(final Canvas canvas) {
		this.canvas = canvas;
	}

	public final void draw(final List<Bubble> bubbles) {
		final GraphicsContext gc = this.canvas.getGraphicsContext2D();
		this.createSpriteList(bubbles).forEach(s -> {
			gc.save();
			s.draw();
			gc.restore();
		});
	}

	private Sprite generateSprite(Bubble bubble) {
		Sprite sprite = new BubbleSprite(this.canvas.getGraphicsContext2D());
		try {
			sprite.setSource(this.colorMap.get(bubble.getColor()));
			sprite.setPosition(bubble.getPosition());
			sprite.setHeight(bubble.getWidth());
			sprite.setWidth(bubble.getHeight());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sprite;
	}

	public final Canvas getCanvas() {
		return canvas;
	}


	private List<Sprite> createSpriteList(final List<Bubble> bubbles) {
		return bubbles.stream().map(this::generateSprite).collect(Collectors.toList());
	}

}
