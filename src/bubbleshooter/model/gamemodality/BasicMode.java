package bubbleshooter.model.gamemodality;

public class BasicMode extends AbstractGameMode {
	
	private static int BUBBLE_SCORE = 20; 
	private static int WRONG_SHOTS_BEFORE_NEW_ROW = 5; 

	@Override
	public void updateScore(double elapsed) {
		GameInfoManager infoManager = this.getGameInfoManager(); 
		infoManager.updateScore(infoManager.getDestroyedBubbles() * BUBBLE_SCORE);
	}

	@Override
	public boolean isTimeToNewRow(double elapsed) {
		if (this.getGameInfoManager().getDestroyedBubbles() < WRONG_SHOTS_BEFORE_NEW_ROW) {
			return false; 
		}
		return true; 
	}
	   
}
