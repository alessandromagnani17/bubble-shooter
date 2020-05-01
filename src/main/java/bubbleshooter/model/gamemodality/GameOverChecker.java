package bubbleshooter.model.gamemodality;

import bubbleshooter.model.gameobject.Bubble;
import bubbleshooter.model.gameobject.BubbleType;

public class GameOverChecker {

    private static final double LIMITS = 450.0;
	private AbstractGameMode gameMode;

	public GameOverChecker(final AbstractGameMode gameMode) {
		super();
		this.gameMode = gameMode;
	}

	public final boolean checkGameOver() {

		for (Bubble bubble : gameMode.getCurrentBubbles()) {
	        if (bubble.getType().equals(BubbleType.GRID_BUBBLE)) {
	            if (bubble.getPosition().getY() > LIMITS) {
	                return true;
	            }
	        }
	    }
	    return false;
	}

}
