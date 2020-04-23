package bubbleshooter.model.gameobject;

import java.util.LinkedList;
import java.util.List;
import bubbleshooter.model.component.CollisionComponent;
import javafx.geometry.Point2D;

public class GridBubble extends AbstractBubble {
	
	private List<Bubble> neighbours; 

	public GridBubble(final Point2D position) {
		super(BubbleType.GRID_BUBBLE, position);
		this.neighbours = new LinkedList<Bubble>();
		this.addComponent(new CollisionComponent());
	}

	public final List<Bubble> getNeighbours() {
		return this.neighbours;
	}

	public final void addNeighbours(final Bubble bubble) {
		this.neighbours.add(bubble); 
	}
	
	public final void removeNeighbours(final Bubble bubble) {
		this.neighbours.remove(bubble); 
	}
	

}
