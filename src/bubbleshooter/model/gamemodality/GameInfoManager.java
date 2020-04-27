package bubbleshooter.model.gamemodality;

public class GameInfoManager {

	private double gameTime;
	private int destroyedBubbles;
	private int wrongShoots;
	private int score;

	public void updateGameTime(double elapsed) {
		this.gameTime += elapsed;
	}

	public void addDestroyedBubble() {
		this.destroyedBubbles += 1;
	}

	// tiri sbagliati consecutivamente
	public void addWrongShoots() {
		this.wrongShoots += 1;
	}

	public void updateScore(int score) {
		this.score += score;
	}

	public int getGameTime() {
		return (int)gameTime;
	}

	public int getDestroyedBubbles() {
		return destroyedBubbles;
	}

	public int getWrongShoots() {
		return wrongShoots;
	}
	
	public void clearWrongShoots() {
		this.wrongShoots = 0; 
	}

	public int getScore() {
		return score;
	}

}
