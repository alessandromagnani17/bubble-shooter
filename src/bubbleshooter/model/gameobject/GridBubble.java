package bubbleshooter.model.gameobject;

import java.util.LinkedList;
import java.util.List;

import javafx.geometry.Point2D;

public class GridBubble extends AbstractBubble{
	
	private List<Bubble> neighbours; 

	public GridBubble(Point2D position) {
		super(BubbleType.GRID_BUBBLE, position);
		this.neighbours = new LinkedList<Bubble>(); 		
	}

	public List<Bubble> getNeighbours() {
		return this.neighbours;
	}

	public void addNeighbours(Bubble bubble) {
		this.neighbours.add(bubble); 
	}
	
	public void removeNeighbours(Bubble bubble) {
		this.neighbours.remove(bubble); 
	}
	

}
