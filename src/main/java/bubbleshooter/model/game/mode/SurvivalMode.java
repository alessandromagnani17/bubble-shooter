package bubbleshooter.model.game.mode;

import bubbleshooter.model.game.GameInfoManager;
import bubbleshooter.model.game.GameType;

public class SurvivalMode extends AbstractGameMode {

    private static final int ONE_SECOND_SCORE = 20; 
    private static final int SECOND_BEFORE_NEW_ROW = 10; 

    private double timeLeft = SECOND_BEFORE_NEW_ROW; 

    public SurvivalMode() {
        this.setCurrentLevelTypes(GameType.SURVIVALMODE);
    }

    @Override
    public final void updateScore(final double elapsed) {
        final GameInfoManager infoManager = this.getGameInfoManager();
        infoManager.updateScore(infoManager.getGameTime() * ONE_SECOND_SCORE);
    }

    @Override
    public final boolean isTimeToNewRow(final double elapsed) {
        this.timeLeft -= elapsed / 1000;
        if (this.timeLeft <= 0) {
            this.timeLeft = SECOND_BEFORE_NEW_ROW; 
            return true;
        }
            return false;	
    }
}
