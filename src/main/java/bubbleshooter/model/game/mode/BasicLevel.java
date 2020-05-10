package bubbleshooter.model.game.mode;

import bubbleshooter.model.game.GameInfoManager;
import bubbleshooter.model.game.GameType;

public class BasicLevel extends AbstractLevel {

    private static final int BUBBLE_SCORE = 20;
    private static final int WRONG_SHOTS_BEFORE_NEW_ROW = 5;

    public BasicLevel() {
        this.setCurrentGameType(GameType.BASICMODE);
    }

    @Override
    public final void updateScore(final double elapsed) {
        final GameInfoManager infoManager = this.getGameInfoManager();
        infoManager.updateScore(infoManager.getDestroyedBubbles() * BUBBLE_SCORE);
    }

    @Override
    public final boolean isTimeToNewRow(final double elapsed) {
        final GameInfoManager infoManager = this.getGameInfoManager();
        if (infoManager.getWrongShoots() == WRONG_SHOTS_BEFORE_NEW_ROW) {
            infoManager.clearWrongShoots();
            return true;
        }
        return false;
    }
}
