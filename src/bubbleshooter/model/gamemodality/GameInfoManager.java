package bubbleshooter.model.gamemodality;

public class GameInfo {

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

	public void addWrongShoots() {
		this.wrongShoots += 1;
	}

	public void updateScore(int score) {
		this.score += score;
	}

	public double getGameTime() {
		return gameTime;
	}

	public int getDestroyedBubbles() {
		return destroyedBubbles;
	}

	public int getWrongShoots() {
		return wrongShoots;
	}

	public int getScore() {
		return score;
	}

}
