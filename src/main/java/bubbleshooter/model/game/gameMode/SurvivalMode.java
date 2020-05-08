package bubbleshooter.model.game.gameMode;

import bubbleshooter.model.game.GameInfoManager;
import bubbleshooter.model.game.GameType;

public class SurvivalMode extends AbstractGameMode {
	
	private static int ONE_SECOND_SCORE = 20; 
	private static int SECOND_BEFORE_NEW_ROW = 10; 
	
	private double timeLeft = SECOND_BEFORE_NEW_ROW; 

	public SurvivalMode() {
        this.setCurrentLevelTypes(GameType.SURVIVALMODE);
	}
	
	@Override
	public void updateScore(double elapsed) {
		GameInfoManager infoManager = this.getGameInfoManager();
		infoManager.updateScore(infoManager.getGameTime() * ONE_SECOND_SCORE);
	}

	@Override
	public boolean isTimeToNewRow(double elapsed) {
		this.timeLeft -= elapsed/1000;   
		if (this.timeLeft <= 0) {
			this.timeLeft = SECOND_BEFORE_NEW_ROW; 
			return true;
		}
		return false;	
	}
}
