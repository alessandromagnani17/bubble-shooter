package bubbleshooter.model.game.mode;

import bubbleshooter.model.game.GameInfoManager;
import bubbleshooter.model.game.GameType;

public class SurvivalMode extends AbstractGameMode {

    private static final int ONE_SECOND_SCORE = 20; 
    private static final int TIME_LEFT_BEFORE_NEW_ROW = 10; 

    private double timeLeft; 

    public SurvivalMode() {
        this.setCurrentGameType(GameType.SURVIVALMODE);
        this.timeLeft = TIME_LEFT_BEFORE_NEW_ROW; 
    }

    @Override
    public final void updateScore(final double elapsed) {
        final GameInfoManager infoManager = this.getGameInfoManager();
        infoManager.updateScore(infoManager.getGameTime() * ONE_SECOND_SCORE);
    }

    @Override
    public final boolean isTimeToNewRow(final double elapsed) {
        this.timeLeft -= elapsed;
        if (this.timeLeft <= 0) {
            this.timeLeft = TIME_LEFT_BEFORE_NEW_ROW; 
            return true;
        }
        return false;	
    }
}
