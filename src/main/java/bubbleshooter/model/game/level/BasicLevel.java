package bubbleshooter.model.game.level;

import bubbleshooter.model.game.GameData;

public class BasicLevel extends AbstractLevel {

    private static final int BUBBLE_SCORE = 20;
    private static final int WRONG_SHOTS_BEFORE_NEW_ROW = 5;

    public BasicLevel() {
        this.setLevelType(LevelType.BASICMODE);
    }

    @Override
    public final void updateScore(final double elapsed) {
        final GameData infoManager = this.getGameData();
        infoManager.updateScore(infoManager.getDestroyedBubbles() * BUBBLE_SCORE);
    }

    @Override
    public final boolean isTimeToNewRow(final double elapsed) {
        final GameData infoManager = this.getGameData();
        if (infoManager.getWrongShoots() == WRONG_SHOTS_BEFORE_NEW_ROW) {
            infoManager.clearWrongShoots();
            return true;
        }
        return false;
    }
}
